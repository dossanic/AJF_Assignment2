package ca.sheridancollege.dossanic.services;

import java.time.LocalDate;
import java.time.LocalTime;
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
		return fr.findAllByOrderByDateDescTimeDesc();
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
	public void delete(Long id) {
		fr.deleteById(id);
	}
	
	@Override
	public Feed save(Feed feed) {
		if (feed.getId() == null) {
			
			if(feed.getDate() == null) {
				feed.setDate(LocalDate.now());
			}
			if(feed.getTime() == null) {
				feed.setTime(LocalTime.now());	
			}
		}
		
		return fr.save(feed);
	}	
}
