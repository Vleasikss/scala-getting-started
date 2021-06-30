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

  val CTX_STRING:(String, String) = ("This is string", "String")
  val CTX_INT:(String, Int) = ("This is integer", 1)

  def printContext(implicit ctx: Context): Unit = println(ctx.name)

  def printContextGenerics[T](x: T)(implicit ctx: ContextGenerics[T]): String = {
    val result = s"${ctx.name}: $x"
    result
  }


  def main(args: Array[String]): Unit = {
    implicit val ctx: Context = Context("Hello world")
    printContext

    implicit val ctxInt: ContextGenerics[Int] = ContextGenerics[Int](CTX_INT._1)
    implicit val ctxStr: ContextGenerics[String] = ContextGenerics[String](CTX_STRING._1)

    val resultCtxInt: String = printContextGenerics(CTX_STRING._2)
    val resultCtxString: String = printContextGenerics(CTX_STRING._2)

    println(resultCtxInt)
    println(resultCtxString)


    // EXPLANATION
    assert(resultCtxInt == printContextGenerics(CTX_INT._2)(ctxInt))
    assert(resultCtxString == printContextGenerics(CTX_STRING._2)(ctxStr))

  }
}

case class Context(name: String)

case class ContextGenerics[T](name: String)
