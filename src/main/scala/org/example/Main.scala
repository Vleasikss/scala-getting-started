package main.scala.org.example

import scala.util.Random

object Main {

  val x: Int = Random.nextInt(10)

  /**
   * Just an example of using switch-case in Scala
   */
  def getMatch: String =
    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }


  def main(args: Array[String]): Unit = {
    println(x)
    println(getMatch)

    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val someSms = SMS("867-5309", "Are you there ?")

    val importantEmail = Email("jenny@gmail.com", "Drink toning?", "I'm free at 5")
    val someSms1 = SMS("867-5309", "I'm here! Where are you ?")

    println(importantEmail.showImportantNotification(importantPeopleInfo))
    println(someSms.showImportantNotification(importantPeopleInfo))
    println(someSms1.showImportantNotification(importantPeopleInfo))


    println(Phone("Nokia").goIdle)
  }

}

/**
 * tries to cast into subtype,
 * if success -> go to case,
 * or -> go next
 */
abstract class Notification {
  def showNotification: String = {
    this match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(contactName, link) =>
        s"You receive a Voice recording from $contactName! Click the link to hear it $link"
      case _ =>
        s"You received something wrong"
    }
  }

  /**
   * Example of using switch-case with conditions
   *
   * @return importantNotification or defaultNotification
   */
  def showImportantNotification(importantPeopleInfo: Seq[String]): String = {
    this match {
      case Email(email: String, _, _) if importantPeopleInfo.contains(email) =>
        "You got an email from special someone!"
      case SMS(number: String, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case _ => showNotification
    }
  }
}

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification


/**
 * Using switch-case by type
 */
abstract class Device {
  def goIdle: String = this match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }
}

case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on"
}

