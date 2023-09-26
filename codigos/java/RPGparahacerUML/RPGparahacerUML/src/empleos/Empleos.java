package empleos;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import personajes.Personaje;


public class Empleos {


	private Map<String, Integer> map = new HashMap<String, Integer>();
	private Method[] methods = Empleos.class.getDeclaredMethods();
	
	public Empleos () {
		setEmploysMap();
	}
	
	public Map<String, Integer> setEmploysMap () {
		for (int i = 0; i < this.methods.length; i++) {
			this.map.put(this.methods[i].getName(), i);
		}
		return this.map;
	}
	
	public int getIndexByName(String methodName) {
		return map.get(methodName);
	}
	
	public void herrero(Personaje p) {
		System.out.println("Soy herrero");
		p.addSkill("martillear");
	}
	
	public void panadero(Personaje p) {
		System.out.println("Soy panadero");
		p.addSkill("amasarPan");
	}
		
	public void banquero(Personaje p) {
		System.out.println("Soy banquero");
		p.addSkill("gestionarDinero");
	}
	
	public void policia(Personaje p) {
		System.out.println("Soy policia");
		p.addSkill("detener");	
	}
	
	public void militar(Personaje p) {
		System.out.println("Soy militar");
		p.addSkill("combatir");
	}
	
	public void estilista(Personaje p) {
		System.out.println("Soy estilista");
		p.addSkill("estilizar");
	}
	
	public void politico(Personaje p) {
		System.out.println("Soy politico");
		p.addSkill("mentir");	
	}
	
	public void comerciante(Personaje p) {
		System.out.println("Soy comerciante");
		p.addSkill("comerciar");
	}
	
	public void artista(Personaje p) {
		System.out.println("Soy artista");
		p.addSkill("plasmarBelleza");
	}
	
	public void medico(Personaje p) {
		System.out.println("Soy medico");
		p.addSkill("sanar");
	}
	
	public void bombero(Personaje p) {
		System.out.println("Soy bombero");
		p.addSkill("rescatar");
	}
	
	public void daw(Personaje p) {
		System.out.println("Soy desarrollador de aplicaciones web");
		p.addSkill("fullStackDev");
		p.addSkill("programar");
		p.addSkill("plasmarBelleza");
	}
	
	public void dam(Personaje p) {
		System.out.println("Soy desarrollador de aplicaciones multiplataforma");
		p.addSkill("programar");
		p.addSkill("crearAppsMoviles");
		p.addSkill("plasmarBelleza");
	}
	
	public void nini(Personaje p) {	
		System.out.println("Soy un nini... Tengo que buscar un trabajo");
		p.addSkill("gamer");
	}
}
