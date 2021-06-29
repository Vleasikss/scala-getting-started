package main.scala.org.example.model

import scala.math._

case class Circle(radius: Double) {

  import Circle._

  def area: Double = calculateArea(radius)
}

/**
 * Object that contain the same name as the class/trait/case-class
 * calls as class-companion
 *
 * Object/class can access private defs and variables of its companion
 * Object && class companion should be in the same file
 *
 */
object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}
