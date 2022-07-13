package tables
// AUTO-GENERATED Slick data model for table Question
trait QuestionTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Question
   *  @param contentid Database column contentId SqlType(VARCHAR), PrimaryKey, Length(768,true)
   *  @param questionid Database column questionId SqlType(BIGINT), AutoInc
   *  @param language Database column language SqlType(CHAR), Length(2,false)
   *  @param createdat Database column createdAt SqlType(TIMESTAMP)
   *  @param question Database column question SqlType(VARCHAR), Length(500,true)
   *  @param answer1 Database column answer1 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer2 Database column answer2 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer3 Database column answer3 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer4 Database column answer4 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer5 Database column answer5 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer6 Database column answer6 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer7 Database column answer7 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer8 Database column answer8 SqlType(VARCHAR), Length(300,true), Default(Some(NULL))
   *  @param answer9 Database column answer9 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
  case class QuestionRow(contentid: String, questionid: Long, language: String, createdat: java.sql.Timestamp, question: String, answer1: Option[String] = Some("NULL"), answer2: Option[String] = Some("NULL"), answer3: Option[String] = Some("NULL"), answer4: Option[String] = Some("NULL"), answer5: Option[String] = Some("NULL"), answer6: Option[String] = Some("NULL"), answer7: Option[String] = Some("NULL"), answer8: Option[String] = Some("NULL"), answer9: Option[String] = Some("NULL"))
  /** GetResult implicit for fetching QuestionRow objects using plain SQL queries */
  implicit def GetResultQuestionRow(implicit e0: GR[String], e1: GR[Long], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[QuestionRow] = GR{
    prs => import prs._
    QuestionRow.tupled((<<[String], <<[Long], <<[String], <<[java.sql.Timestamp], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table question. Objects of this class serve as prototypes for rows in queries. */
  class Question(_tableTag: Tag) extends profile.api.Table[QuestionRow](_tableTag, Some("achamoth"), "question") {
    def * = (contentid, questionid, language, createdat, question, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9) <> (QuestionRow.tupled, QuestionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(contentid), Rep.Some(questionid), Rep.Some(language), Rep.Some(createdat), Rep.Some(question), answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9)).shaped.<>({r=>import r._; _1.map(_=> QuestionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column contentId SqlType(VARCHAR), PrimaryKey, Length(768,true) */
    val contentid: Rep[String] = column[String]("contentId", O.PrimaryKey, O.Length(768,varying=true))
    /** Database column questionId SqlType(BIGINT), AutoInc */
    val questionid: Rep[Long] = column[Long]("questionId", O.AutoInc)
    /** Database column language SqlType(CHAR), Length(2,false) */
    val language: Rep[String] = column[String]("language", O.Length(2,varying=false))
    /** Database column createdAt SqlType(TIMESTAMP) */
    val createdat: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createdAt")
    /** Database column question SqlType(VARCHAR), Length(500,true) */
    val question: Rep[String] = column[String]("question", O.Length(500,varying=true))
    /** Database column answer1 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer1: Rep[Option[String]] = column[Option[String]]("answer1", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer2 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer2: Rep[Option[String]] = column[Option[String]]("answer2", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer3 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer3: Rep[Option[String]] = column[Option[String]]("answer3", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer4 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer4: Rep[Option[String]] = column[Option[String]]("answer4", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer5 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer5: Rep[Option[String]] = column[Option[String]]("answer5", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer6 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer6: Rep[Option[String]] = column[Option[String]]("answer6", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer7 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer7: Rep[Option[String]] = column[Option[String]]("answer7", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer8 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer8: Rep[Option[String]] = column[Option[String]]("answer8", O.Length(300,varying=true), O.Default(Some("NULL")))
    /** Database column answer9 SqlType(VARCHAR), Length(300,true), Default(Some(NULL)) */
    val answer9: Rep[Option[String]] = column[Option[String]]("answer9", O.Length(300,varying=true), O.Default(Some("NULL")))

    /** Uniqueness Index over (questionid) (database name questionId) */
    val index1 = index("questionId", questionid, unique=true)
  }
  /** Collection-like TableQuery object for table Question */
  lazy val Question = new TableQuery(tag => new Question(tag))
}
