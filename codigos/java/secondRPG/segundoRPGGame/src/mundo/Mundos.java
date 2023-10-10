package mundo;

import java.util.ArrayList;
import java.util.List;
import personajes.Personaje;
import ciudad.Ciudades;
import gestorIDs.GestorIDs;

public class Mundos {
    private int id;
    private String nombre;
    private List<Paises> paises = new ArrayList<Paises>();
    private List<Personaje> lideres = new ArrayList<Personaje>();
    private List<Personaje> ciudadanos = new ArrayList<Personaje>();

    public Mundos (String nombre, List<Paises> paises) {
        GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
        this.nombre = nombre;
        this.paises = paises;
        for ( Paises pais : this.paises ) {
            for ( Ciudades ciudad : pais.getCiudades() ) {
                this.lideres.add(ciudad.getAlcalde());
            }
        }
        this.updateAllPaises();
    }

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
            System.out.println("Se ha actualizado el representante de " + nuevo.getPais() + " en " + this.getNombre());
        } else {
            System.out.println("El lider indicado no forma parte del grupo de lideres");
        }
    }
    public List<Paises> getPaises() {
        return this.paises;
    }
    public void addPais(Paises pais) {
        if (!this.paises.contains(pais)) {
            this.paises.add(pais);
        } else {
            System.out.println("El pais indicado no se encuentra en este mundo");
        }
    } 
    public void removePais(Paises pais) {
        if (this.paises.contains(pais)) {
            this.paises.remove(pais);
        } else {
            System.out.println("El pais indicado no se encuentra en este mundo");
        }
    }
    public void updateAllPaises () {
        for (Paises pais : this.paises) {
            pais.updateAllCiudadanos();
            this.ciudadanos.addAll(pais.getCiudadanos());
        }
    }
    public void showTreeCiudadanos (int tabs) {
        tabs++;
        System.out.println(this.nombre);
        for (Paises pais : this.paises) {
            pais.updateAllCiudadanos();
            System.out.print("  ".repeat(tabs));
            System.out.print("|__ ");
            pais.showTreeCiudadanos(tabs);
        }
    }
    public void showTreeSociedades (int tabs) {
        tabs++;
        System.out.println(this.nombre);
        for (Paises pais : this.paises) {
            pais.updateAllCiudadanos();
            System.out.print("  ".repeat(tabs));
            System.out.print("|__ ");
            pais.showTreeSociedades(tabs);
        }
    }
    public void deleteSelf () {
        for (Paises pais : this.paises) {
            pais.deleteSelf();
            pais = null;
        }
        for (Personaje ciudadano : this.ciudadanos) {
            ciudadano.setMundo(null);
        }
    }
    
}
