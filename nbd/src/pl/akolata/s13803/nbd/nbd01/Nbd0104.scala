package pl.akolata.s13803.nbd.nbd01

object Nbd0104 {
  val daysOfWeek: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def main(args: Array[String]): Unit = {
    val daysOfTheWeekFoldLeft = daysOfWeek.foldLeft(daysOfWeek.head)((a, b) => a + "," + b)
    println(daysOfTheWeekFoldLeft)

    val daysOfTheWeekFoldRight = daysOfWeek.foldRight("")((a, b) => a + "," + b)
    println(daysOfTheWeekFoldRight)

    val daysOfTheWeekFoldRightFilter = daysOfWeek.filter(day => day.startsWith("P")).foldRight("")((a, b) => a + "," + b)
    println(daysOfTheWeekFoldRightFilter)
  }
}
