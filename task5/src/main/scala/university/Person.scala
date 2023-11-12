package university

class Person(val surname: String, val name: String, val patronymic: String) {
  override def toString: String = s"$surname $name $patronymic"
}

class Teacher(surname: String, name: String, patronymic: String) extends Person(surname, name, patronymic) {
  override def toString: String = s"Teacher: ${super.toString}"
}

class Student(surname: String, name: String, patronymic: String) extends Person(surname, name, patronymic) {
  override def toString: String = s"Student: ${super.toString}"
}

class Group(val course: Int, val direction: String, val group: Int, val students: List[Student]) {
  println(this)
  override def toString: String =
    s"""Specialty "$direction", year $course, group $group:
       |${students.map(_.toString).mkString("\n")}""".stripMargin
}