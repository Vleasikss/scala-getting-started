package main.scala.org.example

class Main {

  /**
   * The last command is a returned value
   * [That's just like in Ruby language]
   *
   * @param input - number to square
   */
  def getSquareString(input: Double): Unit = {
    val square = input * input
    square.toString
  }

  def main (args: Array[String] ): Unit = {
    getSquareString(55)
  }

}

object Main extends App {



  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}")

  println({
    val x = 1 + 1
    x + 1
  })

  val addOne = (x:Int) => x
  val addedOne = addOne(32)

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquareString(12))

  val added = addThenMultiply(23, 500)(40)
  println(added)

}
