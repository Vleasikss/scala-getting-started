package main.scala.org.example

object Main {

  def main(args: Array[String]): Unit = {
    val salaries = Seq(2000, 3000, 4000): Seq[Double]
    val doubleSalary = (x: Double) => x * 2
    val newSalaries = salaries.map(doubleSalary)
    println(newSalaries)

    val newNewSalaries = getNewSalaries(salaries)
    println(newNewSalaries)

    val promotion = SalaryRaiser.bigPromotion(salaries)
    println(promotion)

    val domainName = "www.example.com"
    val getURL = UriBuilder.build(ssl = true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)
  }

  /**
   * (_ * 2) = (salary => salary * 2)
   */
  def getNewSalaries(salaries: Seq[Double]): Seq[Double] = {
    salaries.map(_ * 2)
  }
}
