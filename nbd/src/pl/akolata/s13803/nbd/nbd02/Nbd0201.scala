package pl.akolata.s13803.nbd.nbd02

object Nbd0201 {

  def main(args: Array[String]): Unit = {
    println(weekDaysPatternMatching("Poniedziałek"))
    println(weekDaysPatternMatching("Wtorek"))
    println(weekDaysPatternMatching("Środa"))
    println(weekDaysPatternMatching("Czwartek"))
    println(weekDaysPatternMatching("Piątek"))
    println(weekDaysPatternMatching("Sobota"))
    println(weekDaysPatternMatching("Niedziela"))
  }

  def weekDaysPatternMatching(day: String): String = day match {
    case "Poniedziałek" => "Praca"
    case "Wtorek" => "Praca"
    case "Środa" => "Praca"
    case "Czwartek" => "Praca"
    case "Piątek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
  }

}
