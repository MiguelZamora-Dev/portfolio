package personajes.personajeAire;

import personajes.Personaje;

public class PersonajeAire extends Personaje implements CommonPersonajeAire{

	public PersonajeAire(String name) {
		super(name);
		this.setArcano((int)Math.round(getArcano() * 1.5));
		this.setFuerza((int)Math.round(getFuerza() * 0.7));
		this.setAtaque((int)Math.round(getAtaque() * 0.8));
	}

	@Override
	public void aplicarCortes() {
		System.out.println(this.getNombre() + " ha provocado un corte");
	}

	@Override
	public String saluda() {
		return "Hola, soy un personaje de tipo aire";
	}
}
