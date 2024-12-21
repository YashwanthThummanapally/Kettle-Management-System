package com.edubridge.kettle.service;

import java.util.List;

import com.edubridge.kettle.dao.KettleDao;
import com.edubridge.kettle.dao.KettleDaoI;
import com.edubridge.kettle.dto.Kettle;

public class KettleService implements KettleServiceI {
	
	private KettleDaoI dao = new KettleDao();

	@Override
	public int addKettle(Kettle kettle) {
		return dao.addKettle(kettle);
	}

	@Override
	public List<Kettle> retrieveKettle() {
		return dao.retrieveKettle();
	}

	@Override
	public Kettle retrieveKettle(int id) {
		return dao.retrieveKettle(id);
	}

	@Override
	public int updateKettle(float capacity, double price, int id) {
		return dao.updateKettle(capacity, price, id);
	}

	@Override
	public int deleteKettle(int id) {
		return dao.deleteKettle(id);
	}
}
