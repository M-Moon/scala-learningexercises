package lectures.part2oo

object CaseClasses extends App {

  // case class
  case class Person(name: String, age: Int) {
    // 1. class parameters promoted to fields
    // 2. sensible toString automatically created
    // 3. eq and hashCode implemented automatically
    // 4. case classes are handy to copy due to the copy() method
    // 5. case classes automatically have companion objects
    // 6. serializable
    // 7. extractor patterns = used in pattern matching
  }

}
