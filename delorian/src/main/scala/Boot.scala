package com.haile.app

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import com.typesafe.scalalogging.Logger



object Boot {
  def main(args: Array[String]): Unit = {

    implicit val system           = ActorSystem(Behaviors.empty, "my-system")
    // are important for using flatMap onComplete at the end
    implicit val executionContext = system.executionContext

    val log = Logger("Boot")

    val route =
      path("date") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, java.time.LocalDate.now.toString))
        }
     }

    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(route)

    log.info("done")
  }
}
