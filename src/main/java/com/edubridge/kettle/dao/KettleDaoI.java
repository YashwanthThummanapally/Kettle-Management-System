package com.edubridge.kettle.dao;

import java.util.List;

import com.edubridge.kettle.dto.Kettle;

public interface KettleDaoI {
	int addKettle(Kettle kettle);
	List<Kettle> retrieveKettle();
	Kettle retrieveKettle(int kettleId);
	int updateKettle(float capacity, double price, int kettleId);
	int deleteKettle(int kettleId);
}
