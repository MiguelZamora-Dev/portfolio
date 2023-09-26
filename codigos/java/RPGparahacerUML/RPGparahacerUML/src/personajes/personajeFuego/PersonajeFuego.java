package personajes.personajeFuego;

import personajes.Personaje;

public class PersonajeFuego extends Personaje implements CommonPersonajeFuego {

	public PersonajeFuego(String name) {
		super(name);
		this.setArcano((int)Math.round(getArcano() * 1.5));
		this.setFuerza((int)Math.round(getFuerza() * 0.7));
		this.setAtaque((int)Math.round(getAtaque() * 0.8));
	}

	@Override
	public void aplicarQuemadura() {
		System.out.println(this.getNombre() + " ha aplicado quemadura");
	}
	
	@Override 
	public String saluda() {
		return "Hola, soy personaje de tipo fuego";
	}

}
