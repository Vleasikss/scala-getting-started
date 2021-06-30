package main.scala.org.example

object SalaryRaiser {

  val SMALL_PROMOTION_PERCENTAGE = 1.1
  val BIG_PROMOTION_PERCENTAGE = 1.5

  private def promotion(salaries: Seq[Double], promotionFunction: Double => Double): Seq[Double] = {
    salaries.map(promotionFunction)
  }

  def smallPromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * SMALL_PROMOTION_PERCENTAGE)

  def bigPromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * BIG_PROMOTION_PERCENTAGE)

  def hugePromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * salary)

}
