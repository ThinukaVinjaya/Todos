package com.thinuka.todos.service;

import com.thinuka.todos.request.TodoRequest;
import com.thinuka.todos.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
}
