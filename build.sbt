name := "Akka Persistence Plugin for RocksDB"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-persistence-experimental" % "2.3.4" % "compile",
"com.typesafe.akka" %% "akka-testkit" % "2.3.4" % "test",
"org.rocksdb" % "rocksdbjni" % "3.5.0"
 )

 resolvers ++= Seq(
 	"Akka Repository" at "http://repo.akka.io/releases/",
		"Thrift" at "http://people.apache.org/~rawson/repo/",
			"Apache HBase" at "https://repository.apache.org/content/repositories/releases",
				"Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/" )

