package com.trainservice.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainservice.java.entity.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer>{

}
