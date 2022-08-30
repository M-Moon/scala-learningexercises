package lectures.part2oo

object Generics extends App {

  class MyList[T] {
    // type T is the generic
  }

  trait MyMap[Key, Value] {
    // both Key and Value are generic
  }

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]
  val listOfLists = new MyList[MyList[Int]]

  object MyList { // companion object; objects cannot be given generic types (there's only one instance of them anyway!)
    def empty[T]: MyList[T] = ???
  }

  val emptyIntList = MyList.empty[Int]

  // variance problem

}
