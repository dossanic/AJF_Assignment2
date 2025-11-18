package ca.sheridancollege.dossanic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.dossanic.domain.Feed;

@Service
public interface FeedService {
	
	public List<Feed> findAll();

	public Optional<Feed> findById(Long id);

	public Optional<Feed> findByTitle(String title);

	public Feed save(Feed feed);
}
