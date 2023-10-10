package calificaciones;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		double notaAcumulada = 0;
		int notaMedia = 0;
		Alumno alumno = new Alumno("Miguel", 22051);
		ArrayList<Calificacion> calificaciones = alumno.getCalificaciones();
		
		alumno.calificar("Formacion y Orientacion Laboral", 70);
		alumno.calificar("Sistemas informaticos", 85);
		alumno.calificar("Programacion", 92);
		alumno.calificar("Arquitectura de redes", 71);
		alumno.calificar("Fisica I", 75);
		alumno.calificar("Estadistica", 68);
		
		System.out.println(alumno.toString());
		/*for ( int i = 0; i < alumno.getCalificaciones().size(); i++) {
			System.out.println(calificaciones.get(i).toString());
			notaMedia += calificaciones.get(i).getNota();
		}*/
		for ( int i = 0; i < alumno.getCalificaciones().size(); i++) {
			System.out.printf("%-32s  %2d \n", calificaciones.get(i).getAsignatura(), calificaciones.get(i).getNota());
			notaAcumulada += calificaciones.get(i).getNota();
		}
		notaMedia = (int)Math.round(notaAcumulada / alumno.getCalificaciones().size());
		System.out.printf("NOTA MEDIA: " + notaMedia + "\n");
	
	}

}
