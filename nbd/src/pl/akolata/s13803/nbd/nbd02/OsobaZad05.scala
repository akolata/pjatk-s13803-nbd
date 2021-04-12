package pl.akolata.s13803.nbd.nbd02

abstract class OsobaZad05(val imie: String, val nazwisko: String) {
  def podatek(): BigDecimal

  override def toString = s"Osoba($imie, $nazwisko, $podatek)"
}
