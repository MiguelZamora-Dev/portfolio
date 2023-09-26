package calificaciones;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private int matricula;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	public Alumno (String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getMatricula () {
		return this.matricula;
	}
	
	public ArrayList<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}
	
	public void calificar (String asignatura, int nota) {
		Calificacion calificacion = new Calificacion(asignatura, nota);
		calificaciones.add(calificacion);
	}
	
	@Override
	public String toString() {
		return "Alumno matricula: " + this.matricula + " - " + this.nombre;
	}
	
}
