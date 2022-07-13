package tables
// AUTO-GENERATED Slick data model for table Reportquestion
trait ReportquestionTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Reportquestion
   *  @param reportquestionid Database column reportQuestionId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param reportid Database column reportId SqlType(BIGINT)
   *  @param questionid Database column questionId SqlType(BIGINT)
   *  @param importance Database column importance SqlType(INT)
   *  @param selectedanswer1 Database column selectedAnswer1 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer2 Database column selectedAnswer2 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer3 Database column selectedAnswer3 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer4 Database column selectedAnswer4 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer5 Database column selectedAnswer5 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer6 Database column selectedAnswer6 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer7 Database column selectedAnswer7 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer8 Database column selectedAnswer8 SqlType(SMALLINT), Default(None)
   *  @param selectedanswer9 Database column selectedAnswer9 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer1 Database column fineWithAnswer1 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer2 Database column fineWithAnswer2 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer3 Database column fineWithAnswer3 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer4 Database column fineWithAnswer4 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer5 Database column fineWithAnswer5 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer6 Database column fineWithAnswer6 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer7 Database column fineWithAnswer7 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer8 Database column fineWithAnswer8 SqlType(SMALLINT), Default(None)
   *  @param finewithanswer9 Database column fineWithAnswer9 SqlType(SMALLINT), Default(None)
   *  @param explaintext Database column explainText SqlType(VARCHAR), Length(5000,true), Default(Some(NULL)) */
  case class ReportquestionRow(reportquestionid: Long, reportid: Long, questionid: Long, importance: Int, selectedanswer1: Option[Int] = None, selectedanswer2: Option[Int] = None, selectedanswer3: Option[Int] = None, selectedanswer4: Option[Int] = None, selectedanswer5: Option[Int] = None, selectedanswer6: Option[Int] = None, selectedanswer7: Option[Int] = None, selectedanswer8: Option[Int] = None, selectedanswer9: Option[Int] = None, finewithanswer1: Option[Int] = None, finewithanswer2: Option[Int] = None, finewithanswer3: Option[Int] = None, finewithanswer4: Option[Int] = None, finewithanswer5: Option[Int] = None, finewithanswer6: Option[Int] = None, finewithanswer7: Option[Int] = None, finewithanswer8: Option[Int] = None, finewithanswer9: Option[Int] = None, explaintext: Option[String] = Some("NULL"))
  /** GetResult implicit for fetching ReportquestionRow objects using plain SQL queries */
  implicit def GetResultReportquestionRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]]): GR[ReportquestionRow] = GR{
    prs => import prs._
    ReportquestionRow(<<[Long], <<[Long], <<[Long], <<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String])
  }
  /** Table description of table reportquestion. Objects of this class serve as prototypes for rows in queries. */
  class Reportquestion(_tableTag: Tag) extends profile.api.Table[ReportquestionRow](_tableTag, Some("achamoth"), "reportquestion") {
    def * = (reportquestionid :: reportid :: questionid :: importance :: selectedanswer1 :: selectedanswer2 :: selectedanswer3 :: selectedanswer4 :: selectedanswer5 :: selectedanswer6 :: selectedanswer7 :: selectedanswer8 :: selectedanswer9 :: finewithanswer1 :: finewithanswer2 :: finewithanswer3 :: finewithanswer4 :: finewithanswer5 :: finewithanswer6 :: finewithanswer7 :: finewithanswer8 :: finewithanswer9 :: explaintext :: HNil).mapTo[ReportquestionRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(reportquestionid) :: Rep.Some(reportid) :: Rep.Some(questionid) :: Rep.Some(importance) :: selectedanswer1 :: selectedanswer2 :: selectedanswer3 :: selectedanswer4 :: selectedanswer5 :: selectedanswer6 :: selectedanswer7 :: selectedanswer8 :: selectedanswer9 :: finewithanswer1 :: finewithanswer2 :: finewithanswer3 :: finewithanswer4 :: finewithanswer5 :: finewithanswer6 :: finewithanswer7 :: finewithanswer8 :: finewithanswer9 :: explaintext :: HNil).shaped.<>(r => ReportquestionRow(r(0).asInstanceOf[Option[Long]].get, r(1).asInstanceOf[Option[Long]].get, r(2).asInstanceOf[Option[Long]].get, r(3).asInstanceOf[Option[Int]].get, r(4).asInstanceOf[Option[Int]], r(5).asInstanceOf[Option[Int]], r(6).asInstanceOf[Option[Int]], r(7).asInstanceOf[Option[Int]], r(8).asInstanceOf[Option[Int]], r(9).asInstanceOf[Option[Int]], r(10).asInstanceOf[Option[Int]], r(11).asInstanceOf[Option[Int]], r(12).asInstanceOf[Option[Int]], r(13).asInstanceOf[Option[Int]], r(14).asInstanceOf[Option[Int]], r(15).asInstanceOf[Option[Int]], r(16).asInstanceOf[Option[Int]], r(17).asInstanceOf[Option[Int]], r(18).asInstanceOf[Option[Int]], r(19).asInstanceOf[Option[Int]], r(20).asInstanceOf[Option[Int]], r(21).asInstanceOf[Option[Int]], r(22).asInstanceOf[Option[String]]), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column reportQuestionId SqlType(BIGINT), AutoInc, PrimaryKey */
    val reportquestionid: Rep[Long] = column[Long]("reportQuestionId", O.AutoInc, O.PrimaryKey)
    /** Database column reportId SqlType(BIGINT) */
    val reportid: Rep[Long] = column[Long]("reportId")
    /** Database column questionId SqlType(BIGINT) */
    val questionid: Rep[Long] = column[Long]("questionId")
    /** Database column importance SqlType(INT) */
    val importance: Rep[Int] = column[Int]("importance")
    /** Database column selectedAnswer1 SqlType(SMALLINT), Default(None) */
    val selectedanswer1: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer1", O.Default(None))
    /** Database column selectedAnswer2 SqlType(SMALLINT), Default(None) */
    val selectedanswer2: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer2", O.Default(None))
    /** Database column selectedAnswer3 SqlType(SMALLINT), Default(None) */
    val selectedanswer3: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer3", O.Default(None))
    /** Database column selectedAnswer4 SqlType(SMALLINT), Default(None) */
    val selectedanswer4: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer4", O.Default(None))
    /** Database column selectedAnswer5 SqlType(SMALLINT), Default(None) */
    val selectedanswer5: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer5", O.Default(None))
    /** Database column selectedAnswer6 SqlType(SMALLINT), Default(None) */
    val selectedanswer6: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer6", O.Default(None))
    /** Database column selectedAnswer7 SqlType(SMALLINT), Default(None) */
    val selectedanswer7: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer7", O.Default(None))
    /** Database column selectedAnswer8 SqlType(SMALLINT), Default(None) */
    val selectedanswer8: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer8", O.Default(None))
    /** Database column selectedAnswer9 SqlType(SMALLINT), Default(None) */
    val selectedanswer9: Rep[Option[Int]] = column[Option[Int]]("selectedAnswer9", O.Default(None))
    /** Database column fineWithAnswer1 SqlType(SMALLINT), Default(None) */
    val finewithanswer1: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer1", O.Default(None))
    /** Database column fineWithAnswer2 SqlType(SMALLINT), Default(None) */
    val finewithanswer2: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer2", O.Default(None))
    /** Database column fineWithAnswer3 SqlType(SMALLINT), Default(None) */
    val finewithanswer3: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer3", O.Default(None))
    /** Database column fineWithAnswer4 SqlType(SMALLINT), Default(None) */
    val finewithanswer4: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer4", O.Default(None))
    /** Database column fineWithAnswer5 SqlType(SMALLINT), Default(None) */
    val finewithanswer5: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer5", O.Default(None))
    /** Database column fineWithAnswer6 SqlType(SMALLINT), Default(None) */
    val finewithanswer6: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer6", O.Default(None))
    /** Database column fineWithAnswer7 SqlType(SMALLINT), Default(None) */
    val finewithanswer7: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer7", O.Default(None))
    /** Database column fineWithAnswer8 SqlType(SMALLINT), Default(None) */
    val finewithanswer8: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer8", O.Default(None))
    /** Database column fineWithAnswer9 SqlType(SMALLINT), Default(None) */
    val finewithanswer9: Rep[Option[Int]] = column[Option[Int]]("fineWithAnswer9", O.Default(None))
    /** Database column explainText SqlType(VARCHAR), Length(5000,true), Default(Some(NULL)) */
    val explaintext: Rep[Option[String]] = column[Option[String]]("explainText", O.Length(5000,varying=true), O.Default(Some("NULL")))

    /** Foreign key referencing Question (database name fk_reportquestion_question) */
    lazy val questionFk = foreignKey("fk_reportquestion_question", questionid :: HNil, Question)(r => r.questionid :: HNil, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Report (database name fk_reportquestion_report) */
    lazy val reportFk = foreignKey("fk_reportquestion_report", reportid :: HNil, Report)(r => r.reportid :: HNil, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table Reportquestion */
  lazy val Reportquestion = new TableQuery(tag => new Reportquestion(tag))
}
