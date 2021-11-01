package ru.example.core

import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.example.data.Data

class CalcDataTests extends AnyFlatSpec with EitherValues with should.Matchers {
  val calc = new CalcData

  "Core" should "addition 2 numbers" in {
    calc.calculate(Data(6, 3, '+')).right.value shouldBe 9
  }


  it should "substraction 2 numbers" in {
    calc.calculate(Data(6, 3, '-')).right.value shouldBe 3
  }

  it should "multiplication 2 numbers" in {
    calc.calculate(Data(6, 3, '*')).right.value shouldBe 18
  }

  it should "division 2 numbers" in {
    calc.calculate(Data(6, 3, '/')).right.value shouldBe 2
  }

  it should "zero division" in {
    calc.calculate(Data(6, 0, '/')) shouldBe 'left
  }

  it should "unknown operation" in {
    calc.calculate(Data(6, 3, '%')) shouldBe 'left
  }

  it should "rounding accuracy" in {
    calc.calculate(Data(7, 3, '/')).right.value shouldBe 2.33333
  }
}
