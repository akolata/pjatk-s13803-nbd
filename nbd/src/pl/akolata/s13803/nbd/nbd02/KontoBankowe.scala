package pl.akolata.s13803.nbd.nbd02

class KontoBankowe(var stanKonta: BigDecimal) {

  def this() {
    this(0)
  }

  def wplata(kwota: BigDecimal): Unit = {
    this.stanKonta = this.stanKonta + kwota
  }

  def wyplata(kwota: BigDecimal): Unit = {
    this.stanKonta = this.stanKonta - kwota
  }

}
