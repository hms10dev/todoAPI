package co.HMSDev.todo.todo_api.repository;

import co.HMSDev.todo.todo_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
