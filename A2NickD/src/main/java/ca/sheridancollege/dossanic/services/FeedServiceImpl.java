package ca.sheridancollege.dossanic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.dossanic.domain.Feed;
import ca.sheridancollege.dossanic.repositories.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService {
	@Autowired
	private FeedRepository fr;
	
	@Override
	public List<Feed> findAll(){
		return fr.findAll();
	}
	
	@Override
	public Optional<Feed> findById(Long id){
		return fr.findById(id);
	}
	
	@Override
	public Optional<Feed> findByTitle(String title){
		return fr.findByTitle(title);
	}
	
	@Override
	public Feed save(Feed feed) {
		return fr.save(feed);
	}	
}
