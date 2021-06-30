package org.example

import UserBase.userBase

object Main {

  def main(args: Array[String]): Unit = {

    println(UserUtils.getUsernamesBetweenAge(20, 30))

    val matrix = Matrix(10, 10)
    matrix.generate()
  }

}

object UserUtils {

  def getUsernamesBetweenAge(min: Int, max: Int): List[String] = {
    for (user <- userBase if user.age >= min && user.age < max)
      yield user.name
  }
}

case class User(name: String, age: Int)