package com.edubridge.kettle.service;

import java.util.List;

import com.edubridge.kettle.dto.Kettle;

public interface KettleServiceI {
	int addKettle(Kettle kettle);
	List<Kettle> retrieveKettle();
	Kettle retrieveKettle(int id);
	int updateKettle(float capacity, double price, int id);
	int deleteKettle(int id);
}
