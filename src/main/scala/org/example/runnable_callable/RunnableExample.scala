package org.example.runnable_callable

protected object RunnableExample {

  /**
   * Runnable contain one method, that return no value
   */
  def main(args: Array[String]): Unit = {

    val runnable:Runnable = () => println("Runnable example")

    SingletonExecutorService.get().execute(runnable)
  }

}
