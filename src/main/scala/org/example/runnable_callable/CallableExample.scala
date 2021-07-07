package org.example.runnable_callable

import java.util.concurrent.Callable

protected object CallableExample {

  /**
   * Runnable contain one method, that returns no value.
   *
   * Code will be compiled with -Xexperimental param
   */
  def main(args: Array[String]): Unit = {
    val callable: Callable[String] = () => "hello"

//    SingletonExecutorService.get().execute(callable)
  }

}
