import scala.annotation.tailrec

object KthOrderStatistic {
  @tailrec
  def kthOrderStatistic(k: Int, nums: List[Int]): Int = {
    def partition(list: List[Int], pivot: Int): (List[Int], List[Int], List[Int]) = {
      val (l, e, g) = list.foldLeft((List.empty[Int], List.empty[Int], List.empty[Int])) {
        case ((l, e, g), x) =>
          if (x < pivot) (x :: l, e, g)
          else if (x == pivot) (l, x :: e, g)
          else (l, e, x :: g)
      }
      (l, e, g)
    }
    
    val pivot = nums.head
    val (l, e, g) = partition(nums, pivot)
    if (k <= l.length) {
      kthOrderStatistic(k, l)
    } else if (k <= l.length + e.length) {
      pivot
    } else {
      kthOrderStatistic(k - l.length - e.length, g)
    }
  }
}
