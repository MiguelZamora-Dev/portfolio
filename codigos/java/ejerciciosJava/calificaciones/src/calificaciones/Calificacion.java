package calificaciones;

public class Calificacion {
	private String asignatura;
	private int nota;
	
	Calificacion (String asignatura, int nota) {
		this.asignatura = asignatura;
		this.nota = nota;
	}
	
	
	public String getAsignatura () {
		return this.asignatura;
	}
	
	public int getNota () {
		return this.nota;
	}
	
	public void setAsignatura (String asignatura) {
		this.asignatura = asignatura;
	}
	
	public void setNota (int nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return this.asignatura + ": " + this.nota;
	}
}
