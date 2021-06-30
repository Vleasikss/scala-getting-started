package main.scala.org.example

/**
 * Explanation
 *
 *
 * Trying to get integer value:
 *  - we call the method 'double' with no arguments, so the compiler will try to do that instead of us.
 *  - - compiler tries to find an implicit variable
 *  - - compiler tries to find an implicit method and calls it to get a value (in our case Int)
 *  - calls the method with founded implicit value
 */
object SimplicityMethodVariable {


  val isCappucinoLarge: Boolean = false

  /**
   * Implicit param using
   *
   * @param value implicit param
   * @return value converted into double
   */
  def double(implicit value: Int): Double = value * 2

  /**
   * Implicit method
   */
  implicit def getInt: Int = if (isCappucinoLarge) 200 else 100

  def main(args: Array[String]): Unit = {
    println(double)
  }

}
