package personajes.personajeTierra;

import personajes.Personaje;

public class PersonajeTierra extends Personaje implements CommonPersonajeTierra{

	public PersonajeTierra(String name) {
		super(name);
		this.setArcano((int)Math.round(getArcano() * 1.5));
		this.setFuerza((int)Math.round(getFuerza() * 0.7));
		this.setAtaque((int)Math.round(getAtaque() * 0.8));
	}

	@Override
	public void aplicarAplastamiento() {
		System.out.println(this.getNombre() + " ha aplastado");
	}

	@Override
	public String saluda() {
		return "Hola, soy un personaje de tipo tierra";
	}
}
