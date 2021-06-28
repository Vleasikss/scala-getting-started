package main.scala.org.example

import main.scala.org.example.iterator.IntIterator
import main.scala.org.example.pet.{Cat, Dog, Pet}

import scala.collection.mutable.ArrayBuffer

object Main {

  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)

    println(iterator.next)
    println(iterator.next)
    println(iterator.next)

    val petDog = new Dog("Oleg")
    val petCat = new Cat("Vitya")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(petCat)
    animals.append(petDog)
    animals.foreach(pet => println(pet))

  }

}
