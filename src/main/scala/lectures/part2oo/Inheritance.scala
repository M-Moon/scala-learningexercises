package lectures.part2oo

// inheritance and traits

// single class inheritance in Scala

object Inheritance extends App {

  sealed class Animal { // sealed means it can only be extended within this file
    val name = "Bruh"

    private def eat(): Unit = println("Nomnomnom")
    def letUsEat(): Unit = eat(); println(s"My name is $name, Time to eat!") // right to left??
  }

  class Cat extends Animal {
    //def letUsEat(): Unit = eat() // cannot do this as it's private in the parent class!
    override val name = "CAT"
  }

  val bobbo = new Cat
  bobbo.letUsEat()

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

}
