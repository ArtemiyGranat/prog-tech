package university

import scala.collection.mutable.*
import scala.math.min

class Discipline(val disciplineName: String, val teacher: Teacher, val group: Group) {
  println(this)
  override def toString: String = s"Discipline: ${disciplineName}\n${teacher}"

  private val lessons: ListBuffer[Lesson] = ListBuffer()
  private var exam: Exam = new Exam()

  def addLesson(lesson: Lesson): Unit =
    lessons += lesson

  def setExam(exam: Exam): Unit =
    this.exam = exam

  def statement(): Unit = {
    val statementResult = group.students.map(student => student -> ListBuffer(0, 0, 0, 0)).toMap

    for (lesson <- lessons) {
      lesson match {
        case lecture: Lecture =>
          lecture.attendancePoints().foreach { case (student, grade) => statementResult(student)(0) += grade }
        case practice: Practice =>
          practice.attendancePoints().foreach { case (student, grade) => statementResult(student)(1) += grade }
          practice.practicePoints().foreach { case (student, grade) => statementResult(student)(2) += grade }
      }
    }

    exam.points().foreach { case (student, grade) => statementResult(student)(3) = grade }

    println("Statement\t\t\t\t\t\t\t Lectures Practices\tLabs\tExam Overall\tGrade")
    statementResult.foreach { case (student, grades) =>
      val validatedGrades = validateGrades(grades)
      println(s"$student\t\t${validatedGrades.mkString("\t\t ")} \t${grades.sum} \t\t${pointsToGrade(grades.sum)}")
    }
  }

  private def validateGrades(grades: ListBuffer[Int]): ListBuffer[Int] = {
    ListBuffer(
      min(grades.head, 10),
      min(grades(1), 10),
      min(grades(2), 40),
      min(grades(3), 40),
    )
  }

  private def pointsToGrade(points: Int): Int = {
    points match {
      case p if p >= 90 => 5
      case p if p >= 76 => 4
      case p if p >= 60 => 3
      case _ => 2
    }
  }
}
