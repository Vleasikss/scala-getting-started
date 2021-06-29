package main.scala.org.example


case class Matrix(from: Int, to: Int) {

  import Matrix._

  def generate(): Unit = generateBetween(from, to)
}

object Matrix {

  def generateBetween(from: Int, to: Int): Unit = {
    /**
     * yield just a syntax sugar, that is equal to .map(_ => _)
     * contains double loop
     *
     * @return .map(_ => (i, j))
     */
    def foo(n: Int, v: Int): IndexedSeq[(Int, Int)] =
      for (i <- 0 until n;
           j <- i until n if i + j == v)
      yield (i, j)

    // on each end of loop (yield) calls its
    foo(from, to) foreach {
      case (i, j) => println(s"($i, $j) ")
    }

  }

}
