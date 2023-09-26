package personajes.personajeElectrico;

import personajes.Personaje;

public class PersonajeElectrico extends Personaje implements CommonPersonajesElectrico{

	public PersonajeElectrico(String name) {
		super(name);
		this.setArcano((int)Math.round(getArcano() * 1.5));
		this.setFuerza((int)Math.round(getFuerza() * 0.7));
		this.setAtaque((int)Math.round(getAtaque() * 0.8));
	}

	@Override
	public void aplicarParalisis() {
		System.out.println(this.getNombre() + " ha provocado paralisis");
	}

	@Override
	public String saluda() {
		return "Hola, soy un personaje de tipo electrico";
	}
}
