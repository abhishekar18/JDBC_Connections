package com.training.join;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.training.utils.DbConnections;

public class JoinsExample {
	public static void main(String[] args) {
		try {
			String sql= "select * from test.bajaj_doctor" + "select * from test.bajaj_doctor  left outer join test.bajaj_patient on test.bajaj_doctor.doctorId = 101";
			Connection con= DbConnections.getMySqlConnection();
			PreparedStatement pstmt =con.prepareStatement(sql);
			int docRef=101;
			pstmt.setInt(1, docRef);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
