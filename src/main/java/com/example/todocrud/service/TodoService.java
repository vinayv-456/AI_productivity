package com.example.todocrud.service;

import com.example.todocrud.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    private final Map<Long, Todo> todos = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Todo findById(Long id) {
        return todos.get(id);
    }

    public Todo create(Todo todo) {
        long id = idGenerator.getAndIncrement();
        Todo newTodo = new Todo(id, todo.getTitle(), todo.getDescription(), todo.isCompleted());
        System.out.println("id" + id);
        todos.put(id, newTodo);
        return newTodo;
    }

    public Todo update(Long id, Todo updatedTodo) {
        Todo existing = todos.get(id);
        if (existing == null) {
            return null;
        }

        existing.setTitle(updatedTodo.getTitle());
        existing.setDescription(updatedTodo.getDescription());
        existing.setCompleted(updatedTodo.isCompleted());
        return existing;
    }

    public boolean delete(Long id) {
        return todos.remove(id) != null;
    }
}
