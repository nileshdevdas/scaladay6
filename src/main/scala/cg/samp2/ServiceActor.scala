package cg.samp2
import akka.actor.Actor
import spray.http.MediaType
import spray.routing.HttpService

class ServiceActor extends Actor with HttpService{
  def actorRefFactory = context
  def receive = runRoute(simpleRoute)
  // processed data that i will process with my sparkcontext :---
  val simpleRoute= {
    path("hello") {
      get {
        respondWithMediaType(MediaType.custom("application/json")) {
          complete {
           val result  = "{\"status\" : \"success\"}"
            result;
          }
        }
      }
    }
  }
//  val simpleRoute3= {
//    path("hello3") {
//      get {
//        respondWithMediaType(MediaType.custom("text/plain")) {
//          complete {
//            val result  = "{\"status\" : \"hello3\"}"
//            result;
//          }
//        }
//      }
//    }
//  }
//
//  val simpleRoute1= {
//    path("hello1") {
//      get {
//        respondWithMediaType(MediaType.custom("text/plain")) {
//          complete {
//            val result  = "{\"status\" : \"hello1\"}"
//            result;
//          }
//        }
//      }
//    }
//  }
}
