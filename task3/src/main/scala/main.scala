import scala.annotation.tailrec

def reverseWords(str: String): String = {
  str.split("\\s+").reverse.mkString(" ")
}

def reverseWordsTailRec(str: String): String = {
  @tailrec
  def loop(words: List[String], result: List[String]): String = {
    words match {
      case Nil => result.mkString(" ")
      case head :: tail => loop(tail, head :: result)
    }
  }

  val wordsList = str.trim.split("\\s+").toList
  loop(wordsList, Nil)
}


@main
def main(): Unit = {
  val inputString = "How        are you"
  // Subtask 1
  println(reverseWords(inputString))
  // Subtask 2
  println(reverseWordsTailRec(inputString))
  // Subtask 3
  val chipsWeight1 = Chips.weightAutoCurried(90)(0.9)(0.1)
  val chipsWeight2 = Chips.weightCurried(100)(0.85)(0.1)
  println(f"$chipsWeight1%.2f")
  println(f"$chipsWeight2%.2f")
}