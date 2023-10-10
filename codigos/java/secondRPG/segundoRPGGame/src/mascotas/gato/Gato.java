package mascotas.gato;

import mascotas.Mascotas;
import personajes.Personaje;

public class Gato extends Mascotas{

	public Gato (String nombre, Personaje p) {
		super(nombre, p);
	}
	
	@Override
	public String saluda() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "Miauuuu";
		}
		return mensaje;
	}

	@Override
	public String despidete() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "Miauu miau!";
		}
		return mensaje;
	}
}
