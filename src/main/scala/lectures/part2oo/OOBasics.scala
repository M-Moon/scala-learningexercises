package lectures.part2oo

object OOBasics extends App {

//  val p: Person = new Person("Garry", 25)
//  println(p)
//
//  p.greet("Robbie")
//  p.greet()
//
//  val p2: Person = new Person("Joe")
//  p2.greetWithAge()

  val writerJoe = new Writer("Joe", "Moon", 2000)
  val fakeJoe = new Writer("Joe", "Moon", 2000)
  val wolfDiaries = new Novel("The Wolf Diaries", 2013, writerJoe)

  println((writerJoe.fullName, writerJoe.yearOfBirth)) // Joe Moon, 2000
  println((wolfDiaries.authorAge, wolfDiaries.isWrittenBy(writerJoe))) // 13, true
  println(wolfDiaries.isWrittenBy(fakeJoe)) // false
  val wolfDiariesRevised = wolfDiaries.copy(2022)
  println(wolfDiariesRevised.authorAge)

  val counter = new Counter(0)
  counter.inc()
  println(counter.count)
  counter.inc(20)
  println(counter.count)
  counter.dec()
  println(counter.count)

}

// constructor parameters defined here
class Person(name: String, age: Int) {

  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name!")
  }

  def greet(): Unit = {
    println(s"Hello, I'm $name")
  }

  def greetWithAge(): Unit = {
    println(s"Hello, I'm $name and I am $age years old!")
  }

  // multiple constructors
  def this(name: String) = this(name, 0)

}

class Writer(fName: String, sName: String, yob: Int) {

  def fullName: String = {
    s"$fName $sName"
  }

  def yearOfBirth: Int = {
    yob
  }

}

class Novel(title: String, yor: Int, author: Writer) {

  def authorAge: Int = {
    yor - author.yearOfBirth
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYOR: Int): Novel = {
    new Novel(title, newYOR, author)
  }

}

class Counter(val count: Int = 0) {

  def inc(): Counter = new Counter(count + 1)
  def inc(n: Int): Counter = {
    if (n <= 0)
      this
    else
      inc().inc(n-1)
  }

  def dec(): Counter = new Counter(count - 1)
  def dec(n: Int): Counter = {
    if (n <= 0)
      this
    else
      dec().dec(n-1)
  }

}
