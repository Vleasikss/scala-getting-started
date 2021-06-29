package main.scala.org.example

import logging.Logger.info
import main.scala.org.example.model.Email

object Main {

  def main(args: Array[String]): Unit = {
    info("Hello static java methods")

    val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
    scalaCenterEmail match {
      case Some(email: Email) => println(
        s"""Registered an email
           |Username: ${email.username}
           |Domain name: ${email.domainName}
        """)
      case None => println("Error: could not parse email")
    }

  }
}
