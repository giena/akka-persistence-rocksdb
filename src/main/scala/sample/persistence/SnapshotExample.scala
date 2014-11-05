package sample.persistence

import akka.actor._
import akka.persistence._

object SnapshotExample extends App {
  case class ExampleState(received: List[String] = Nil) {
    def updated(s: String): ExampleState = copy(s :: received)
    override def toString = received.reverse.toString
  }

  class ExamplePersistentActor extends PersistentActor {
    def persistenceId: String = "sample-id-3"

    var state = ExampleState()

    def receiveCommand: Actor.Receive = {
      case "print"                               => println("current state = " + state)
      case "snap"                                => saveSnapshot(state)
      case SaveSnapshotSuccess(metadata)         => // ...
      case SaveSnapshotFailure(metadata, reason) => // ...
      case s: String =>
        persist(s) { evt => state = state.updated(evt) }
    }

    def receiveRecover: Actor.Receive = {
      case SnapshotOffer(_, s: ExampleState) =>
        println("offered state = " + s)
        state = s
      case evt: String =>
        println("recover = " + evt)
        state = state.updated(evt)
    }

  }

  val system = ActorSystem("example")
  val persistentActor = system.actorOf(Props(classOf[ExamplePersistentActor]), "persistentActor-3-scala")
  val timestamp = System.currentTimeMillis()
  
  persistentActor ! "a"+timestamp
  persistentActor ! "b"+timestamp
  persistentActor ! "snap"
  persistentActor ! "c"+timestamp
  persistentActor ! "d"+timestamp
  persistentActor ! "print"

  Thread.sleep(1000)
  system.shutdown()
}