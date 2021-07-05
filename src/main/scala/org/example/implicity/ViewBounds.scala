package org.example.implicity

import scala.language.implicitConversions

class Zero

class A extends Zero

class B(value: String) extends A {
  def bMethod(): Unit = println("B method")
}

class C extends B("")

/**
 * View bounds is an idea of converting
 * from A class to child class B.
 * To use it:
 *  - create implicit def method of converting
 *  - declare in method/class [A <% B] (A class has to be converted into class B)
 */
class ViewBounds() {

  // implicit conversion from A class to B class
  // is equal to:
  // def f[A](a:A) (implicit aToB: A => B) = a.bMethod
  def f[A <% B](a: A): Unit = a.bMethod()

}

object Demo extends App {
  val bounds:ViewBounds = new ViewBounds
  val a:A = new A

  implicit def fromAToB(a: A): B = new B("Default value")

  bounds.f(a) // B method
}