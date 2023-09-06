object Greeting {
  def greeting(name: String): Unit = {
    println (Config.greeting + name)
  }
}
