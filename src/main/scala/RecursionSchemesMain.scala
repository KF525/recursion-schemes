import Cata.cata
import ListFFunctor._

object RecursionSchemesMain extends App {

  val aList: AList = ACons(3, ACons(6, ANil))
  val fList = ConsF(1, ConsF(2, ConsF(3, NilF())))
  val fListOfAList: AListF[AList] = ConsF(1,ACons(2,ANil))

  val multiplication: Int = AList.multiply(aList)
  println(multiplication)
  println(FAlgebra.in(fListOfAList))
  FAlgebra.out(aList)
  println(FAlgebra.in(FAlgebra.out(aList)))

  val f = (i: Int) => i.toString
  //ListFFunctor.listFFunctor.map(f)(aList)
  def multiply: Fix[AListF] => Int = cata(FAlgebra.multiplyAlgebra, Fix.out)
  println(multiply(AListF.toFix(fList)))
}
