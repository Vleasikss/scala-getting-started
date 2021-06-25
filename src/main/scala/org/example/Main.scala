package main.scala.org.example

object Main extends App {

  /**
   * The last command is a returned value
   * [That's just like in Ruby language]
   *
   * @param input - number to square
   */
  def getSquareString(input: Double): Double = {
    val square = input * input
    square
  }

  /**
   * Default lambda expression
   */
  val addOne: Int => Int = (x: Int) => x + 1


  /**
   * Method that contains list of params
   *
   * @param x          first arg of first params list
   * @param y          second arg of first params list
   * @param multiplier first arg of second params list
   */
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier


  val square = getSquareString(12)
  assert(square == 144.0)

  val i: Int = addOne(10)
  assert(i == 11)

}
