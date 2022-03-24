package com.trainservice.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainID;
	private String trainName;
	private String trainModel;
	private String trainSpeed;
	
	public Integer getTrainID() {
		return trainID;
	}
	public void setTrainID(Integer trainID) {
		this.trainID = trainID;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainModel() {
		return trainModel;
	}
	public void setTrainModel(String trainModel) {
		this.trainModel = trainModel;
	}
	public String getTrainSpeed() {
		return trainSpeed;
	}
	public void setTrainSpeed(String trainSpeed) {
		this.trainSpeed = trainSpeed;
	}
}
