//recursive data type, data type that calls itself
sealed trait AList
case object ANil extends AList
case class ACons(head: Int, tail: AList) extends AList

object AList {
  //recursive collapse, catamorphism
  def foldAList[A](onNil: A, onCons: (Int, A)=> A): AList => A = {
    case ANil => onNil
    case ACons(h, t) => onCons(h, foldAList(onNil, onCons)(t))
  }

  def multiply: AList => Int = foldAList(1, (a: Int, b: Int) => a * b)
  def length: AList => Int = foldAList(0, (_: Int, length: Int) => length + 1)
}
