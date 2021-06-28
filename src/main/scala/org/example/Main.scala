package main.scala.org.example

object Main {

  def main(args: Array[String]): Unit = {

    val point1 = new Point(_x = 20)
    println(point1)


    // using setters
    point1.y = 10
    point1.x = 20

    //using setter
    println(point1.x)
    println(point1.y)

  }
}

/**
 * Default constructor
 */
class Point(private var _x: Int = 0, private var _y: Int = 0) {

  private val bound = 100

  /**
   * getter
   *
   * @return x value
   */
  def x: Int = _x

  def x_=(newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning()

  }

  /**
   * y getter
   *
   * @return y valye
   */
  def y: Int = _y


  /**
   * y setter
   *
   * @param newValue new value to set
   */
  def y_=(newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning()
  }

  private def printWarning(): Unit = println("Out of bound")

  override def toString: String =
    s"($x, $y)"
}