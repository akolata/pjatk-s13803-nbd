package pl.akolata.s13803.nbd.nbd02

object Nbd0203 {

  def main(args: Array[String]): Unit = {
    val osoba01 = OsobaZad03("Jan", "Kowalski")
    println(caseClassGreetings(osoba01))

    val osoba02 = OsobaZad03("Artur", "Nowak")
    println(caseClassGreetings(osoba02))

    val osoba03 = OsobaZad03("Piotr", "Piotrkowski")
    println(caseClassGreetings(osoba03))

    val osoba04 = OsobaZad03("Paweł", "Pawelski")
    println(caseClassGreetings(osoba04))
  }

  def caseClassGreetings(osoba: OsobaZad03): String = osoba match {
    case OsobaZad03("Jan", "Kowalski") => "Powitanie nr 1 dla Jana Kowalskiego"
    case OsobaZad03("Artur", "Nowak") => "Powitanie nr 2 dla Artura Nowaka"
    case OsobaZad03("Piotr", "Piotrkowski") => "Powitanie nr 3 dla Piotra Piotrkowskiego"
    case _ => s"Domyślne powitanie dla ${osoba.imie} ${osoba.nazwisko}"
  }

}
