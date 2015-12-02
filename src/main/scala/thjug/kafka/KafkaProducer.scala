package thjug.kafka

import java.util.Properties

import com.typesafe.scalalogging.Logger
import kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import org.slf4j.LoggerFactory

/**
  * @author Peerapat A
  */
class KafkaProducer[T](servers:String, topic: String, serializer: Option[String], requireAck: Boolean) {
  import KafkaProducer._

  private lazy val props = new Properties()
  props.put("metadata.broker.list", servers)
  props.put("serializer.class", serializeClass)
  props.put("request.required.acks", if (requireAck) "1" else "0")

  private lazy val config = new ProducerConfig(props)
  val producer = new Producer[String, T](config)

  log.info(s"Created connection to $servers")

  def send(msg: T, partition: String = "0"): Unit = {
    val data = new KeyedMessage[String, T](topic, partition, msg)
    producer.send(data)
  }

  private def serializeClass: String = serializer.getOrElse("kafka.serializer.StringEncoder")

}

private object KafkaProducer {
  private lazy val log = Logger(LoggerFactory.getLogger("producer"))
}
