package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // vals!
  val aString: String = "Hello"
  val aBool: Boolean = true
  val aChar: Char = 'c'
  val aShort: Short = 4613
  val aLong: Long = 405067080L
  val aFloat: Float = 2.145F
  val aDouble: Double = 2.57089

  // vars!
  var aVar: Int = 890
  aVar = 40 // side effects
}
