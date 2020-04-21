package com.cahill.chapter5

object MatrixFunctions {
  import Numeric.Implicits._

  def multiplyMatrixVector[T:Numeric](m: Matrix[T], v: Vector[T]): Vector[T] = {
    val multipliedColumns = m.columnVectors
      .zipWithIndex
      .map(t => t._1.map(e => e * v(t._2)))

    multipliedColumns
      .indices
      .map(i => multipliedColumns.map(mc => mc(i)).sum)
      .toVector
  }

  def multiplyMatrixMatrix[T:Numeric](m1: Matrix[T], m2: Matrix[T]): Matrix[T] = {
    Matrix(
      m2
        .columnVectors
        .indices
        .map(i => multiplyMatrixVector(m1,m2.columnVectors(i))).toList
    )
  }
}
