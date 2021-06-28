package main.scala.org.example

object SalaryRaiser {

  private def promotion(salaries: Seq[Double], promotionFunction: Double => Double): Seq[Double] = {
    salaries.map(promotionFunction)
  }

  def smallPromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * 1.5)

  def hugePromotion(salaries: Seq[Double]): Seq[Double] =
    promotion(salaries, salary => salary * salary)

}
