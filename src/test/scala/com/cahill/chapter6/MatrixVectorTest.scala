package com.cahill.chapter6

import org.scalatest.FunSuite

class MatrixVectorTest extends FunSuite {
  test("multiply by scalar") {
    val m: MatrixVector[Int] = MatrixVector(Vector(1, 2, 3, 4))

    assert(m.scale(1).equals(m))
  }

  test("subtract vector to vector") {
    val m: MatrixVector[Int] = MatrixVector(Vector(1, 2, 3, 4))
    val m1: MatrixVector[Int] = MatrixVector(Vector(1, 2, 3, 4))

    assert(m.sub(m1).equals(MatrixVector[Int](Vector(0, 0, 0, 0))))

    assert((m - m1).equals(MatrixVector[Int](Vector(0, 0, 0, 0))))
  }

  test("add vector to vector") {
    val m: MatrixVector[Int] = MatrixVector(Vector(1, 2, 3, 4))
    val zeros: MatrixVector[Int] = MatrixVector[Int](Vector(0, 0, 0, 0))

    assert((m + zeros).equals(m))
  }
}
