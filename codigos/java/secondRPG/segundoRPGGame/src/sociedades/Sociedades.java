package sociedades;

import java.util.ArrayList;
import java.util.List;

import gestorIDs.GestorIDs;
import personajes.Personaje;

public class Sociedades implements Sociedad {
	private int id;
	private String name;
	private Personaje lider;
	private int xP;
	private int nivel;
	private List<Personaje> team = new ArrayList<Personaje>();
	
	public Sociedades (String name, Personaje lider) {
		GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
		this.name = name;
		this.lider = lider;
		this.addToTeam(lider);
		this.xP = 0;
		this.nivel = 0;
	}
	
	public int getId () {
		return this.id;
	}
	public void setId (int id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public Personaje getLider() {
		return this.lider;
	}
	@Override
	public List<Personaje> getTeam() {
		return this.team;
	}
	@Override
	public int getXP() {
		return this.xP;
	}
	@Override
	public int getNivel() {
		return this.nivel;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setLider(Personaje lider) {
		if (this.team.size() > 0) {
			if (this.team.contains(lider)) {
				this.lider = lider;
			} else {
				System.out.println("Ese ciudadano no pertenece aun a esta sociedad");
			}
		} else {
			System.out.println("Esta sociedad no tiene miembros activos");
		}
	}
	@Override
	public void addToTeam(Personaje p) {
		this.team.add(p);
	}
	@Override
	public void setXP(int xp) {
		this.xP = xp;
	}
	@Override
	public void setNivel(int nivel) {
		if (nivel > 0) {
			this.nivel = nivel;
		}
	}
	
	// Estas funciones son para caracteristicas futuras
	@Override
	public void aceptar(Personaje p) {
		this.addToTeam(p);
		System.out.println(p.getNombre() + " se ha unido a la sociedad");
	}
	@Override
	public void invitar(Personaje p) {
		System.out.println("Se ha enviado una invitacion a " + p.getNombre());
	}
	
	
	@Override
	public void listarMiembros() {
		for(Personaje miembro : this.team) {
			System.out.println("\t" + miembro.getNombre());
		}
	}

	// De momento no tiene uso porque Ciudades.getMapBy...() ya cumple esta función con el método Sociedades.listarMiembros()
	public void listarMiembros (int tabs) {
		for(int i = 0; i < this.team.size(); i++) {
			if ( tabs > 0 ) {
				System.out.print("  ".repeat(tabs));
				System.out.print("|__ " + i + " : " + this.team.get(i).getNombre());
			}
		}
	}

	@Override
	public boolean[] expulsar(Personaje p) {
		// {se ha eliminado correctamente, se debe eliminar la instancia de esta sociedad}
		boolean[] res = {false, false};
		if (this.team.size() - 1 == 0) {
			if (this.name.equals("Alcaldia")) {
				System.out.println("La Alcaldia no se puede quedar vacia. Se debe eliminar la ciudad para vaciarla");
			} else {
				this.team.remove(p);
				System.out.println("La sociedad se ha quedado vacia y se va a eliminar");
				res[1] = true;
			}
		} else {
			if (this.team.contains(p)) {
				if(this.lider == p) {
					this.team.remove(p);
					try {
						this.setLider(this.team.get(0));
						res[0] = true;
					} catch (Exception e) {
						System.out.println("AVISO: No se ha podido actualizar el lider. Por favor, asignalo de forma manual");
					}
				} else {
					this.team.remove(p);
					res[0] = true;
				}
				
			} else  {
				System.out.println("El miembro indicado no pertenece a esta sociedad");
			}
		}
		return res;
	}
	public void deleteSelf () {
		for (Personaje miembro : this.team) {
			List<Sociedades> socs = miembro.getSociedades();
			socs.remove(this);
			miembro.setSociedades(socs);
		}
	}

	@Override
	public String toString () {
		return "Nombre:\t" + this.name +
		"\nLider:\t" + this.lider.getNombre() + 
		"\nExp.:\t" + this.xP + 
		"\nNivel:\t" + this.nivel;
	}
}
