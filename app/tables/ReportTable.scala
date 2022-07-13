package tables
// AUTO-GENERATED Slick data model for table Report
trait ReportTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Report
   *  @param reportid Database column reportId SqlType(BIGINT), PrimaryKey
   *  @param externalid Database column externalId SqlType(BIGINT)
   *  @param modified Database column modified SqlType(TIMESTAMP) */
  case class ReportRow(reportid: Long, externalid: Long, modified: java.sql.Timestamp)
  /** GetResult implicit for fetching ReportRow objects using plain SQL queries */
  implicit def GetResultReportRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[ReportRow] = GR{
    prs => import prs._
    ReportRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table report. Objects of this class serve as prototypes for rows in queries. */
  class Report(_tableTag: Tag) extends profile.api.Table[ReportRow](_tableTag, Some("achamoth"), "report") {
    def * = (reportid, externalid, modified) <> (ReportRow.tupled, ReportRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(reportid), Rep.Some(externalid), Rep.Some(modified))).shaped.<>({r=>import r._; _1.map(_=> ReportRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column reportId SqlType(BIGINT), PrimaryKey */
    val reportid: Rep[Long] = column[Long]("reportId", O.PrimaryKey)
    /** Database column externalId SqlType(BIGINT) */
    val externalid: Rep[Long] = column[Long]("externalId")
    /** Database column modified SqlType(TIMESTAMP) */
    val modified: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modified")
  }
  /** Collection-like TableQuery object for table Report */
  lazy val Report = new TableQuery(tag => new Report(tag))
}
