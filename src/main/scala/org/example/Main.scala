package org.example

object Main {

  def main(args: Array[String]): Unit = {

    val message1 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")

    // equality
    assert(message1 == message2)

    // copying except recipient
    val message5 = message2.copy(recipient = "claire@bourgogne.fr")
    println(message5)
  }
}

/**
 *
 * case classes equality compares by structure, not by hrefs
 *
 * @param sender    public and immutable string value
 * @param recipient public and immutable string value
 * @param body      public and immutable string value
 */
case class Message(sender: String, recipient: String, body: String)
