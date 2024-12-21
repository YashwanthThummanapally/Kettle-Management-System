package com.edubridge.kettle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.kettle.db.DBConnection;
import com.edubridge.kettle.dto.Kettle;

public class KettleDao implements KettleDaoI{

	@Override
	public int addKettle(Kettle kettle) {
		Connection con = DBConnection.getCon();
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into kettle values(?,?,?,?,?,?)");
			ps.setInt(1, kettle.getKettleId());
			ps.setString(2, kettle.getKettleBrand());
			ps.setFloat(3, kettle.getKettleCapacity());
			ps.setString(4, kettle.getMaterial());
			ps.setString(5, kettle.getStorage());
			ps.setDouble(6, kettle.getPrice());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}

	@Override
	public List<Kettle> retrieveKettle() {
		Connection con = DBConnection.getCon();
		List<Kettle> kettles = new ArrayList<Kettle>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from kettle");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Kettle kettle = new Kettle();
				kettle.setKettleId(rs.getInt("id"));
				kettle.setKettleBrand(rs.getString("brand"));
				kettle.setKettleCapacity(rs.getFloat("capacity"));
				kettle.setMaterial(rs.getString("material"));
				kettle.setStorage(rs.getString("storage"));
				kettle.setPrice(rs.getDouble("price"));
				
				kettles.add(kettle);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return kettles;
	}

	@Override
	public Kettle retrieveKettle(int kettleId) {
		Connection con = DBConnection.getCon();
		Kettle kettle = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from kettle where id=?");
			ps.setInt(1, kettleId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				kettle = new Kettle();
				kettle.setKettleId(rs.getInt("id"));
				kettle.setKettleBrand(rs.getString("brand"));
				kettle.setKettleCapacity(rs.getFloat("capacity"));
				kettle.setMaterial(rs.getString("material"));
				kettle.setStorage(rs.getString("storage"));
				kettle.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return kettle;
	}

	@Override
	public int updateKettle(float capacity, double price, int kettleId) {
		Connection con = DBConnection.getCon();
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("update kettle set capacity=?, price=? where id=?");
			ps.setFloat(1, capacity);
			ps.setDouble(2, price);
			ps.setInt(3, kettleId);
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public int deleteKettle(int kettleId) {
		Connection con = DBConnection.getCon();
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from kettle where id=?");
			ps.setInt(1, kettleId);
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return status;
	}
}
