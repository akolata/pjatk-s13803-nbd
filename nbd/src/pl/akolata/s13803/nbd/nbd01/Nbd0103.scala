package pl.akolata.s13803.nbd.nbd01

import scala.annotation.tailrec

object Nbd0103 {
  val daysOfWeek: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def main(args: Array[String]): Unit = {
    val concatenatedDaysOfWeekTailRec = printRecursiveTailRec(daysOfWeek)
    println(concatenatedDaysOfWeekTailRec)
  }

  def printRecursiveTailRec(daysOfWeek: List[String]): String = {
    @tailrec
    def inner(daysOfWeek: List[String], day: String): String = {
      daysOfWeek match {
        case Nil => day
        case x :: tail => inner(tail, day + "," + x)
      }
    }

    inner(daysOfWeek.tail, daysOfWeek.head)
  }
}
