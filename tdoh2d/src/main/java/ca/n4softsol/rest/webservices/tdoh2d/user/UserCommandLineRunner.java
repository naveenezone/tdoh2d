package ca.n4softsol.rest.webservices.tdoh2d.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	@Autowired
	private UserDAOService userDAOService;

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		long insert = userDAOService.insert(user);
		log.info("New User is created : " + user);
	}

}
