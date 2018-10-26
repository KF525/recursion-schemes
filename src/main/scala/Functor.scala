
trait Functor[F[_]] {
  def map[A,B](f:A=>B): F[A] => F[B]
}

object ListFFunctor {
  implicit val listFFunctor: Functor[AListF] = new Functor[AListF] {
    override def map[A, B](f: A => B): AListF[A] => AListF[B] = {
      case NilF() => NilF()
      case ConsF(h, t) => ConsF(h, f(t))
    }
  }
}
