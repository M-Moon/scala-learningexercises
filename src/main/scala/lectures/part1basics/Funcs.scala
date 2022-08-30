package lectures.part1basics

import scala.annotation.tailrec

object Funcs extends App {
  def aFunc(a: Int, b: Int, c: String): Int = {
    if (a > b)
      5
    else
      10
  }

  println(aFunc(2, 5, "yo"))

  def concats(a: String = "yo", b: Int = 10): String = {
    a + " " + b
  }

  println(concats("my drillah!", 20))
  println(concats())

  def noParams(): Int = 50
  println(noParams())

  // Functional programming prefers RECURSION to LOOPS, though Scala allows iteration and supports it
  // recursion limits side effects, such as those produced by a while loop, and produces a value as an expression
  // recursive functions always require defined return types. should always define anyway
  def aRepeatedFunction(s: String, i: Int): String = {
    if (i == 1) s
    else s + aRepeatedFunction(s, i-1)
  }

  println(
    aRepeatedFunction("My drillah!", 20)
  )

  def aBigFunc(n: BigInt): Int = {
    def myGuy(t: Int): Int = {
      t + 55
    }
    myGuy(n.toInt / 2)
  }

  println(aBigFunc(45))

  def kidGreeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old!"
  }

  println(kidGreeting("Jeremy", 45))

  def factorial(n: Int): Int = {
    if (n <= 1)
      1
    else
      n * factorial(n-1)
  }

  println(factorial(5))

  def fib(n: Int): Int = {
    if (n <= 2)
      1
    else
      fib(n-1) + fib(n-2)
  }

  println(fib(8))

  @tailrec
  def testPrime(n: Int, i: Int = 2): Boolean = {
    if (n == 0 || n == 1)
      return false

    if (n == i)
      return true

    if (n % i == 0)
      return false

    testPrime(n, i+1)
  }

  val primeToTest: Int = 37
  println(testPrime(primeToTest))

  def testPrime2(n: Int): Boolean = {
    @tailrec
    def testPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && testPrimeUntil(t-1)
    }
    testPrimeUntil(n / 2)
  }

  println(testPrime2(primeToTest * 2))

}
