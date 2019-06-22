package cg.samp2
import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

object Service {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("sparkrest");
    val service = system.actorOf(Props[ServiceActor], "rest-service")
    implicit val timeout = Timeout(10.seconds)
    IO(Http) ? Http.Bind(service, interface = "localhost", port = 8888);
  }
}
