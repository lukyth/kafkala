package thjug.decoder

import kafka.serializer.Decoder
import kafka.utils.VerifiableProperties

/**
  * Created by pasoktummarungsri on 11/30/2015 AD.
  */
case class StringDecoder(props: VerifiableProperties = null) extends Decoder[String] {

  val encoding =
    if(props == null)
      "UTF8"
    else
      props.getString("serializer.encoding", "UTF8")

  def fromBytes(bytes: Array[Byte]): String = {
    new String(bytes, encoding)
  }

}
