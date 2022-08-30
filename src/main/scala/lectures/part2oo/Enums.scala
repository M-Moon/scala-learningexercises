package lectures.part2oo

object Enums extends App {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit =
      if (this == READ) println("Opening document...")
      else println("Access denied!")
  }

  val myPermission: Permissions = Permissions.WRITE
  myPermission.openDocument()
  val readPerm: Permissions = Permissions.READ
  readPerm.openDocument()

  // constructor args
  enum PermsWithBits(bits: Int) {
    case READ extends PermsWithBits(4)
    case WRITE extends PermsWithBits(2)
    case EXECUTE extends PermsWithBits(1)
    case NONE extends PermsWithBits(0)
  }

  object PermsWithBits {
    def fromBits(bits: Int): PermsWithBits = ??? // factory method possibility
  }

}
