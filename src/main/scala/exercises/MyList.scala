package exercises

trait MyPredicate[-T] {
  def genericTest(toTest: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(toTransform: A): B
}

// predicates and transformers
class EvenPredicate extends MyPredicate[Int] {
  override def genericTest(toTest: Int): Boolean = toTest % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(toTransform: String): Int = 5
}

// bigger MyList class
abstract class MyList[+T] {

  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[K >: T](n: K): MyList[K]

  def printElements: String
  override def toString: String = s"[${printElements}]"

  def map[B](transformer: MyTransformer[T, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[T, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[T]): MyList[T]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[K >: Nothing](n: K): MyList[K] = new Cons(n, this)
  def printElements: String = "Empty"

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}

case class Cons[+T](h: T, t: MyList[T] = Empty) extends MyList[T] {
  def head: T = h
  def tail: MyList[T] = t
  def isEmpty: Boolean = false
  def add[K >: T](n: K): MyList[K] = new Cons(n, this)

  override def printElements: String = if (isEmpty) printElements else s"$h, ${t.printElements}"

  def filter(predicate: MyPredicate[T]): MyList[T] = {
    if (predicate.genericTest(h)) new Cons(
      h,
      t.filter(predicate)
    )
    else
      t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[T, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def flatMap[B](transformer: MyTransformer[T, MyList[B]]): MyList[B] = {
    ???
  }

//  override def printElements(): String = s"$h, ${
//    if (t.isEmpty) "End" else t.printElements()
//  }"
}

object Driver extends App {
  val aCons = new Cons(5, Empty)
  val aCons2 = aCons.add(5).add(6).add(20).add(21000).add(2405).add(604)

  println(aCons2.toString)

  val aCons2Times2 = aCons2.map((elem: Int) => elem * 2)
  println(aCons2Times2)
}

