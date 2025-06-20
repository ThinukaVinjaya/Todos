package com.thinuka.todos.service;

import com.thinuka.todos.request.TodoRequest;
import com.thinuka.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {

    List<TodoResponse> getAllTodos();

    TodoResponse createTodo(TodoRequest todoRequest);
    TodoResponse toggleTodoCompletion(long id);
    TodoResponse deleteTodo(long id);
}
