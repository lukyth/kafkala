package thjug.actor

import akka.actor.Actor
import com.sclasen.akka.kafka.StreamFSM
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.util.Random

/**
  * @author Peerapat A
  */
class EchoActor extends Actor {
  import EchoActor._

  override def receive = {
    case msg: String => {
      log.info(s"$msg, Finish")

      sender ! StreamFSM.Processed
    }
  }

}

private object EchoActor {
  private lazy val log = Logger(LoggerFactory.getLogger("echoactor"))
}
