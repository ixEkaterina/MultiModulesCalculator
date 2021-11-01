package ru.example.app

import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import Main._

class AppTests extends AnyFlatSpec with EitherValues with should.Matchers {

    "App" should "fail input string instead of numbers" in {
      checkNum("asdads") shouldBe 'left
    }

    it should "illegal number's format" in {
      checkNum("17,232") shouldBe 'left
    }

    it should "correct format of number" in {
      checkNum("17.232") shouldBe Right(BigDecimal(17.232))
    }

}
