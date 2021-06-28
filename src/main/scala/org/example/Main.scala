package main.scala.org.example

object Main {

  class RichIteratorImpl extends StringIterator("Oleg") with RichIterator

  def main(args: Array[String]): Unit = {
    val richIterator = new RichIteratorImpl
    richIterator forEach print
  }
}

abstract class AbsIterator {
  /**
   * similar to AbsIterator[T], but its a variable, so it can overrides
   */
  type T

  def hasNext: Boolean

  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  override type T = Char
  private var i = 0

  override def hasNext: Boolean = i < s.length

  override def next(): Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {

  /**
   * Calls a function while the iterator contains the elements
   *
   * - Gives into a function f next element param
   * @param f
   */
  def forEach(f: T => Unit): Unit =
    while (hasNext) f(next())

}