package ca.n4softsol.rest.webservices.tdoh2d.todo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TodoResource {

	@Autowired
	private TodoRepository todoRepository;

	private static List<Todo> Todos = new ArrayList<>();

	// Retrieve all Todo for a user
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoRepository.findByUsername(username);
	}

	// GET /users/{username}/todos/{id}
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getAllTodos(@PathVariable String username, @PathVariable long id) {
		return todoRepository.findById(id).get();
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	// PUT /users/{username}/todos/{id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoRepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

	// POST /users/{username}/todos
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo todoCreated = todoRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
