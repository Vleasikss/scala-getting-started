package main.scala.org.example.model

class Email(val username: String, val domainName: String)


/**
 * Object that contain the same name as the class/trait/case-class
 * calls as class-companion
 *
 * Object/class can access private defs and variables of its companion
 * Object && class companion should be in the same file
 *
 */
object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split("@") match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}
