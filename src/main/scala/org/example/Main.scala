package main.scala.org.example

object Main {

  /**
   * just psvm
   * @param args arguments
   */
  def main(args: Array[String]): Unit = {
    val greeter = new Greeter("Hello", ", ")
    greeter.greet("Oleg")

    val point = Point(1, 2)
    val point2 = Point(3, 4)
    val samePoint = Point(1, 2)

    assert(point == samePoint)


    val idFactory = IdFactory.create()
    println(idFactory.toString)

    val greeterTrait: GreeterTrait = new DefaultGreeter
    greeterTrait.greet("Hello")
  }

}

/**
 * Default java classes
 *
 * @param prefix first arg of constructor
 * @param suffix second arg of constructor
 */
class Greeter(prefix: String, suffix: String) {

  /**
   * Unit means that returned value is not necessary
   * [Just like 'void' keyword in Java language]
   */
  def greet(name: String): Unit =
    println(prefix + suffix + name)
}

/**
 * case class (класс-образ)
 *
 *  - Immutable
 *  - initializes by constructor
 *  - initializes without keyword 'new'
 *  - compares by values [point(1,2) == point(1,2) // true]
 *
 */
case class Point(x: Int, y: Int)


/**
 * objects (синглтон-классы)
 * Contains only 'static' methods
 *
 */
object IdFactory {
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }

  override def toString: String = counter.toString
}

/**
 * Traits (java-interfaces)
 *
 *
 *
 */
trait GreeterTrait {
  /**
   * declares only behaviour of classes that will implement current trait
   */
  def greet(name: String): Unit

  /**
   * default realization of trait method
   *
   */
  def greet(number: Int): Unit = {
    println(s"Hello ${number}")
  }
}

/**
 * Realization of GreeterTrait methods
 */
class DefaultGreeter extends GreeterTrait {

  override def greet(name: String): Unit = {
    println(s"Hello ${name}")
  }

  override def greet(number: Int): Unit = super.greet(number)
}