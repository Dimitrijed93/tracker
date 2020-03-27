package com.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.model.Tracks;


public interface TracksDao extends JpaRepository<Tracks, Integer>{
		
	}

