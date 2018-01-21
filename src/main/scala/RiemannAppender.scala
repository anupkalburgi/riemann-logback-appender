import ch.qos.logback.core.UnsynchronizedAppenderBase
import io.riemann.riemann.client.RiemannClient

import scala.util.Try


class RiemannAppender[E] extends UnsynchronizedAppenderBase[E] {



  override def append(eventObject: E): Unit = {
    println("have to make riemann connection from here-testing")
    println(eventObject.toString)

  Try {
    val rc = RiemannClient.tcp("192.168.0.15", 5555)
    rc.connect()
    (1 to 5000).foreach(i =>
      rc.event().service("Logback-service").state(s"just-started- $i").tags("running", "willrun", s"${i}").send().deref()
    )
  }
    println("this is stupid")
  }
}
