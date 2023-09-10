def countSetBits(number: Int): Int = {
  number.toBinaryString.count(_ == '1')
}

// Brian Kernighan’s algorithm
def countSetBitsFromScratch(number: Int): Int = {
  var count = 0
  var mutNumber = number
  while (mutNumber != 0) {
    mutNumber = mutNumber & (mutNumber - 1)
    count += 1
  }
  count
}

def stairs(number: Int): Unit = {
  for (i <- 1 to number) {
    for (j <- 1 to i) {
      print(s"$j ")
    }
    println()
  }
}

def isSnakeCase(name: String): Boolean = {
  name match {
    case "" => false
    case name if name.startsWith("_") || name.endsWith("_") || name.contains("__") => false
    case name if name.exists { ch => ch >= 'а' && ch <= 'я' || ch >= 'А' && ch <= 'Я' } => false
    case name if name.forall(ch => ch.isLower || ch == '_') => true
    case _ => false
  }
}

@main
def main(): Unit = {
  // Task 1
  val number = -1
  val setBitsCount = countSetBits(number)
  val setBitsCountCheck = countSetBitsFromScratch(number)
  println(s"$number has the $setBitsCount set bits")
  println(s"$number has the $setBitsCountCheck set bits")

  // Task 2
  stairs(5)

  // Task 3
  println(isSnakeCase("abc_дef"))
  println(isSnakeCase(""))
  println(isSnakeCase("abc def"))
  println(isSnakeCase("abc_def"))
  println(isSnakeCase("_abcdef"))
  println(isSnakeCase("abcdef_"))
  println(isSnakeCase("abcde1452f"))
  println(isSnakeCase("abc-def"))
  println(isSnakeCase("a_bc_def"))
  println(isSnakeCase("a"))
}