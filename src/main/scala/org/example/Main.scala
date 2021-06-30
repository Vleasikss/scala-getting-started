package main.scala.org.example


object Main {

  def main(args: Array[String]): Unit = {
    val utils = CollectionUtils

    val zippedCollection = utils.doZip(List(1, 2, 3, 4, 5), List("one", "two", "three", "four"))
    println(zippedCollection) // List((1,one), (2,two), (3,three), (4,four))

    val partitionedCollection = utils.doPartition(List(1, 2, 3, 4, 5, 6))
    println(partitionedCollection) // ( List(2, 4, 6), List(1, 3, 5) )

    val foldedLeftCollection = utils.doFoldLeft(List(1, 2, 3, 4, 5, 6))
    println(foldedLeftCollection) // 21

    val foldedRightCollection = utils.doFoldRight(List(1, 2, 3, 4, 5, 6))
    println(foldedRightCollection) // 21

    val flattenCollection = utils.doFlatten(List(1, 2, 3, 4, 5, 6), List(1, 2, 3, 4))
    print(flattenCollection) // List(1, 2, 3, 4, 5, 6, 1, 2, 3, 4)

  }

}

private object CollectionUtils {

  /**
   *
   * @param collection      - first Int element of Tuple in sequence
   * @param collectionToZip - second String element of Tuple in sequence
   * @return Joined collections into Sequence of Tuples[Int, String]
   */
  def doZip(collection: List[Int], collectionToZip: List[String]): Seq[(Int, String)] =
    collection.zip(collectionToZip)


  /**
   *
   * @param collection - collection to predicate
   * @return Tuple that will contain two collections: predicted && unpredicted
   */
  def doPartition(collection: List[Int]): (List[Int], List[Int]) =
    collection.partition(value => value % 2 == 0)


  /**
   * Do some lambda-action with <span style="color: purple">beginValue</span>, starts from beginning of collection
   *
   * @param collection collection to fold
   * @return sum of all the values in collection with startedValue: <span style="color: purple">beginValue</span>
   */
  def doFoldLeft(collection: List[Int]): Int = {
    val beginValue = 0
    collection.foldLeft(beginValue)((value, newValue) => value + newValue)
  }

  /**
   * Do some lambda-action with <span style="color: purple">beginValue</span>, starts from end of collection
   *
   * @param collection collection to fold
   * @return sum of all the values in collection with startedValue: <span style="color: purple">beginValue</span>
   */
  def doFoldRight(collection: List[Int]): Int = {
    val beginValue = 0
    collection.foldRight(beginValue)((value, newValue) => value + newValue)
  }

  /**
   * Collects the collections into one
   *
   * @param collection       first collection
   * @param collectionToFlat second collection
   * @return joined first collection && second collection
   */
  def doFlatten(collection: List[Int], collectionToFlat: List[Int]): List[Int] = {
    List(collection, collectionToFlat).flatten
  }
}