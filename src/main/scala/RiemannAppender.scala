import ch.qos.logback.core.UnsynchronizedAppenderBase
import io.riemann.riemann.client.RiemannClient


class RiemannAppender[E] extends UnsynchronizedAppenderBase[E] {

  val rc = RiemannClient.tcp("192.168.0.15", 5555)
    rc.connect()

  override def append(eventObject: E): Unit = {
    println("have to make riemann connection from here")
    println(eventObject.toString)


    (1 to 5000).foreach(i =>
      rc.event().service("Logback-service").state(s"just-started- $i").tags("running", "willrun", s"${i}").send().deref()
    )

  }
}
