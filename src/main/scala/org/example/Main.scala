package main.scala.org.example

/**
 * Type Any -
 */
object Main {

  val ANY_VALUES: Map[String, AnyVal] = Map(
    "Integer" -> 123,
    "Char" -> 'c',
    "Float" -> 123.123,
    "Boolean" -> true
  )
  val ANY_REFS: Map[String, AnyRef] = Map(
    "Lambda" -> (() => "Lambda function"),
    "List" -> List("STRING"),
    "String" -> "String"
  )

  def main(args: Array[String]): Unit = {
    val any: List[Any] = List(
      ANY_VALUES("Integer"),
      ANY_VALUES("Char"),
      ANY_VALUES("Boolean"),
      ANY_REFS("String"),
      ANY_REFS("Lambda")
    )
    any.foreach(element => println(element))

    val listValues: List[AnyVal] = List(
      ANY_VALUES("Integer"),
      ANY_VALUES("Float"),
      ANY_VALUES("Boolean"))
    listValues.foreach(element => println(element))

    val listObjects: List[AnyRef] = List(
      ANY_REFS("Lambda"),
      ANY_REFS("String"),
      ANY_REFS("List")
    )
    listObjects.foreach(element => println(element))
  }
}