package org.example.runnable_callable

import java.util.concurrent.{ExecutorService, Executors}

protected object SingletonExecutorService {

  private val executorService: ExecutorService = Executors.newFixedThreadPool(2)
  def get(): ExecutorService = executorService
}
