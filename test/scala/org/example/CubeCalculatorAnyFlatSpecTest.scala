package org.example

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec

import java.io._

class CubeCalculatorAnyFlatSpecTest extends AnyFlatSpec with BeforeAndAfter {

  var shouldFailTest: Boolean = false
  before {
    println("before")
  }
  after {
    println("after")
  }

  def withFile(testCode: (File, FileWriter, FileReader) => Any): Unit = {
    val file = File.createTempFile("hello", "world") // create the fixture
    val writer = new FileWriter(file)
    val reader = new FileReader(file)
    try {
      testCode(file, writer, reader) // "loan" the fixture to the test
    }
    finally {
      writer.close()
      reader.close()
    } // clean up the fixture
  }

  "Cube calculator " should "cube 3 and return 27" in {
    val cube = Calculator.cube(3)
    val expectedValue = 27
    assert(cube === expectedValue)
  }

  "Square calculator" should "square 3 and return 9" in {
    val square = Calculator.square(3)
    val expectedValue = 9
    assert(square === expectedValue)
  }
  "Divide calculator" should "divide 1 to 0 and throw ArithmeticException" in {
    assertThrows[ArithmeticException] {
      Calculator.divide(1, 0)
    }
  }
  "Fail test example" should "fail test" in {
    if (shouldFailTest) fail("Fail test example")
  }

  ignore should "Ignore the test" in {
    fail("Test has to be ignored")
  }

  it should "Run test with a file template" in withFile { (file, fileWriter, reader) =>
    fileWriter.write("sada".toCharArray)
    fileWriter.flush()
  }
}

