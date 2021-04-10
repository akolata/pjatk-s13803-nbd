package pl.akolata.s13803.nbd.nbd01

object Nbd0102 {
  val daysOfWeek: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def main(args: Array[String]): Unit = {
    val concatenatedDaysOfWeek = concatenateDaysUsingCommaRecursive(daysOfWeek)
    println(concatenatedDaysOfWeek)

    val concatenatedDaysOfWeekBackwards = concatenateDaysUsingCommaRecursiveBackwards2(daysOfWeek)
    println(concatenatedDaysOfWeekBackwards)
  }

  def concatenateDaysUsingCommaRecursiveBackwards2(daysOfWeek: List[String]): String = {
    def inner(daysOfWeekInner: List[String], index: Int): String = {
      if (index == 0)
        daysOfWeekInner(index)
      else if (index == 1) inner(daysOfWeekInner, index - 1)
      else daysOfWeekInner(index) + "," + inner(daysOfWeekInner, index - 1)
    }

    if (daysOfWeek.length == 1)
      daysOfWeek.last
    else
      daysOfWeek.last + "," + inner(daysOfWeek, daysOfWeek.length - 2)
  }

  def concatenateDaysUsingCommaRecursive(daysOfWeek: List[String]): String = daysOfWeek match {
    case Nil => ""
    case day :: tail =>
      if (tail.nonEmpty) day + "," + concatenateDaysUsingCommaRecursive(tail)
      else day + concatenateDaysUsingCommaRecursive(tail)
  }

}
