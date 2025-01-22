package co.HMSDev.todo.todo_api.repository;

import co.HMSDev.todo.todo_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserId(Long userId);
}
