@main
def main(): Unit = {
  // Task 1
  val Array(x, y, z) = scala.io.StdIn.readLine().split(' ').map(_.toInt)
  val prod = x * y * z
  println(prod)

  // Task 2
  Greeting.greeting("Artemiy")

  // Task 3
  val chipsWeight1 = Chips.weight(90, 0.9, 0.1)
  val chipsWeight2 = Chips.weight(100, 0.85, 0.1)
  val chipsWeight3 = Chips.weight(10000000000L, 0.9, 0.05)
  println(f"$chipsWeight1%.2f")
  println(f"$chipsWeight2%.2f")
  println(f"$chipsWeight3%.2f")
}