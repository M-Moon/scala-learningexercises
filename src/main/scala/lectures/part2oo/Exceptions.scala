package lectures.part2oo

object Exceptions extends App {

  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("bruh")
    else 42
  }

  try {
    getInt(true)
    getInt(false)
  } catch {
    case e: RuntimeException => println("Caught a runtime exception!")
    case e: NullPointerException => println("Caught a null pointer exception!")
  } finally {
    println("Reached the end of the try/catch. I run whether we caught an exception or not!")
  }

  class PersonalException extends Exception {

  }
  val exc = new PersonalException
//  throw exc

  def outOfMemoryCrasher(): Unit = {
    val crashingArray = Array.ofDim[Int](Int.MaxValue)
    println("bruh")
  }
//  outOfMemoryCrasher()

  def stackOverflowCrasher(): Int = {
    10 * stackOverflowCrasher()
  }
//  stackOverflowCrasher()

  object PocketCalculator {

    class OverflowException extends Exception
    class UnderflowException extends Exception
    class MathCalculationException extends Exception

    def add(x: Int, y: Int): Int = {
      if (x < 0 && y >= 0) subtract(y, x)
      else if (y < 0 && x >= 0) subtract(x, y)

      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new OverflowException
      else result
    }
    def divide(x: Int, y: Int): Int = {
      if (x == 0 || y == 0) throw new MathCalculationException
      else x / y
    }
    def multiply(x: Int, y: Int): Int = x * y

  }

}
