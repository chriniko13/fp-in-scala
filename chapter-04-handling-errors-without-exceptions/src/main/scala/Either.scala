package com.github.plippe.fpinscala.chapter04

sealed trait Either[+E, +A] {

  /** EXERCISE 4.6
    *
    * Implement versions of map, flatMap, orElse, and map2 on Either that operate on the
    * Right value.
    */
  def map[B](f: A => B): Either[E, B] = ???
  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = ???
  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = ???
  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = ???

}

case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]

object Either {

  /** EXERCISE 4.7
    *
    * Implement sequence and traverse for Either. These should return the first error
    * that’s encountered, if there is one.
    */
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = ???
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    ???

  /** EXERCISE 4.8
  *
  * In this implementation, map2 is only able to report one error, even if both the name
  * and the age are invalid. What would you need to change in order to report both errors?
  * Would you change map2 or the signature of mkPerson? Or could you create a new data
  * type that captures this requirement better than Either does, with some additional
  * structure? How would orElse, traverse, and sequence behave differently for that
  * data type?
  */

}
