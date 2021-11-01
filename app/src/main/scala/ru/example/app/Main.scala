package ru.example.app

import ru.example.core.CalcData
import ru.example.data.Data

import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]): Unit = {
    println(
      "Please enter an expression to be calculated in the format Number1 Operator Number2 :"
    )
    val str = readLine()
    val data = splitString(str)
    val calculator = new CalcData
    data.flatMap(calculator.calculate(_)) match {
      case Right(value) => println(value)
      case Left(str)    => println(str)
    }
  }

  def splitString(str: String): Either[String, Data] = {
    val strArr: List[String] = str.split(" ").toList
    strArr match {
      case n1 :: operation :: n2 :: Nil =>
        checkNum(n1)
          .flatMap { num1 =>
            checkNum(n2).map { num2 =>
              Data(num1, num2, getOperation(operation))
            }
          }
      case _ => Left("Input error")
    }
  }

  def checkNum(str: String): Either[String, BigDecimal] = {
    try Right(BigDecimal(str))
    catch {
      case _ => Left(s"Input error: $str")
    }
  }

  def getOperation(str: String): Char =
    str.head

}
