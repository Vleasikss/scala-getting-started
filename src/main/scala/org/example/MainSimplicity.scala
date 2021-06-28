package main.scala.org.example


/**
 * Main concept of 'implicit' keyword
 * Declaring param of method with its keyword means,
 * that we have to:
 *    - to declare a variable with 'implicit' keyword
 *      (compiler will get this variable and call the function completely)
 *    - to call the method completely
 *
 * Rules:
 *    - we can't declare more than one same by type implicit variables for implicit methods
 *    - we have to declare at least one implicit variable with method implicit param type,
 *      or to call the method completely
 *
 */
object MainSimplicity {

  val CTX_STRING_VALUE: String = "String"
  val CTX_INT_VALUE: Int = 1

  def printContext(implicit ctx: Context): Unit = println(ctx.name)

  def printContextGenerics[T](x: T)(implicit ctx: ContextGenerics[T]): String = {
    val result = s"${ctx.name}: $x"
    result
  }


  def main(args: Array[String]): Unit = {
    implicit val ctx: Context = Context("Hello world")
    printContext

    implicit val ctxInt: ContextGenerics[Int] = ContextGenerics[Int]("This is integer")
    implicit val ctxStr: ContextGenerics[String] = ContextGenerics[String]("This is string")

    val resultCtxInt: String = printContextGenerics(CTX_INT_VALUE)
    val resultCtxString: String = printContextGenerics(CTX_STRING_VALUE)

    println(resultCtxInt)
    println(resultCtxString)


    // EXPLANATION
    assert(resultCtxInt == printContextGenerics(CTX_INT_VALUE)(ctxInt))
    assert(resultCtxString == printContextGenerics(CTX_STRING_VALUE)(ctxStr))

  }
}

case class Context(name: String)

case class ContextGenerics[T](name: String)
