package org.example

import scala.util.Random


object Main {

  def main(args: Array[String]): Unit = {
    val customerID = CustomerID("Oleg")

    // destructuring || calling method unapply
    val CustomerID(name) = customerID

    println(name)

  }
}

/**
 * extractor object is an object that contains method 'unapply'
 * can contain only one argument to unapply/destructure
 */
object CustomerID {

  /**
   * main constructor of CustomerID object
   *
   * @param name param that will be changed on init
   * @return object with name "${name}--1231914"
   */
  def apply(name: String) = s"$name--${Random.nextLong}"

  /**
   * On accessing/destructuring param, will be called this method
   *
   * On fail destructuring will be thrown an exception
   *
   * @param customerID - param to receive
   * @return destructured param
   */
  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }

}