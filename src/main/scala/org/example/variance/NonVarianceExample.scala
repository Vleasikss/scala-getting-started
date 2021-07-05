package org.example.variance

class NonVarianceExample[T]


object NonVarianceDemo extends App {
  //exception
  val x: NonVarianceExample[Object] = new NonVarianceExample[String]
  //exception
  val y: NonVarianceExample[String] = new NonVarianceExample[Object]
  val z: NonVarianceExample[String] = new NonVarianceExample[String]
}
