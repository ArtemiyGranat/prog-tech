object Chips {
  def weight(potatoWeight: Long, potatoWaterRatio: Double, chipsWaterRatio: Double): Double = {
    val dryPotatoWeight = potatoWeight * (1.0 - potatoWaterRatio)
    val chipsWeight = dryPotatoWeight / (1.0 - chipsWaterRatio)
    chipsWeight
  }

  def weightCurried: Long => Double => Double => Double = potatoWeight => potatoWaterRatio => 
    chipsWaterRatio => potatoWeight * (1.0 - potatoWaterRatio) / (1.0 - chipsWaterRatio)
  
  val weightAutoCurried: Long => Double => Double => Double = weight.curried
}
