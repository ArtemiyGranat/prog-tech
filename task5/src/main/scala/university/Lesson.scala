package university

abstract class Lesson(val topic: String, val attendance: List[Student]) {
  def attendancePoints(): Map[Student, Int] = attendance.map(_ -> 1).toMap
}

class Lecture(topic: String, attendance: List[Student]) extends Lesson(topic, attendance)

class Practice(topic: String, attendance: List[Student], val labPoints: Map[Student, Int]) extends Lesson(topic, attendance) {
  def practicePoints(): Map[Student, Int] = 
    attendance.map(student => student -> labPoints.getOrElse(student, 0)).toMap
}

class Exam(val grades: Map[Student, Int] = Map.empty[Student, Int]) {
  def points(): Map[Student, Int] = grades
}
