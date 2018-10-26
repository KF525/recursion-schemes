//FA => A, Functor of A to A
object FAlgebra {

  type FAlgebra[F[_], A] = F[A] => A

  def in: AListF[AList] => AList = {
    case NilF() => ANil
    case ConsF(h,t) => ACons(h,t)
  }

  def out: AList => AListF[AList] = {
    case ANil => NilF()
    case ACons(h, t) => ConsF(h, t)
  }

  def multiplyAlgebra: FAlgebra[AListF, Int] = {
    case NilF() => 1
    case ConsF(h, i) => h * i
  }
}
