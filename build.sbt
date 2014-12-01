name := "AkkaPersistencePlugin4RocksDB"

version := "1.0"

scalaVersion := "2.10.4"

fork in Test := true

fork in run := true

test in assembly := {}

libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-persistence-experimental" % "2.3.6" % "compile",
"com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
"com.typesafe.akka" %% "akka-persistence-tck-experimental" % "2.3.6" % "test",
"org.rocksdb" % "rocksdbjni" % "3.6.2" % "compile,test"
 )

 resolvers ++= Seq(
 	"Akka Repository" at "http://repo.akka.io/releases/",
		"Thrift" at "http://people.apache.org/~rawson/repo/",
			"Apache HBase" at "https://repository.apache.org/content/repositories/releases",
				"Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/" )

