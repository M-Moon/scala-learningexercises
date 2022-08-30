package lectures.part2oo

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat(): Unit = println("Nomnomnom")
  }

  // traits
  trait Carnivore {
    def eat(victim: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Reptile"

    override def eat(): Unit = println("Slurp crunch lunch")
    override def eat(victim: Animal): Unit = println("Time for a meal!")
  }

}
