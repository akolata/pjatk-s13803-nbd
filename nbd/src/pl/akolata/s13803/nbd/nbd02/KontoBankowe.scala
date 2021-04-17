package pl.akolata.s13803.nbd.nbd02

class KontoBankowe(stanKontaPoczatkowy: BigDecimal) {
  private var _stanKonta: BigDecimal = stanKontaPoczatkowy

  def this() {
    this(0)
  }

  def stanKonta: BigDecimal = _stanKonta

  def wplata(kwota: BigDecimal): Unit = {
    this._stanKonta = this._stanKonta + kwota
  }

  def wyplata(kwota: BigDecimal): Unit = {
    this._stanKonta = this._stanKonta - kwota
  }

}
