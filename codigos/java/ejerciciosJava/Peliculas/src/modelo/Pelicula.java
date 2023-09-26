package modelo;
import java.util.Scanner;

public class Pelicula {
	private String titulo;
	private int duracion;
	private String protagonista;
	private String idioma;
	private Scanner scanner = new Scanner(System.in);
	
	public Pelicula() {
		
	}
	
	public Pelicula(String titulo, int duracion, String protagonista, String idioma) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.protagonista = protagonista;
		this.idioma = idioma;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getProtagonista() {
		return this.protagonista;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String newTitulo () {
		System.out.print("Introduce el titulo de la pelicula: ");
		String titulo = this.scanner.nextLine();
		return titulo;
	}
	
	public int newDuracion () {
		System.out.print("Introduce la duracion en minutos: ");
		int duracion = scanner.nextInt();
		scanner.nextLine();
		return duracion;
	}
	
	public String newProtagonista () {
		System.out.print("Quien protagoniza la pelicula: ");
		String prota = this.scanner.nextLine();
		return prota;
	}
	
	public String newIdioma () {
		System.out.print("En que idioma esta: ");
		String idioma = this.scanner.nextLine();
		return idioma;
	}
	
	@Override
	public String toString() {
		return "Titulo:\t\t" + this.titulo + 
				"\nDuracion:\t" + this.duracion +
				"\nProtagonista:\t" + this.protagonista + 
				"\nIdioma:\t\t" + this.idioma;
	}
}
