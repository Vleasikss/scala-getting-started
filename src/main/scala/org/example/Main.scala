package main.scala.org.example


object Main {

  //  def newIntSeqBuffer(elem1: Int, elem2: Int): IntSeqBuffer =
  //    new IntSeqBuffer {
  //      override type T = List[U]
  //      override val element = List(elem1, elem2)
  //    }
  def newIntSeqBuffer(elem1: Int, elem2: Int): SeqBuffer[Int, Seq[Int]] =
    new SeqBuffer[Int, List[Int]] {
      override val element: List[Int] = List(elem1, elem2)
    }

  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else {
      // :: - add element
      x :: listOfDuplicates(x, length - 1)
    }
  }


  def main(args: Array[String]): Unit = {
    println(listOfDuplicates[Int](3, 4))

    val buf = newIntSeqBuffer(7, 8)
    println(s"length = ${buf.length}")
    println(s"content = ${buf.element}")
  }
}

trait Buffer[+T] {
  //  type T
  val element: T
}

//abstract class SeqBuffer extends Buffer {
//  type U
//  override type T <: List[U]
//
//  def length: Int = element.length
//}
//abstract class IntSeqBuffer extends SeqBuffer {
//  override type U = Int
//}
abstract class SeqBuffer[U, +T <: Seq[U]] extends Buffer[T] {
  def length: Int = element.length

}