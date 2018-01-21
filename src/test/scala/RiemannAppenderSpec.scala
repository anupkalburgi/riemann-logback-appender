import ch.qos.logback.classic.spi.LoggingEvent
import org.scalatest.{FlatSpec, FreeSpec, Matchers}
import ch.qos.logback.classic.{Level, LoggerContext}

class RiemannAppenderSpec extends FreeSpec with Matchers {
  val sut = new RiemannAppender[LoggingEvent]
  val ctx = new LoggerContext

  "should print something" in {
    val evt: LoggingEvent = new LoggingEvent("fqcn", ctx.getLogger("logger"), Level.ALL, "message", null, new Array[AnyRef](0))
    sut.append(evt)
    true
  }

}
