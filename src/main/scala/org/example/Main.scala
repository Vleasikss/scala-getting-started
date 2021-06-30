package org.example


object Main {
  def main(args: Array[String]): Unit = {
    val couch = new Couch()
    val chair = new Chair()

    assert(couch.findPlaceToSit == "Lie on the couch")
    assert(chair.findPlaceToSit == "Lie on the chair")
  }
}

/**
 * Запечатанные классы
 *
 * Sealed class means that
 * we have to create all the subclasses in a file,
 *
 * extending current sealed class won't be allowed outside this file
 */
sealed abstract class Furniture {
  def findPlaceToSit: String = this match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Lie on the chair"
  }
}

class Couch() extends Furniture

class Chair() extends Furniture

