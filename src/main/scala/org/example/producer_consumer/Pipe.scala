package org.example.producer_consumer

class A
class B extends A
class C extends B

// co-variant - can't be used
// contra-variant - can't be used

// pipe - can be read, can be written
class Pipe[T] {
  def read: T = ??? // co-variant position
  def write(arg: T):Unit = ??? // contra-variant position
  def f(arg: T ): T = ??? // co-variant position
}

object Demo extends App {
  def f(pipe: Pipe[B]): Unit = {
    val x:B = pipe.read
    pipe.write(new B)
  }
  f(new Pipe[B])  // only non-variant can be used for writing && reading
  f(new Pipe[C]) // child-type can't be used for writing
  f(new Pipe[A]) // super-type can't be used for reading
}