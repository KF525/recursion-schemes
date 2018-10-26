//higher kinded tree - pull the recursive piece out
sealed trait AListF[A]
case class NilF[A]() extends AListF[A]
case class ConsF[A](head: Int, a: A) extends AListF[A]


object AListF {

  def toFix[A]: AListF[A] => Fix[AListF] = {
      case NilF() => Fix.apply(NilF())
      case ConsF(h, a: AListF[A]) => Fix.apply(ConsF(h, toFix(a)))
    }
}
