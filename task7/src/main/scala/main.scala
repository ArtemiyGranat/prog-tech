import scala.concurrent.{ExecutionContext, Future}
import java.util.concurrent.Executors
import scala.util.{Success, Failure}

object SequenceTransformation extends App {
  private def generateSequence(length: Int): Seq[(Int, Int)] = {
    (1 to length).map(_ => (scala.util.Random.nextInt(21) - 10, scala.util.Random.nextInt(21) - 10))
  }

  private def transformSequence(sequence: Seq[(Int, Int)], operation: Char): Seq[Int] = {
    sequence.map {
      case (a, b) =>
        operation match {
          case 'a' => a + b
          case 'b' => a * b
          case 'c' => math.pow(a, b).toInt
          case 'd' => if (b != 0) a / b else throw new IllegalArgumentException("Division by zero!")
          case _ => throw new IllegalArgumentException("Invalid operation!")
        }
    }
  }

  private def runTransformationWithThreads(numThreads: Int): Unit = {
    val startTime = System.nanoTime()
    val threadPool = Executors.newFixedThreadPool(numThreads)
    implicit val executionContext: ExecutionContext = ExecutionContext.fromExecutor(threadPool)
    val sequenceLength = 10000
    val randomSequence = generateSequence(sequenceLength)
//    println(s"Original sequence: {$randomSequence}")
    val operationChoice = 'a'

    val splitSize = randomSequence.length / numThreads
    val splitSequences = randomSequence.grouped(splitSize).toSeq

    val futures = splitSequences.map { part =>
      Future {
        transformSequence(part, operationChoice)
      }
    }

    val combinedFuture = Future.sequence(futures)
    combinedFuture.onComplete {
      case Success(results) =>
        val combinedResult = results.flatten
        val endTime = System.nanoTime()
//        println(s"Transformed sequence (operation $operationChoice): $combinedResult")
        val elapsedTimeInSeconds = (endTime - startTime) / 1e6
        println(s"Time taken with $numThreads threads: $elapsedTimeInSeconds milliseconds")
        threadPool.shutdown()
      case Failure(exception) =>
        println(s"Error occurred: $exception")
        threadPool.shutdown()
    }
  }

  private val numThreads = List(1, 2, 4, 5)
  numThreads.foreach { num => {
    runTransformationWithThreads(num)
    Thread.sleep(1000)
  }
  }
  println("Хочу автомат")
}
