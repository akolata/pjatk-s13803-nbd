package pl.akolata.s13803.nbd.nbd01

object Nbd0101 {
  val daysOfWeek: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def main(args: Array[String]): Unit = {
    val daysOfTheWeekForLoop = exampleOfForLoop()
    println(daysOfTheWeekForLoop)

    val daysOfTheWeekStartingWithLetterPWithForLoop = exampleOfForLoopStartingWithLetterP()
    println(daysOfTheWeekStartingWithLetterPWithForLoop)

    val daysOfTheWeekWhileLoop = exampleOfWhileLoop()
    println(daysOfTheWeekWhileLoop)
  }

  def exampleOfForLoop(): String = {
    var combined = ""

    for (day <- daysOfWeek) {
      combined += day
      if (!day.equals(daysOfWeek.last)) combined += ","
    }

    combined
  }

  def exampleOfForLoopStartingWithLetterP(): String = {
    var combined = ""

    for (day <- daysOfWeek) {
      val shouldBeAdded = day.startsWith("P")
      if (shouldBeAdded && !combined.equals("")) combined += ","
      if (shouldBeAdded) combined += day
    }

    combined
  }

  def exampleOfWhileLoop(): String = {
    var combined = ""

    val iterator = daysOfWeek.iterator
    while (iterator.hasNext) {
      val day = iterator.next()
      combined += day
      if (!day.equals(daysOfWeek.last)) combined += ","
    }

    combined
  }
}
