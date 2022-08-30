package lectures.part1basics

object StringOps extends App {

  val str: String = "Yoooooooooooobromyman"
  println(str.charAt(0))
  println(str.substring(1, 5))
  println(str.substring(1, str.length))
  println(str.split("o").toList)
  println(str.startsWith("Y"))

  println(str.replace("o", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())

  val aNumStr = "1024"
  val aNum = aNumStr.toInt
  println('a' +: aNumStr :+ 'z') // prepending and appending
  println(aNumStr.reverse)
  println(aNumStr.take(2))

}
