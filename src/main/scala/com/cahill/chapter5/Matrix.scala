package com.cahill.chapter5

case class Matrix[T:Numeric](columnVectors: List[Vector[T]]) {
  override def toString: String = {
    columnVectors
      .indices
      .map(_toString)
      .mkString(System.lineSeparator())
  }

  private def _toString(i: Int): String = {
    columnVectors.map(_(i)).mkString(" ")
  }
}
