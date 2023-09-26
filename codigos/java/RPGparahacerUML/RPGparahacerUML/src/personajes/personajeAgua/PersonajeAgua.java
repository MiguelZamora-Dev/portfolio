package personajes.personajeAgua;

import personajes.Personaje;

public class PersonajeAgua extends Personaje implements CommonPersonajeAgua{

	public PersonajeAgua(String name) {
		super(name);
		this.setArcano((int)Math.round(getArcano() * 1.5));
		this.setFuerza((int)Math.round(getFuerza() * 0.7));
		this.setAtaque((int)Math.round(getAtaque() * 0.8));
	}

	@Override
	public void aplicarMojado() {
		System.out.println(this.getNombre() + " ha aplicado mojado");
	}
	
	@Override 
	public String saluda() {
		return "Hola, soy personaje de tipo agua";
	}

}
