package thjug.kafka

import org.scalatest.FunSuite

import scala.util.Random

class KafkaProducerSpec extends FunSuite {

  private val rand = new Random()
  private val kafka = new KafkaProducer[String]("localhost:9092", "test", None, true)

  test("testSend with no Exception.") {
    for (a <- 1 to 100) {
      val p = rand.nextInt(10)
      kafka.send(s"P$p - ${System.currentTimeMillis}", p.toString)
    }
  }

}
