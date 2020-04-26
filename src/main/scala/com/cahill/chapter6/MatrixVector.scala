package com.cahill.chapter6

import Numeric.Implicits._

case class MatrixVector[T:Numeric](v: Vector[T]){

  def scale(scalar: T): MatrixVector[T] =
    MatrixVector[T](v.map(_ * scalar))

  def add(other: MatrixVector[T]): MatrixVector[T] =
    MatrixVector[T](v.zip(other.v).map(t => t._1 + t._2))

  def +(other: MatrixVector[T]): MatrixVector[T] = add(other)

  def sub(other: MatrixVector[T]): MatrixVector[T] =
    add(other.scale(-1.asInstanceOf[T]))

  def -(other: MatrixVector[T]): MatrixVector[T] = sub(other)

}
