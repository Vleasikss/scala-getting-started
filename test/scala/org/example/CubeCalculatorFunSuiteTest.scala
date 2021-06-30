package org.example

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
/**
 *
 * BeforeAndAfter is a trait, that allows to use 'before' method <br/>
 * (To use something just like annotation <span style="color:yellow">@BeforeEach</span> in Java)
 */
class CubeCalculatorFunSuiteTest extends AnyFunSuite with BeforeAndAfter {

  var list: List[Int] = _

  before {
    list = List(123456)
  }

  test("CubeCalculator cube of 3 should return 27") {
    //"==" использует методы equals
    val expectedResult = 27
    val actualResult = Calculator.cube(3)

    assert(expectedResult === actualResult)
  }

  test("Test 1/0 should throw ArithmeticException") {
    val thrown = intercept[ArithmeticException] {
      1 / 0
    }
    assert(thrown.getMessage === "/ by zero")
  }

}
