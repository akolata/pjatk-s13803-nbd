package pl.akolata.s13803.nbd.nbd02

trait Pracownik extends OsobaZad05 {
  private var _pensja: BigDecimal = 0

  override def podatek(): BigDecimal = 0.2 * pensja

  def pensja: BigDecimal = _pensja

  def pensja_=(value: BigDecimal): Unit = _pensja = value
}
