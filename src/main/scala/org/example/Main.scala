package main.scala.org.example

/**
 * To create new tuple
 * Just write (values...): (TypeValues...)
 *
 */
object Main {


  def main(args: Array[String]): Unit = {
    val ingredient = ("Sugar", 25): (String, Int)
    val (name, count) = ingredient
    assert(name == ingredient._1 && name == "Sugar")
    assert(count == ingredient._2 && count == 25)


    val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6)): List[(String, Double)]
    planets.foreach { tuple => {
      tuple match {
        case ("Mercury", distance) => println(s"Mercury is $distance km")
        case p if (p._1 == "Venus") => println(s"Venus is ${p._2} km")
        case p if (p._1 == "Earth") => println(s"Earth is ${p._2} km")
        case _ => println("Too far")
      }
    }
    }

    val numPairs = List((2, 5), (3, -7), (20, 56))
    for ((a, b) <- numPairs) {
      println(a * b)
    }
  }
}
