
sealed trait ATree[+A]
case class ALeaf[A](value: A) extends ATree[A]
case class ANode[A](left: ATree[A], right: ATree[A]) extends ATree[A]

object ATree {
  def foldTree[A](onLeaf: A => A, onNode: (A, A) => A): ATree[A] => A = {
    case ALeaf(a) => onLeaf(a)
    case ANode(l, r) => onNode(foldTree(onLeaf, onNode)(l), foldTree(onLeaf, onNode)(r))
  }

  def sum: ATree[Int] => Int = foldTree(identity, _+_)
  def countLeaves: ATree[Int] => Int = foldTree(_ => 1, _+_)
}
