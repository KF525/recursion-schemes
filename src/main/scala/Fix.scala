
case class Fix[F[_]](unfix: F[Fix[F]])

object Fix {

  def in[F[_]]: F[Fix[F]] => Fix[F] = (a: F[Fix[F]]) => Fix.apply(a)

  def out[F[_]]: Fix[F] => F[Fix[F]] = (a: Fix[F]) => a.unfix

}