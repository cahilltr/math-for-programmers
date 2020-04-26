package com.cahill.chapter6

import Numeric.Implicits._

case class LinearFunction[T:Numeric](x: T, y: T) {

  def +(o: LinearFunction[T]): LinearFunction[T] =
    LinearFunction[T](x + o.x, y + o.y)

  def scale(scalar: T): LinearFunction[T] =
    LinearFunction[T](x * scalar, y * scalar)
}
