object Seafield {
  private type Field = Vector[Vector[Boolean]]
  private type Point = (Int, Int)
  private type Ship = List[Point]

  def initField(): Field = {
    Vector.fill(10)(Vector.fill(10)(false))
  }

  def initShip(x1: Int, y1: Int, x2: Int, y2: Int): Ship = {
    if (x1 != x2 && y1 != y2) {
      throw new IllegalArgumentException("Ship must be either horizontal or vertical")
    }

    if (!isValidPoint(x1, y1) || !isValidPoint(x2, y2)) {
      throw new IllegalArgumentException("Invalid point")
    }

    val coords = if (x1 == x2) {
      if (y1 < y2) (y1 to y2).map(y => (x1, y)).toList
      else (y2 to y1).map(y => (x1, y)).toList
    } else {
      if (x1 < x2) (x1 to x2).map(x => (x, y1)).toList
      else (x2 to x1).map(x => (x, y1)).toList
    }

    coords
  }

  private def isValidPoint(x: Int, y: Int): Boolean = {
    x >= 0 && x < 10 && y >= 0 && y < 10
  }

  def printField(field: Field): Unit = {
    field.foreach(row => println(row.map(if _ then "X" else "_").mkString(" ")))
    println()
  }

  def placeShip(field: Field, ship: Ship): Field = {
    ship.foldLeft(field) {
      (currField, point) => currField.updated(point._1, currField(point._1).updated(point._2, true))
    }
  }
}
