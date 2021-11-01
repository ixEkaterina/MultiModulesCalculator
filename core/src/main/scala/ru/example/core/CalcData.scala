package ru.example.core

import ru.example.data.Data

import scala.math.BigDecimal.RoundingMode

class CalcData {
  def calculate(data: Data): Either[String, BigDecimal] =
    (data.operation match {
      case '+' => Right(data.num1 + data.num2)
      case '-' => Right(data.num1 - data.num2)
      case '*' => Right(data.num1 * data.num2)
      case '/' if data.num2 != BigDecimal(0) => Right(data.num1 / data.num2)
      case '/' if data.num2 == BigDecimal(0) => Left("zero divided")
      case _ => Left("operation unsupported")
    }).map{ value =>
      if (value.scale <= 5) value
      else value.setScale(5, RoundingMode.HALF_UP)
    }
}
