package code

sealed trait Frame
final case class Strike() extends Frame
final case class Spare(one: Int) extends Frame
final case class Regular(one: Int, two: Int) extends Frame


object Main extends App {

  val testcase1 = List(Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike(),Strike())
  val testcase2 = List(Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0),Regular(9,0))
  val testcase3 = List(Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Spare(5),Regular(5,0))

  val result1: Int = 300
  val result2: Int = 90
  val result3: Int = 150

  val tests (testcase :Frame) {
    printf(result1 == calculate(testcase1))
    printf(result2 == calculate(testcase2))
    printf(result3 == calculate(testcase3))

  }
}