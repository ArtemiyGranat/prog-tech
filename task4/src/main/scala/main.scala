@main
def main(): Unit = {
  // Subtask 1
  val k1 = 4
  val list1: List[Int] = 3 :: 8 :: 1 :: 12 :: 23 :: Nil
  println(KthOrderStatistic.kthOrderStatistic(k1, list1))
  val k2 = 3
  val list2: List[Int] = 4 :: 7 :: 6 :: 5 :: 12 :: 9 :: 5 :: Nil
  println(KthOrderStatistic.kthOrderStatistic(k2, list2))

  // Subtask 2
  val field = Seafield.initField()
  Seafield.printField(field)
  val ship1 = Seafield.initShip(1, 2, 1, 5)
  var newField = Seafield.placeShip(field, ship1)
  val ship2 = Seafield.initShip(5, 7, 1, 7)
  newField = Seafield.placeShip(newField, ship2)
  Seafield.printField(newField)

  // Subtask 3
  val list3: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
  val list4: List[Int] = 2 :: 3 :: 4 :: 5 :: Nil
  val list5: List[Int] = 3 :: 6 :: 9 :: 12 :: Nil
  for {
    x <- list3
    y <- list4
    z <- list5 if x != y && x * y == z
  } {
    println(f"($x, $y)")
  }
}