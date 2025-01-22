package co.HMSDev.todo.todo_api.service;

import co.HMSDev.todo.todo_api.model.Task;
import co.HMSDev.todo.todo_api.model.User;
import co.HMSDev.todo.todo_api.repository.TaskRepository;
import co.HMSDev.todo.todo_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(long userId, Task task){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId){
        return taskRepository.findByUserId(userId);
    }

    public Task completeTask(Long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("User Not Found"));
        task.setCompleted(true);
        taskRepository.save(task);

        //Award points to the user
        User user = task.getUser();
        user.setPoints((user.getPoints()+10));
        userRepository.save(user);

        return task;
    }
}
