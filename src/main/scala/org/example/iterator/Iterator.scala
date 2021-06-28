package main.scala.org.example.iterator

trait Iterator[A] {

  def hasNext: Boolean

  def next: A

}
