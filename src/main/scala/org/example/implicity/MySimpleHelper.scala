package org.example.implicity

/**
 *
 * Example of using implicit classes
 *
 * */
object MySimpleHelper {
  // main idea is to extend classes/final classes without inheritance
  // implicit class must have only 1 argument
  // implicit class must be declared only inside object/class/treat...
  //
  implicit class StringExtended(string: String) {
    def sayIt(): Unit = println(string)

    def sayItLouderBitch(): Unit = println(string.toUpperCase + "!!!")
  }

  def main(args: Array[String]): Unit = {
    "hello" sayIt() // hello

    "pls say it louder" sayItLouderBitch() //PLS SAY IT LOUDER!!!
  }

}
