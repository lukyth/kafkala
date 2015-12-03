package thjug.kafka

import akka.actor.ActorSystem
import org.scalatest.FunSuite

class KafkaConsumerSpec extends FunSuite {

    test("Start consumer without Exception.") {
      val system = ActorSystem("cusco")

      KafkaConsumer(system)
    }

}
