package com.cahill.chapter5

import org.scalatest.FunSuite

class MatrixFunctionsTest extends FunSuite {

  test("matrix vector multiplication") {
    val baseMatrix: Matrix[Int] = Matrix(
      List(
        Vector[Int](0, 0, 1),
        Vector[Int](2, 1, 0),
        Vector[Int](1, 0, -1)
      )
    )
    val vectorToMultiply: Vector[Int] = Vector(3, -2, 5)
    val resultVector = MatrixFunctions.multiplyMatrixVector(baseMatrix, vectorToMultiply)
    assert(resultVector.equals(Vector(1, -2, -2)))
  }

  test("matrix matrix multiplication") {
    val m1: Matrix[Int] = Matrix(
      List(
        Vector[Int](1, 1, 1),
        Vector[Int](1, 0, -1),
        Vector[Int](0, 1, 1)
      )
    )

    val m2: Matrix[Int] = Matrix(
      List(
        Vector[Int](0, 0, 1),
        Vector[Int](2, 1, 0),
        Vector[Int](1, 0, -1)
      )
    )
    val resultMatrix = MatrixFunctions.multiplyMatrixMatrix(m1, m2)
    val expectedMatrix = Matrix(
      List(
        Vector[Int](0, 1, 1),
        Vector[Int](3, 2, 1),
        Vector[Int](1, 0, 0)
      )
    )
    assert(resultMatrix.equals(expectedMatrix))
  }

  test("2x2 matrix matrix multiplication") {
    val m1: Matrix[Int] = Matrix(
      List(
        Vector[Int](1, 3),
        Vector[Int](2, 4)
      )
    )

    val m2: Matrix[Int] = Matrix(
      List(
        Vector[Int](0, 1),
        Vector[Int](-1, 0)
      )
    )
    val resultMatrix = MatrixFunctions.multiplyMatrixMatrix(m1, m2)
    val expectedMatrix = Matrix(
      List(
        Vector[Int](2, 4),
        Vector[Int](-1, -3)
      )
    )
    assert(resultMatrix.equals(expectedMatrix))
  }

  test("different size matrixes") {
    val m1: Matrix[Int] = Matrix(
      List(
        Vector[Int](-1, -2, 1),
        Vector[Int](-1, 1, 0),
        Vector[Int](0, 2, -1)
      )
    )

    val m2: Matrix[Int] = Matrix(
      List(
        Vector[Int](1, 1, 1)
      )
    )

    val resultMatrix = MatrixFunctions.multiplyMatrixMatrix(m1, m2)
    val expectedMatrix = Matrix(
      List(
        Vector[Int](-2, 1, 0)
      )
    )
    assert(resultMatrix.equals(expectedMatrix))
  }
}
