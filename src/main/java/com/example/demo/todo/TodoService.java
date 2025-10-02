package com.example.demo.todo;

import com.example.demo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoDto create(TodoDto dto) {
        Todo todo = Todo.builder()
                .title(dto.getTitle())
                .completed(dto.getCompleted())
                .build();

        Todo savedTodo = todoRepository.save(todo);

        return TodoDto.builder()
                .id(savedTodo.getId())
                .title(savedTodo.getTitle())
                .completed(savedTodo.getCompleted())
                .build();
    }

    public List<TodoDto> getAll() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> TodoDto.builder()
                        .id(todo.getId())
                        .title(todo.getTitle())
                        .completed(todo.getCompleted())
                        .build())
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new IllegalArgumentException("Todo with id " + id + " not found");
        }
        todoRepository.deleteById(id);
    }

    public TodoDto update(long id, TodoDto dto) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo with id " + id + " not found"));

        Todo updatedTodo = Todo.builder()
                .id(existingTodo.getId())
                .title(dto.getTitle())
                .completed(dto.getCompleted())
                .build();

        Todo savedTodo = todoRepository.save(updatedTodo);

        return TodoDto.builder()
                .id(savedTodo.getId())
                .title(savedTodo.getTitle())
                .completed(savedTodo.getCompleted())
                .build();
    }
}
