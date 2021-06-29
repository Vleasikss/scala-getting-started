package main.scala.org.example

object Main {

  val myCat: Cat = Cat("Boots")

  def printAnimalName(animals: List[Animal]): Unit = {
    animals.foreach(animal => println(animal.name))
  }

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  def main(args: Array[String]): Unit = {

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalName(cats)
    printAnimalName(dogs)

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    // [-A] allows to do this
    printMyCat(animalPrinter)
  }

}

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal


abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(value: Animal): Unit =
    println("The animal's name is: " + value.name)
}

class CatPrinter extends Printer[Cat] {
  override def print(value: Cat): Unit =
    println("The cat's name is: " + value.name)
}


