package lectures.part1basics

object Exprs extends App {
  val x = 1 + 2
  println(x)

  println(2 + 7 * 56)

  val aCondition = { // a code block that evaluates as an expression, as most things do in Scala, and is assigned to 'aCondition
    if (1 == 1)
      false
    else
      true
  } // value assigned through if expression

  println(aCondition)

  // while loops, even for loops, are discouraged. while is moreso discouraged as it encourages 'imperative programming' as opposed to expression programming
  // we must be FUNCTIONAL, until we are OO I guess. kinda confusing
  // side effects return units, such as the reassignment of a var
}
