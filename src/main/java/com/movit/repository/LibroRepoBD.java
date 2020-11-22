package com.movit.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.movit.entity.Libro;

@Repository
public class LibroRepoBD {
	
	/*public void insertarBD(Libro libro) throws SQLException {
		
		ConBD con = new ConBD("postgres","admin");
		Connection cnc = con.con();
		Statement stm = con.stamt();
		
		stm.execute("Insert into public.libro (id, nombre, autor) values("+ libro.getId() +",'"+ libro.getNombre() +"','"+ libro.getAutor() +"')");
		cnc.close();		
	}
	
	public ArrayList<Libro> consultarBD() throws SQLException{
		ConBD con = new ConBD("postgres","admin");
		Connection cnc = con.con();
		Statement stm = con.stamt();
		ResultSet rs;
		ArrayList<Libro> lis = new ArrayList<>();
		
		rs = stm.executeQuery("select * from public.libro");
		
		while(rs.next()) {
			Libro l = new Libro(
					Integer.parseInt(rs.getArray(1).toString()),
					rs.getArray(2).toString(),
					rs.getArray(3).toString(),
					rs.getArray(4).toString());
			lis.add(l);
		}	
		cnc.close();
		return lis;
	}*/

}
