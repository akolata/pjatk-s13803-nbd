package pl.akolata.s13803.nbd.nbd02

object Nbd0205 {

  def main(args: Array[String]): Unit = {
    val student = new OsobaZad05("Student", "Studencki") with Student
    println(s"Student $student")

    val pracownik = new OsobaZad05("Pracownik", "Pracownikowski") with Pracownik
    pracownik.pensja = 1000
    println(s"Pracownik $pracownik")

    val nauczyciel = new OsobaZad05("Nauczyciel", "Nauczycielski") with Nauczyciel
    nauczyciel.pensja = 1000
    println(s"Nauczyciel $nauczyciel")

    val studentPracownik = new OsobaZad05("Student", "Pracownikowski") with Student with Pracownik
    studentPracownik.pensja = 1000
    println(s"studentPracownik $studentPracownik")

    val pracownikStudent = new OsobaZad05("Pracownik", "Studencki") with Pracownik with Student
    pracownikStudent.pensja = 1000
    println(s"pracownikStudent $pracownikStudent")
  }

}
