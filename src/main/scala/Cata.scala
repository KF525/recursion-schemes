object Cata {

  // Fix of AList => Alist of Fix of AList
  def cata[F[_], R, A](algebra: F[A] => A, out: Fix[F] => F[Fix[F]])(r: Fix[F])(implicit F: Functor[F]): A = {
    val functorR: F[Fix[F]] = out(r)
    val functorA: F[A] = F.map(cata(algebra, out))(functorR)
    algebra(functorA)
  }
}
