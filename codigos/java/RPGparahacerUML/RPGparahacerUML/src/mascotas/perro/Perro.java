package mascotas.perro;

import mascotas.Mascotas;
import personajes.Personaje;

public class Perro extends Mascotas {

	public Perro (String nombre, Personaje p) {
		super(nombre, p);
	}
	
	@Override
	public String saluda() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "Guauuu";
		}
		return mensaje;
	}

	@Override
	public String despidete() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "Guauu guau!";
		}
		return mensaje;
	}
}
