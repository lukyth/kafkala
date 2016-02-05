package thjug.kafka

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.routing.RoundRobinPool
import com.sclasen.akka.kafka.{AkkaConsumer, AkkaConsumerProps}
import thjug.actor.{EchoActor, Distributer}
import thjug.decoder.StringDecoder

/**
  * @author Peerapat A
  */
object KafkaConsumer extends App {

  val system = ActorSystem("Cocao")

  val distributer = system.actorOf(Props(new Distributer(system)), name = "distributer")

  val actor: ActorRef =
    system.actorOf(RoundRobinPool(10).props(Props[EchoActor]), "echoactor")

  val consumerProps = AkkaConsumerProps.forSystem(
    system = system,
    zkConnect = "hadoop-dev:2181",
    topic = "traffic",
    group = "akka-kafka",
    streams = 10,
    keyDecoder = StringDecoder(),
    msgDecoder = StringDecoder(),
    receiver = actor
  )

  val consumer = new AkkaConsumer(consumerProps)
  consumer.start

}
