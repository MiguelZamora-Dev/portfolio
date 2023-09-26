package ciudad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestorIDs.GestorIDs;
import personajes.Personaje;
import sociedades.Sociedades;
import mundo.*;

public class Ciudades {
	private int id;
	private String name;
	private Personaje alcalde;
	private int nivel;
	private Paises pais;
	private Mundos mundo;
	private List<Personaje> ciudadanos = new ArrayList<Personaje>();
	private List<Sociedades> sociedades = new ArrayList<Sociedades>();
	private Map<String, Integer> ciudadanosMap = new HashMap<String, Integer>();
	private Map<Sociedades, Integer> sociedadesMap = new HashMap<Sociedades, Integer>();
	
	// Nombre de ciudad y creador de ciudad
	public Ciudades(String name, Personaje alcalde) {
		GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
		this.name = name;
		this.alcalde = alcalde;
		this.addCiudadano(this.alcalde);
		Sociedades alcaldia = new Sociedades("Alcaldia", this.alcalde);
		this.addSociedad(alcaldia);
		alcalde.setCiudad(this);
		this.nivel = 0;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId (int id) {
		this.id = id;
	}
	public String getNombre() {
		return this.name;
	}
	public Personaje getAlcalde() {
		return this.alcalde;
	}
	public void setAlcalde(Personaje alcalde) {
		if (alcalde.getCiudad() != null) {
			if (this.sociedades.get(0).getName().equals("Alcaldia")) {
				this.sociedades.get(0).setLider(alcalde);
			}
			this.pais.updateLideres(this.alcalde, alcalde);
			this.alcalde = alcalde;
			System.out.println("Se ha actualizado el representarte de " +  this.getNombre() + " en " + this.pais.getNombre());
		} else {
			System.out.println("El nuevo alcalde debe ser miembro de alguna ciudad");
		}
	}
	public List<Personaje> getCiudadanos() {
		return this.ciudadanos;
	}
	public List<Sociedades> getSociedades() {
		return this.sociedades;
	}
	public Paises getPais() {
		return this.pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}
	public Mundos getMundo() {
		return this.mundo;
	}
	public void setMundo(Mundos mundo) {
		this.mundo = mundo;
	}
	public int getNivel() {
		return this.nivel;
	}
	public void setNivel (int nivel) {
		if (nivel > 0) {
			this.nivel = nivel;
		}
	}
	public void setName(String name) {
		this.name = name;
	}

	// Añadir miembro a la ciudad
	public void addCiudadano(Personaje p) {
		if (this.ciudadanos.contains(p)) {
			System.out.println("Este ciudadano ya reside en esta ciudad");
		} else {
			this.ciudadanos.add(p);
		}
	}
	
	// Borrar miembro de la ciudad
	public void removeCiudadano(Personaje p) {
		if (this.ciudadanos.contains(p)) {
			if(this.alcalde == p) {
				this.alcalde = this.ciudadanos.get(0);
			}
			this.ciudadanos.remove(p);
		} else  {
			System.out.println("El ciudadano indicado no pertenece a esta ciudad");
		}
		
	}

	public void addSociedad(Sociedades s) {
		if(this.sociedades.contains(s)) {
			System.out.println("La sociedad ya esta en la ciudad");
		} else {
			this.sociedades.add(s);
		}
	}
	
	public void removeSociedad(Sociedades s) {
		if (this.sociedades.contains(s)) {
			if(s.getName().equals("Alcaldia")) {
				System.out.println("La alcaldia no puede eliminarse");
			} else {
				this.sociedades.remove(s);
			}
		} else  {
			System.out.println("La sociedad indicada no pertenece a esta ciudad");
		}
	}

	// Mostrar miembros de las ciudad
	public void listarCiudadanos() {
		for ( int i = 0; i < this.ciudadanos.size(); i++) {
			System.out.println("\t" + i + " : " + this.ciudadanos.get(i).getNombre());
		}
	}
	public void listarCiudadanos(int tabs) {
		tabs++;
		for ( int i = 0; i < this.ciudadanos.size(); i++) {
			if ( tabs > 0 ) {
				System.out.print("  ".repeat(tabs));
				System.out.print("|__ ");
			}
			System.out.println(i + " : " + this.ciudadanos.get(i).getNombre());
		}
	}
	
	// Mostrar sociedades en la ciudad
	public void listarSociedades () {
		for (int i = 0; i < this.sociedades.size(); i++) {
			System.out.println("\t" + i + " : " + this.sociedades.get(i).getName());
		}
	}
	public void listarSociedades (int tabs) {
		tabs++;
		for (int i = 0; i < this.sociedades.size(); i++) {
			if ( tabs > 0 ) {
				System.out.print("  ".repeat(tabs));
				System.out.print("|__ ");
			}
			System.out.println(i + " : " + this.sociedades.get(i).getName());
		}
	}
	
	public int poblacion () {
		return this.ciudadanos.size();
	}
	
	public int numSociedadesEnCiudad () {
		return this.sociedades.size();
	}
	
	public void mapCiudadanosBySociedades () {
		for ( Sociedades sociedad : this.sociedades ) {
			System.out.print(sociedad.getName() + "\n\t");
			sociedad.listarMiembros();
			System.out.println();
		}
	}

	public void mapCiudadanosBySociedades (int tabs) {
		for ( Sociedades sociedad : this.sociedades ) {
			if ( tabs > 0 ) {
				System.out.print("  ".repeat(tabs));
				System.out.print("|__ " + sociedad.getName());
			}
			sociedad.listarMiembros();
			System.out.println();
		}
	}
	
	private void setCiudadanosMap () {
		for (int i = 0; i < this.ciudadanos.size(); i++) {
			this.ciudadanosMap.put(this.ciudadanos.get(i).getNombre(), i);
		}
	}
	
	private void setSociedadesMap () {
		for (int i = 0; i < this.sociedades.size(); i++) {
			this.sociedadesMap.put(this.sociedades.get(i), i);
		}
	}
	
	public int getIndexByNameCiudadanos(String ciudadano) {
		this.setCiudadanosMap();
		return this.ciudadanosMap.get(ciudadano);
	}
	
	public int getIndexBySociedades(Sociedades sociedad) {
		this.setSociedadesMap();
		return this.sociedadesMap.get(sociedad);
	}
	public void deleteSelf () {
		for (Sociedades sociedad : this.sociedades) {
			sociedad.deleteSelf();
			sociedad = null;
		}
		for (Personaje ciudadano : this.ciudadanos) {
			List<Ciudades> ciudades = ciudadano.getCiudades();
			ciudades.remove(this);
			ciudadano.setCiudades(ciudades);
		}
	}
	@Override
	public String toString () {
		return "Nombre:\t" + this.name +
		"\nNivel:\t" + this.nivel + 
		"\nAlcalde:\t" + this.alcalde + 
		"\nPoblacion:\t" + this.poblacion() + 
		"\nSociedades:\t"  + this.numSociedadesEnCiudad();

	}

	/* FALTAN METODOS PARA 
	* 1) MOSTRAR EMPLEOS SIN CUBRIR
	* 2) ELIMINAR CIUDAD -> DEBE ELIMINAR EL ÁRBOL
	* */
}
