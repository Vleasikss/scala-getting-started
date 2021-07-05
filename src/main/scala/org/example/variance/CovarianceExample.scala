package org.example.variance

class CovarianceExample[+T]

object CovarianceDemo extends App {

  val x: CovarianceExample[Object] = new CovarianceExample[String]
  //exception
  val y: CovarianceExample[String] = new CovarianceExample[Object]
  val z: CovarianceExample[String] = new CovarianceExample[String]
}
