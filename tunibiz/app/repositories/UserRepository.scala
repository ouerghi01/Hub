package repositories
import Entities.{Users, User}
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{ExecutionContext, Future}
class  UserRepository (db:Database) (implicit  ec :ExecutionContext){
  private val users = TableQuery[Users]

  def create(user: User): Future[Long] = {
    db.run((users returning users.map(_.id)) += user)
  }

  def list(): Future[Seq[User]] = {
    db.run(users.result)
  }

  def findById(id: Long): Future[Option[User]] = {
    db.run(users.filter(_.id === id).result.headOption)
  }

  def update(user: User): Future[Int] = {
    db.run(users.filter(_.id === user.id).update(user))
  }

  def delete(id: Long): Future[Int] = {
    db.run(users.filter(_.id === id).delete)
  }
}