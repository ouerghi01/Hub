package controllers

import javax.inject._
import play.api.mvc._
import repositories.UserRepository
import models.User
import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()(cc: ControllerComponents, userRepository: UserRepository) extends AbstractController(cc) {

    def create() = Action.async { implicit request =>
        val user = User(0,  "john.doe@example.com","123")
        userRepository.create(user).map { id =>
            Created(s"User created with id: $id")
        }
    }

    def list() = Action.async {
        userRepository.list().map { users =>
            Ok(users.toString())
        }
    }

    def find(id: Long) = Action.async {
        userRepository.findById(id).map {
            case Some(user) => Ok(user.toString)
            case None => NotFound("User not found")
        }
    }

    def update(id: Long) = Action.async { implicit request =>
        val user = User(id, "Jane Doe", "jane.doe@example.com")
        userRepository.update(user).map { _ =>
            Ok(s"User with id: $id updated")
        }
    }

    def delete(id: Long) = Action.async {
        userRepository.delete(id).map { _ =>
            Ok(s"User with id: $id deleted")
        }
    }
}