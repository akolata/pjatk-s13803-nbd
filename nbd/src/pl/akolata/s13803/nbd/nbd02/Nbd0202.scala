package pl.akolata.s13803.nbd.nbd02

object Nbd0202 {

  def main(args: Array[String]): Unit = {
    val account01 = new KontoBankowe(1000)
    account01.wplata(100)
    account01.wyplata(200)
    println(account01.stanKonta)

    val account02 = new KontoBankowe()
    account02.wplata(500)
    account02.wyplata(100)
    println(account02.stanKonta)
  }

}
