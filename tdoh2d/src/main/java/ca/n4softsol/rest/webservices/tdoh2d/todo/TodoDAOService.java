package ca.n4softsol.rest.webservices.tdoh2d.todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TodoDAOService {

	@PersistenceContext
	private EntityManager entityManager;

	public long insert(Todo todo) {
		entityManager.persist(todo);
		return todo.getId();
	}

}
