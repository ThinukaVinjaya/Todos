package com.thinuka.todos.controller;

import com.thinuka.todos.entity.Todo;
import com.thinuka.todos.request.TodoRequest;
import com.thinuka.todos.response.TodoResponse;
import com.thinuka.todos.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Todo REST API Endpoints", description = "Operation for managing user todos")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @Operation(summary = "Gel all todos for user", description = "Fetch all todo from singned in user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TodoResponse> getAllTodos(){
        return todoService.getAllTodos();
    }

    @Operation(summary = "Create todo for user", description = "Create todo for the signed in user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TodoResponse createTodo(@Valid @RequestBody TodoRequest todoRequest){
        return todoService.createTodo(todoRequest);
    }

    @Operation(summary = "Update todo for user", description = "Update todo for the singned in user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TodoResponse toggleTodoCompletion(@PathVariable @Min(1) long id){
        return todoService.toggleTodoCompletion(id);
    }

    @Operation(summary = "Delete todo for user", description = "Delete todo for the singned in user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable @Min(1) long id){
        todoService.deleteTodo(id);
    }
}
