package mundo;

import ciudad.Ciudades;
import gestorIDs.GestorIDs;
import personajes.Personaje;

import java.util.List;
import java.util.ArrayList;

public class Paises {
    private int id;
    private String nombre;
    private int nivel;
    private Mundos mundo;
    private List<Ciudades> ciudades = new ArrayList<Ciudades>(); 
    private List<Personaje> lideres = new ArrayList<Personaje>();
    private List<Personaje> ciudadanos = new ArrayList<Personaje>();

    public Paises (String nombre, List<Ciudades> ciudades) {
        GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
        this.nombre = nombre;
        this.ciudades = ciudades;
        for ( Ciudades ciudad : this.ciudades ) {
            this.lideres.add(ciudad.getAlcalde());
        }
        this.updateAllCiudadanos();
        this.nivel = 0;
    }

    // getters and setters 
    public int getId () {
        return this.id;
    }
    public void setId (int id) {
		this.id = id;
	}
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Ciudades> getCiudades() {
        return this.ciudades;
    }
    public void setCiudades(List<Ciudades> ciudades) {
        this.ciudades = ciudades;
    }
    public void addCiudad(Ciudades ciudad) {
        if (!this.ciudades.contains(ciudad)) {
            this.ciudades.add(ciudad);
            this.lideres.add(ciudad.getAlcalde());
        } else {
            System.out.println("La ciudad ya se encuentra en este pais");
        }
    }
    public void removeCiudad (Ciudades ciudad) {
        if (this.ciudades.contains(ciudad)) {
            this.ciudades.remove(ciudad);
            if (this.lideres.contains(ciudad.getAlcalde())) {
                this.lideres.remove(ciudad.getAlcalde());
            } else {
                System.out.println("El lider indicado no pertenece al grupo de lideres");
            } 
        } else {
            System.out.println("La ciudad ya se encuentra en este pais");
        }
    }
    public int getNivel() {
        return this.nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public List<Personaje> getLideres() {
        return this.lideres;
    }
    public void setLideres(List<Personaje> lideres) {
        this.lideres = lideres;
    }
    public void updateLideres(Personaje antiguo, Personaje nuevo) {
        if (this.lideres.contains(antiguo)) {
            this.lideres.remove(antiguo);
            this.lideres.add(nuevo);
            System.out.println("Se ha actualizado el representante de " + this.nombre + " en " + this.mundo.getNombre());
            this.mundo.updateLideres(antiguo, nuevo);
        } else {
            System.out.println("El lider indicado no forma parte del grupo de lideres");
        }
    }
    public List<Personaje> getCiudadanos() {
        return this.ciudadanos;
    }
    public void setCiudadanos(List<Personaje> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
    public void addCiudadano(Personaje ciudadano) {
        if (!this.ciudadanos.contains(ciudadano)) {
            this.ciudadanos.add(ciudadano);
        } else {
            System.out.println("El ciudadano ya reside en la ciudad");
        }
    }
    public void updateAllCiudadanos() {
        for (Ciudades ciudad : this.ciudades) {
            this.ciudadanos.addAll(ciudad.getCiudadanos());
        }
    }
    public void showTreeCiudadanos (int tabs) {
        tabs++;
        System.out.println(this.nombre);
        for (Ciudades ciudad : this.ciudades) {
            this.updateAllCiudadanos();
            System.out.print("  ".repeat(tabs));
            System.out.print("|__ ");
            System.out.println(ciudad.getNombre());
            ciudad.listarCiudadanos(tabs);
        }
    }
    public void showTreeSociedades (int tabs) {
        tabs++;
        System.out.println(this.nombre);
        for (Ciudades ciudad : this.ciudades) {
            this.updateAllCiudadanos();
            System.out.print("  ".repeat(tabs));
            System.out.print("|__ ");
            System.out.println(ciudad.getNombre());
            ciudad.listarSociedades(tabs);
        }
    }
    public void showCiudades () {
        System.out.println("Ciudades en " + this.nombre);
        for ( Ciudades ciudad : this.ciudades ) {
            System.out.println("\t" + ciudad.getNombre());
        }
    }

    public void showLideres () {
        System.out.println("Lideres de " + this.nombre);
        for ( Personaje lider : this.lideres ) {
            System.out.println("\t" + lider.getNombre());
        }
    }

    public int numCiudades () {
        return this.ciudades.size();
    }

    public void deleteSelf () {
        for (Ciudades ciudad : this.ciudades) {
            ciudad.deleteSelf();
            ciudad = null;
        }
        this.updateAllCiudadanos();
        for (Personaje ciudadano : this.ciudadanos) {
			ciudadano.setPais(null);
		}
    }

    @Override
    public String toString () {
        return "Nombre:\t" + this.nombre +
        "\nNivel:\t" + this.nivel;
    }

    /* FALTAN METODOS PARA 
	* 1) ELIMINAR PAIS -> DEBE ELIMINAR EL ÁRBOL
	* */
    
}
