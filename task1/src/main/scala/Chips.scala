object Chips {
  def weight(potatoWeight: Long, potatoWaterRatio: Double, chipsWaterRatio: Double): Double = {
    val dryPotatoWeight = potatoWeight * (1.0 - potatoWaterRatio)
    val chipsWeight = dryPotatoWeight / (1.0 - chipsWaterRatio)
    chipsWeight
  }
}
