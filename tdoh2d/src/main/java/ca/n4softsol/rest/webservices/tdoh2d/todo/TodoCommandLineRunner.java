package ca.n4softsol.rest.webservices.tdoh2d.todo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TodoCommandLineRunner.class);

	@Autowired
	private TodoDAOService todoDAOService;

	@Override
	public void run(String... args) throws Exception {
		Todo todo1 = new Todo("sam", "Learn JPA", "DESC-Learn JPA", new Date(), false);
		Todo todo2 = new Todo("sam", "Learn MYSQL", "DESC-Learn MYSQL", new Date(), false);
		Todo todo3 = new Todo("sam", "Learn Microservices", "DESC-Learn Microservices", new Date(), false);
		long insert1 = todoDAOService.insert(todo1);
		long insert2 = todoDAOService.insert(todo2);
		long insert3 = todoDAOService.insert(todo3);
		log.info("New Todo is created : " + todo1);
		log.info("New Todo is created : " + todo2);
		log.info("New Todo is created : " + todo3);

	}

}
