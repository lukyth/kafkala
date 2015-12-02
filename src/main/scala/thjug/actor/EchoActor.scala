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
      log.info(s"Start $msg")
      Thread.sleep(rand.nextInt(4) * 1000)
      sender ! StreamFSM.Processed
      log.info(s"$msg, Finish")
    }
    case _ => {
      log.info(s"Yo! $senderId")
      sender ! StreamFSM.Processed
    }
  }

  private val senderId: String = sender.hashCode.toString

  private val threadId: String = {
    val name = this.toString.split("@")
    name(name.length - 1)
  }
}

private object EchoActor {
  private lazy val log = Logger(LoggerFactory.getLogger("echoactor"))
  private val rand = new Random
}
