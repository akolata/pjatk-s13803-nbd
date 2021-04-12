package pl.akolata.s13803.nbd.nbd02

trait Nauczyciel extends Pracownik {
  override def podatek(): BigDecimal = 0.1 * pensja
}
