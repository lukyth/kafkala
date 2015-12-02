package thjug.actor

import akka.actor.{Props, ActorRef, ActorSystem, Actor}
import akka.routing.RoundRobinPool
import com.sclasen.akka.kafka.StreamFSM
import com.typesafe.scalalogging.Logger
import org.jcp.xml.dsig.internal.dom.DOMKeyValue.EC
import org.slf4j.LoggerFactory

import scala.util.Random

/**
  * @author Peerapat A
  */
class Distributer(system: ActorSystem) extends Actor {
  import Distributer._

  val rand = new Random()

  val actor: ActorRef =
    context.actorOf(RoundRobinPool(10).props(Props[EchoActor]), "echoactor")

  override def receive = {
    case msg: String => {
      log.info(s"Distribute $msg to ...")
      actor ! msg
    }
  }
}

private object Distributer {
  private lazy val log = Logger(LoggerFactory.getLogger("distributer"))
}
