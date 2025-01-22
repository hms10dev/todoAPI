package co.HMSDev.todo.todo_api.controller;

import co.HMSDev.todo.todo_api.model.Task;
import co.HMSDev.todo.todo_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService){

        this.taskService = taskService;
    }

    @PostMapping("/users/{userId}")
    public Task createTask(@PathVariable Long userId, @RequestBody Task task){
        return taskService.createTask(userId,task);
    }

    @GetMapping("/users/{userId}")
    public List<Task> getTasks(@PathVariable Long userId){
        return taskService.getTasksByUser(userId);
    }

    @PutMapping("/{taskId}/complete")
    public Task completeTask(@PathVariable Long taskId){
        return taskService.completeTask(taskId);
    }

    //need to add a endpoint for editing tasks


}
