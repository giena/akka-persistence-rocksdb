

import com.typesafe.config.ConfigFactory
import akka.persistence.journal.JournalSpec

class RocksDBSyncWriteJournalSpec extends JournalSpec {
  /*override val config = ConfigFactory.parseString(
    """
      |akka.persistence.journal.plugin = "akka.persistence.journal.rocksdb"
    """.stripMargin)*/
  lazy val config = ConfigFactory.load("application.conf")
}