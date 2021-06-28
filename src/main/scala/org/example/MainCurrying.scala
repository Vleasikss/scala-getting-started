package main.scala.org.example


/**
 * Main concept of Currying
 * We can call the method/function not completely
 *
 * Rules:
 *  - we have to add ( _ + n count of functions to call) if we want to call the function not completely
 */
object MainCurrying {

  /**
   * currying example
   *
   * @param x first function that contain first argument x
   * @param y second function that contain second argument y
   *          and return (sum of y and x)
   * @return sum of x and y
   */
  def add(x: Int)(y: Int): Int = x + y

  def main(args: Array[String]): Unit = {

    val doPlus12 = add(12) _
    val sum = doPlus12(30)
    println(sum)

    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFuncSum = numbers.foldLeft(List[Int]()) _ // z = Empty.List[Int]

    //appends all the values start from the beginning
    // similar to numberFuncSum((xs: List[Int], x:Int) => {xs.apply(x * x); xs}
    val squares = numberFuncSum((xs: List[Int], x: Int) => xs :+ x * x) // GENERAL FORM
    println(squares.toString()) //List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

    //appends all the values in cube from the beginning
    // similar to numberFuncSum((xs: List[Int], x:Int) => {xs.apply(x * x * x); xs}
    val cubes = numberFuncSum((xs: List[Int], x: Int) => xs :+ x * x * x) // GENERAL FORM
    println(cubes.toString()) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)

    // 1 _ => (xs:CastedType)
    // 2 _ => (val1:CastedType, val2:CastedType)
    // 3 _ => outOfBound, so (val1:CastedType, val2:CastedType, val3: Any)
    val sumCurrying = numbers.foldLeft(0)(_ + _) // CURRYING FORM
    println(sumCurrying)

  }
}
