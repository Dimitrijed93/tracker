package com.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "tbltracks")
@Entity
public class Tracks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="track name")
	private String trackName;
	@Column(name="file format")
	private String fileFormat;
	@Column(name="duration")
	private String duration;
	
	
	public Tracks(int id, String trackName, String fileFormat, String duration) {

		this.id = id;
		this.trackName = trackName;
		this.fileFormat = fileFormat;
		this.duration = duration;	
	}
	
	public Tracks() {
		
	}

	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	
	
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
