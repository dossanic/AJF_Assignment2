package ca.sheridancollege.dossanic.bootstrap;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.dossanic.domain.Feed;
import ca.sheridancollege.dossanic.services.FeedService;

@Component
public class FeedBootstrap implements CommandLineRunner {

	@Autowired
	private FeedService fs;
	
	@Override
	public void run(String... args) throws Exception {
		
		Feed f1 = new Feed(
				"Alice Smith", 
				"Article",
				"Shared a great article on microservices architecture. <link>", 
				LocalTime.of(10, 30), // 10:30 AM
				LocalDate.of(2025, 11, 15) // November 15, 2025
			);
		Feed f2 = new Feed(
				"Bob Johnson", 
				"Spring Security Question",
				"Asked a question about Spring Security configuration.", 
				LocalTime.of(14, 0), // 2:00 PM
				LocalDate.now() // Today's date
			);
		Feed f3 = new Feed(
				"Charlie Brown",
				"CSS Tutorial Link",
				"Posted a link to a new CSS framework tutorial. <link>", 
				LocalTime.of(19, 45), // 7:45 PM
				LocalDate.of(2025, 11, 14) // November 14, 2025
			);
		
		fs.save(f1);
		fs.save(f2);
		fs.save(f3);
	}

}
