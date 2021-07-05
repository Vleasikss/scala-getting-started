package org.example.variance

class ContraVarianceExample[-T]


object ContraVarianceDemo extends App {
  //exception
  val x: ContraVarianceExample[Object] = new ContraVarianceExample[String]
  val y: ContraVarianceExample[String] = new ContraVarianceExample[Object]
  val z: ContraVarianceExample[String] = new ContraVarianceExample[String]
}
