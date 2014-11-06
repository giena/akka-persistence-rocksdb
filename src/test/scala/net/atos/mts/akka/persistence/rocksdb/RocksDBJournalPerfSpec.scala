import akka.persistence.journal.JournalSpec
import akka.persistence.journal.JournalPerfSpec
import com.typesafe.config.ConfigFactory

class RocksDBJournalPerfSpec extends JournalSpec with JournalPerfSpec {
  lazy val config = ConfigFactory.load("application.conf")
}