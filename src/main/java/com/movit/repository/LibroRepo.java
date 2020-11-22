package com.movit.repository;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.movit.entity.Libro;

@Repository
public class LibroRepo {
	
	
	/*public LibroRepo() {

	}

	public void crear(Libro libro) {
		try {
			File archivo = new File("Archivos/listaLibros.txt");
			FileWriter escribir = new FileWriter(archivo, true); // true para que no reescriba lo que ya esta en el txt
			escribir.write(libro.serializar(libro));
			escribir.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Libro> consultar() {
		ArrayList<Libro> listaPelicula = new ArrayList<Libro>();
		String linea = null;
		try {
			File archivo = new File("Archivos/listaLibros.txt");
			FileReader lector = new FileReader(archivo);
			BufferedReader br = new BufferedReader(lector);
			linea = br.readLine();
			if(linea == null) {
				return listaPelicula;
			}
			else {	
				String palabra[] = linea.split(";");
				int i;
				for (i = 0; i < palabra.length; i++) {
					String bufer[] = palabra[i].split(",");
					Libro libro = new Libro(Integer.parseInt(bufer[0]),bufer[1], bufer[2], bufer[3]);
					listaPelicula.add(libro);
				}
				return listaPelicula;
			}
		} catch (FileNotFoundException e) {

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public void editar(ArrayList<Libro> lib) {
		String serie="";
		try {
			File archivo = new File("Archivos/listaLibros.txt");
			FileWriter escribir = new FileWriter(archivo, false); // true para que no reescriba lo que ya esta en el txt
			for (Libro libro : lib) {
				serie += libro.serializar(libro);
			}
			escribir.write(serie);
			escribir.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	*/


}
