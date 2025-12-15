package ca.sheridancollege.dossanic.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.dossanic.domain.Feed;
import ca.sheridancollege.dossanic.services.FeedService;

@RestController
@RequestMapping("/api/v1/feed")
public class FeedController {
	@Autowired
	private FeedService fs;

	@GetMapping(value = { "", "/" })
	public List<Feed> getFeedCollection() {
		return fs.findAll();
	}

	@PostMapping(value = { "", "/" })
	public Feed save(@RequestBody Feed feed) {
		return fs.save(feed);
	}
	
	@DeleteMapping(value = "{id}")
	public void deletePost(@PathVariable Long id) {
		fs.delete(id);
	}
	
	@PutMapping("/{id}")
	public Feed updatePost(@PathVariable Long id, @RequestBody Feed feed) {
		feed.setId(id);
		return fs.save(feed);
	}
}
