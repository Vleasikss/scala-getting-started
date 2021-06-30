package org.example


/**
 *
 * Ассоциативность — свойство операций, позволяющее восстановить
 * последовательность их выполнения при отсутствии явных указаний
 * на очерёдность при равном приоритете.
 *
 * Monoid is a pattern in a functional programming
 * that allows to create such constructions/algorithms as
 *  - fold (List(1,2,3).foldLeft(empty)(combine))
 *
 * Main idea:
 *  - method <i>combine</i> is associative, that allows to combine a previous state with new
 *  - method <i>empty</i> is a state
 */
object MonoidExample extends App {

  trait SemiGroup[A] {
    def combine(x: A, y: A): A
  }

  trait Monoid[A] extends SemiGroup[A] {
    def empty: A
  }

  implicit def intSumMonoid: Monoid[Int] = new Monoid[Int] {
    override def empty: Int = 0

    override def combine(x: Int, y: Int): Int = x + y
  }

  implicit def stringSumMonoid: Monoid[String] = new Monoid[String] {
    override def empty: String = ""

    override def combine(x: String, y: String): String = x + y
  }

  val resultStringMonoid = stringSumMonoid.combine("a", "b")
  println(resultStringMonoid)
  val resultIntMonoid = intSumMonoid.combine(1, 2)

  val emptyInt = intSumMonoid.empty
  val emptyString = stringSumMonoid.empty

  // main property of monoid
  println(intSumMonoid.combine(emptyInt, 2) == intSumMonoid.combine(2, emptyInt))

  // main property of monoid
  println(stringSumMonoid.combine(emptyString, "hello") == stringSumMonoid.combine("hello", emptyString))


}
