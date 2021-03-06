package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tracker.dao.GenresDao;
import com.tracker.model.Genres;

@Service
@Transactional
public class GenresServiceImpl implements GenresService {

	@Autowired
	public GenresDao genresDao;
	
	
	public List<Genres> listAll() {
		List<Genres> genres = new ArrayList <Genres>();
		for(Genres genre : genresDao.findAll()) {
		genres.add(genre);
	}
		return genres;
	}

	public Genres save(Genres genres) {
		return genresDao.save(genres);
	}

	
	public Genres update(int id, Genres genres) {
		return genresDao.getOne(id);
	}

	
	public void delete(int id) {
		genresDao.deleteById(id);
		
	}

	
	public Genres get(Integer id) {
		return genresDao.getOne(id);
	}


}
