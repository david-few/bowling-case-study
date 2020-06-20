package code

import org.scalatest._

class MainSpec extends WordSpec with Matchers {
  "calculate" should {
    "correctly calculate all strikes" in {
      val testcase1 = List(
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Strike(),
        Bonus(10,10)
      )

      Main.calculate(testcase1) shouldBe 300
    }

    "correctly calculate all regular" in {
      val testcase2 = List(
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0),
        Regular(9, 0)
      )
      Main.calculate(testcase2) shouldBe 90
    }

    "correctly calculate all spares" in {
      val testcase3 = List(
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Spare(5),
        Bonus(5, 0)
      )

      Main.calculate(testcase3) shouldBe 150
    }

    "correctly calculate mix 1" in {
      val testcase4 = List(
        Spare(5),
        Strike(),
        Spare(5),
        Strike(),
        Strike(),
        Spare(3),
        Regular(2,7),
        Regular(9,0),
        Spare(1),
        Spare(2),
        Bonus(9, 0)
      )

      Main.calculate(testcase4) shouldBe 164
    }

    "correctly calculate mix 2" in {
      val testcase4 = List(
        Spare(5),
        Strike(),
        Spare(5),
        Regular(4,5),
        Strike(),
        Spare(3),
        Regular(2,7),
        Regular(9,0),
        Spare(1),
        Strike(),
        Bonus(10, 10)
      )

      Main.calculate(testcase4) shouldBe 163
    }
  }
}
