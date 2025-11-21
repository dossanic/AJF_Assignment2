package ca.sheridancollege.dossanic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.dossanic.domain.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
	
	public Optional<Feed> findByTitle(String title);
	
	public List<Feed> findAllByOrderByDateDescTimeDesc();
}
