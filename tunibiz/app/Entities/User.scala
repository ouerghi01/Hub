package Entities 
import slick.jdbc.PostgresProfile.api._
case class  User(id:Long, email:String, password:String)
class  Users (tag:Tag) extends Table[User](tag, "users") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def email = column[String]("email")
  def password = column[String]("password")
  def * = (id, email, password) <> (User.tupled, User.unapply)
}
