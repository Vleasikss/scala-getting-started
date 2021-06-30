package org.example


/**
 * Самоописываемый тип(Self type) - это способ объявить,
 * что трейт должен быть смешан с другим трейтом,
 * даже если он не расширяет его напрямую.
 * Что открывает доступ к членам зависимости без импортирования.
 */
object Main {

  def main(args: Array[String]): Unit = {

    val realBeyonce = new TweeterAdmin("Beyonce")
    realBeyonce.tweet("Hello tweeter")
    realBeyonce.blog("Hello blog")

    val networkAdmin = new MainNetworkAdmin("Oleg")
    networkAdmin.createPhoto("I am creator of this networks")
    networkAdmin.tweet("Hello tweeter")
    networkAdmin.blog("Hello blog")

  }

}


trait User {
  def username: String
}

trait Admin extends User {
  def role: String
}

/**
 * Self-type means that <br/>
 * <strong>a trait has to be mixed with another trait</strong>
 *
 * @tparam T - another trait
 */
//T <: User = everything that is User or extend its
trait Tweeter[T <: User] {
  this: T =>

  def tweet(tweetText: String): Unit = println(s"$username tweeted: $tweetText")

  def blog(blogText: String): Unit = println(s"$username blogged: $blogText")

}

trait Instagram[T <: User] {
  this: T =>
  def createPhoto(title: String): Unit = println(s"$username published new photo: title=$title")
}

trait MainSocialNetworkUser[T <: User] {
  this: T with Tweeter[T] with Instagram[T] =>
}

class TweeterAdmin(val username_ : String) extends Tweeter[Admin] with Admin {
  override def username: String = s"real $username_"

  override def role: String = "MAIN-ADMIN"
}

/**
 * We have to extend all the dependencies
 * that we created and override all the methods of them
 *
 */
class MainNetworkAdmin(val username_ : String) extends MainSocialNetworkUser[Admin] with Tweeter[Admin] with Instagram[Admin] with Admin {
  override def role: String = "NETWORK-ADMIN"

  override def username: String = s"Network admin, $username_"
}