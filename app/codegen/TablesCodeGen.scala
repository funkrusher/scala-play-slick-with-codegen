package codegen

import play.db.Database
import slick.codegen.SourceCodeGenerator

import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.PostgresDriver
import slick.jdbc.meta.MTable
import slick.codegen.SourceCodeGenerator
import slick.jdbc.MySQLProfile

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object TablesCodeGen extends App {
  val slickDriver = "slick.jdbc.MySQLProfile"
  val jdbcDriver = "org.mariadb.jdbc.Driver"
  val url = "jdbc:mariadb://localhost:3306/mydb"
  val outputDir = "./app"
  val username = "root"
  val password = ""

  val db = slick.jdbc.MySQLProfile.api.Database.forURL(url, username, password, driver=jdbcDriver)
  val dbio = MySQLProfile.createModel(Some(MTable.getTables(None, None, None, Some(Seq("TABLE", "VIEW")))))
  val model = db.run(dbio)
  val future : Future[SourceCodeGenerator] = model.map(model => new SourceCodeGenerator(model))
  val codegen : SourceCodeGenerator = Await.result(future, Duration.create(5, TimeUnit.MINUTES))

  codegen.writeToMultipleFiles(profile = slickDriver, folder = outputDir, pkg ="tables", container ="Tables")

}