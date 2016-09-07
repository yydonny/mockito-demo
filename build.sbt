name := "mockito-demo"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-freemarker" % "1.3.3.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-jdbc" % "1.3.3.RELEASE"

libraryDependencies += "org.mockito" % "mockito-core" % "1.10.19" % "test"
libraryDependencies += "org.powermock" % "powermock-api-easymock" % "1.6.5" % "test"
libraryDependencies += "org.powermock" % "powermock-api-mockito" % "1.6.5" % "test"
libraryDependencies += "org.powermock" % "powermock-module-junit4" % "1.6.5" % "test"
libraryDependencies += "org.easymock" % "easymock" % "3.4" % "test"
