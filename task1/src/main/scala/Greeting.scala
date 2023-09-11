object Greeting {
  import Config.{greeting => prefix}
  
  def greeting(name: String): Unit = {
    println (prefix + name)
  }
}
