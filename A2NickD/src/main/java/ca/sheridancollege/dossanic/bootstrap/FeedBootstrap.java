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
				"Product Team - Ringo Starr", 
				"Q3 Project Fusion Deployed!",
				"The backend team successfully moved all legacy services to Kubernetes on time! Zero downtime migration. See Slack channel #fusion-success for details."
				);
		f1.setTime(LocalTime.of(10, 30));
		f1.setDate(LocalDate.of(2025, 11, 15));

		
		Feed f2 = new Feed(
				"R&D Department - Paul McCartney", 
				"AI Ethics Workshop Recap",
				"We're hosting a follow-up session next week to discuss ethical guidelines for our new generative AI model. Check your calendar invite. Highly encouraged attendance for all developers."
				);
		f2.setTime(LocalTime.of(1, 30));
		f2.setDate(LocalDate.of(2025, 10, 31));


		Feed f3 = new Feed(
				"Dev Ops Lead - Scooby Doo",
				"New CI/CD Pipeline Docs Available",
				"We've implemented a new security scanning stage in our pipeline. All project teams need to update their YAML files by end of the week. Full documentation is attached to this post. <link>"
				);
		f3.setTime(LocalTime.of(19, 45));
		f3.setDate(LocalDate.of(2025, 11, 14));

		
		fs.save(f1);
		fs.save(f2);
		fs.save(f3);
	}

}
