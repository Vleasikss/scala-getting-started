package main.scala.org.example

import java.sql.{Connection, DriverManager}


/**
 * SBT - scala build tool
 */
object Main {

  def main(args: Array[String]): Unit = {
    val driver = "com.mys.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/example_db"
    val username = "root"
    val password = "root"
    try {
      Class.forName(driver)
      val connection:Connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      //language=SQL
      val rs = statement.executeQuery("SELECT id, name FROM user")
      while (rs.next()) {
        val name = rs.getString("name")
        val id = rs.getString("id")
        println(s"name = $name, id=$id")

      }
      connection.close()
    } catch {
      case e: Exception => e.printStackTrace()
    }

  }
}