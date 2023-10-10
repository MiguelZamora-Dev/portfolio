package mascotas;

import gestorIDs.GestorIDs;
import personajes.Personaje;

public class Mascotas {
	private int id;
	private String nombre;
	private Personaje companero;
	private int nivel;
	private boolean isAvailable;

	public Mascotas(String nombre, Personaje p) {
		GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
		this.nombre = nombre;
		this.nivel = 0;
		this.companero = p;
		this.isAvailable = true;
	}

	public int getId () {
		return this.id;
	}
	public void setId (int id) {
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Personaje getCompanero() {
		return this.companero;
	}
	public void setCompanero(Personaje companero) {
		this.companero = companero;
	}
	public int getNivel() {
		return this.nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public boolean isAvailable () {
		return this.isAvailable;
	}
	public void setAvailable (boolean b) {
		this.isAvailable = b;
	}

	public String saluda() {
		String mensaje = this.nombre + " esta de mision y no puede comunicarse";
		if ( this.isAvailable ) {
			mensaje = "Hola, soy una mascota";
		}
		return mensaje;
	}
	public String despidete() {
		String mensaje = this.nombre + " esta de mision y no puede comunicarse";
		if ( this.isAvailable ) {
			mensaje = "Hasta luego!";
		}
		return mensaje;
	}
	
	@Override
	public String toString() {
		return "Nombre:\t\t" + this.nombre +
				"\nNivel:\t\t" + this.nivel + 
				"\nCompanero:\t" + this.companero.getNombre();
	}

}
