package lectures.part1basics

import scala.annotation.tailrec

object recursion extends App {

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n-1)
  }

  println(factorial(20))

  def newFactorial(n: BigInt): BigInt = {
    @tailrec
    def helper(x: BigInt, acc: BigInt): BigInt = {
      if (x <= 1)
        acc
      else
        helper(x-1, x*acc) // TAIL RECURSION - no data or calculations have to be done in earlier stack frames (unlike the previous func) so it can replace stack frames
    }
    helper(n, 1)
  }

//  println(newFactorial(5000))

  @tailrec
  def tailConcat(s: String, n: Int, res: String = ""): String = {
    if (n < 0)
      res
    else
      tailConcat(s, n-1, res+s)
  }

  println(tailConcat("Hello", 10))

  def tailFib(n: Int): Int = {
    @tailrec
    def fib(i: Int = 2, secondToLast: Int = 1, last: Int = 1): Int = {
      if (i >= n)
        last
      else
        fib(i+1, last, last+secondToLast)
    }

    if (n <= 2) 1
    else fib()
  }

  println(tailFib(8))
}
