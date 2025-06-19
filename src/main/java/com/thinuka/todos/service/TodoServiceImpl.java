package com.thinuka.todos.service;

import com.thinuka.todos.entity.Todo;
import com.thinuka.todos.entity.User;
import com.thinuka.todos.repository.TodoRepository;
import com.thinuka.todos.request.TodoRequest;
import com.thinuka.todos.response.TodoResponse;
import com.thinuka.todos.util.FindAuthenticatedUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    private final FindAuthenticatedUser findAuthenticatedUser;

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
       );


        Todo savedTodo = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.getPriority(),
                savedTodo.isComplete()

        );

        return null;
    }
}
