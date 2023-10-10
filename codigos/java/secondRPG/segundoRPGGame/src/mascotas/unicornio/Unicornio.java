package mascotas.unicornio;

import mascotas.Mascotas;
import personajes.Personaje;

public class Unicornio extends Mascotas{

	public Unicornio (String nombre, Personaje p) {
		super(nombre, p);
	}
	
	@Override
	public String saluda() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "* Ruidos de unicornio *";
		}
		return mensaje;
	}

	@Override
	public String despidete() {
		String mensaje = this.getNombre() + " esta de mision y no puede comunicarse";
		if ( this.isAvailable() ) {
			mensaje = "* Doble ruido de unicornio *!";
		}
		return mensaje;
	}
}
