package habilidades;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Habilidades {
	
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private Method[] methods = Habilidades.class.getDeclaredMethods();
	
	public Habilidades () {
		setSkillsMap();
	}
	
	public Map<String, Integer> setSkillsMap () {
		for (int i = 0; i < this.methods.length; i++) {
			this.map.put(this.methods[i].getName(), i);
		}
		return this.map;
	}
	
	public void showMap () {
		System.out.println(this.map);
	}
	
	public int getIndexByName(String methodName) {
		return map.get(methodName);
	}
	
	public void martillear() {
		System.out.println("Estoy martillando");
	}
	
	public void amasarPan() {
		System.out.println("Estoy amasando pan");
	}
	
	public void gestionarDinero() {
		System.out.println("Estoy contando billetes");
	}
	
	public void detener() {
		System.out.println("Estoy deteniendo");
	}
	
	public void combatir() {
		System.out.println("Estoy combatiendo");
	}
	
	public void estilizar() {
		System.out.println("Estoy estilizando");
	}
	
	public void mentir() {
		System.out.println("Estoy mintiendo");
	}
	
	public void comerciar() {
		System.out.println("Estoy comerciando");
	}
	
	public void plasmarBelleza() {
		System.out.println("Estoy plasmando mi perspectiva de la belleza en diferentes formatos");
	}
	
	public void sanar() {
		System.out.println("Estoy sanando a mi paciente");
	}
	
	public void rescatar() {
		System.out.println("Estoy rescantado a quien mi necesita");
	}
	
	public void fullStackDev() {
		System.out.println("Estoy creando aplicaciones web :)");
	}
	
	public void programar() {
		System.out.println("Estoy programando :)");
	}
	
	public void crearAppsMoviles() {
		System.out.println("Estoy creando aplicaciones móviles");
	}
	
	public void gamer() {
		System.out.println("Me estoy echando unas partiditas. Otra vez, sí");
	}
}
