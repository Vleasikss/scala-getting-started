package main.scala.org.example.pet

trait Pet {
  val name: String

  override def toString: String = name
}
