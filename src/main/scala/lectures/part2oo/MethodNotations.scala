package lectures.part2oo

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favMovie

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favMovie, age)

    def unary_+ : Person = new Person(name, favMovie, age + 1)

    def learns(toLearn: String): Unit = println(s"$name learns $toLearn!")
    def learnsScala: Unit = learns("Scala")

    def apply(times: Int): Unit = println(s"$name watched their favourite movie \"$favMovie\" $times times")
  }

  val mary = new Person("Mary", "Scooby Dooby Doo 2", 20)
  println(mary.likes("Inception"))

  val mary2 = mary + "MY drillah"
  println(mary2.name)

  val mary3 = +mary2
  println(mary3.age)

  mary3 learnsScala

  mary3(2)

}
