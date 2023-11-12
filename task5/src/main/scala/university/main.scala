package university

@main
def main(): Unit = {
  val student = new Student("Granat", "Artemiy", "Maksimovich")
  val studentsList: List[Student] = student :: Nil
  val group = new Group(4, "Software Engineering", 451, studentsList)

  val teacher = new Teacher("Kondratova", "Yuliya", "Nikolaevna")
  val progTech = new Discipline("Programming technologies", teacher, group)

  val lesson1 = new Lecture("Scala is the best", studentsList)
  val lesson2 = new Practice("Scala is wonderful", studentsList, Map(student -> 100))

  progTech.addLesson(lesson1)
  progTech.addLesson(lesson2)

  val exam = new Exam(Map(student -> 100))
  progTech.setExam(exam)
  println()
  progTech.statement()
  println("Я хочу автомат")
}