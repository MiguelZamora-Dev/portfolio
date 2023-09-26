package personajes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ciudad.Ciudades;
import empleos.Empleos;
import habilidades.Habilidades;
import mascotas.Mascotas;
import mundo.*;
import principal.Liga;
import sociedades.Sociedades;
import equipo.Arma;
import equipo.Equipo;
import equipo.Escudo;
import gestorIDs.GestorIDs;

public class Personaje implements CommonPersonajes{
	// Los atributos están por orden alfabético y tipo, igual que sus getters y setters 
	private int agresividad;
	private int arcano = 0;
	private int ataquEspecial;
	private int ataque;
	private int defensa;
	private int defensaEspecial;
	private int experiencia = 0;
	private int fuerza = 0;
	private int hp;
	private int id;
	private int nextExperiencia = 100;
	private int nivel = 1;
	private int resistencia;
	private int velocidad;
	private int dinero;
	private boolean isAlive = true;
	private String empleoName;
	private String nombre;
	private Ciudades ciudad;
	private Paises pais;
	private Mundos mundo;
	private Empleos empleo = new Empleos();
	private Liga liga;
	private List<Equipo> equipamiento = new ArrayList<Equipo>();
	private Arma arma;
	private Escudo escudo;
	private Tipo tipo = Tipo.values()[(int)Math.round(Math.random()*4)];
	private List<Personaje> amigos = new ArrayList<Personaje>();
	private List<Ciudades> ciudades = new ArrayList<Ciudades>();
	private List<Mascotas> mascotas = new ArrayList<Mascotas>();
	private List<Method> skills = new ArrayList<Method>();
	private List<Sociedades> sociedades = new ArrayList<Sociedades>();
	private Map<String, Integer> skillsMap = new HashMap<String, Integer>();
	
	// Probando el global scope de esta variable
	Habilidades h = new Habilidades();
	
	
	public Personaje (String name) {
		// Para simplificar se han iniciado los atributos con valores aleatorios
		GestorIDs gestor = new GestorIDs();
		this.id = gestor.setId(gestor);
		this.nombre = name;
		this.hp = (int)Math.round(Math.random()*50 + 100);
		this.fuerza = (int)Math.round(Math.random()*20 + 80);
		this.arcano = (int)Math.round(Math.random()*20 + 80);
		this.ataque = (int)Math.round(Math.random()*20 + 80) + (int)Math.round(this.fuerza * 0.3);
		this.ataquEspecial = (int)Math.round(Math.random()*20 + 80) + (int)Math.round(this.arcano * 0.4);
		this.defensa = (int)Math.round(Math.random()*20 + 80) + (int)Math.round(this.fuerza * 0.7);
		this.defensaEspecial = (int)Math.round(Math.random()*20 + 80) + (int)Math.round(this.arcano * 0.6);
		this.resistencia = (int)Math.round(Math.random()*20 + 80);
		this.velocidad = (int)Math.round(Math.random()*20 + 80);
		this.agresividad = (int)Math.round(Math.random()*20 + 80);
		this.dinero = 0;
	}
	
	public Personaje (int agresividad, int arcano, int ataquEspecial,
	int ataque, int defensa, int defensaEspecial, 
	int experiencia, int fuerza, int hp, int id, 
	int nextExperiencia, int nivel, int resistencia, 
	int velocidad, int dinero, boolean isAlive, 
	String empleoName, String nombre, Ciudades ciudad, 
	Paises pais, Mundos mundo, Empleos empleo, Liga liga,
	List<Equipo> equipamiento, Arma arma, Escudo escudo, 
	Tipo tipo, List<Personaje> amigos, List<Ciudades> ciudades,
	List<Mascotas> mascotas, List<Method> skills, 
	List<Sociedades> sociedades, Map<String, Integer> skillsMap) {
		this.agresividad = agresividad;
		this.arcano = arcano;
		this.ataquEspecial = ataquEspecial;
		this.defensa = defensa;
		this.defensaEspecial = defensaEspecial;
		this.experiencia = experiencia;
		this.fuerza = fuerza;
		this.hp = hp;
		this.id = id;
		this.nextExperiencia = nextExperiencia;
		this.nivel = nivel;
		this.resistencia = resistencia;
		this.velocidad = velocidad;
		this.dinero = dinero;
		this.isAlive = isAlive;
		this.empleoName = empleoName;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.mundo = mundo;
		this.empleo = empleo;
		this.liga = liga;
		this.equipamiento = equipamiento;
		this.arma = arma;
		this.escudo = escudo;
		this.tipo = tipo;
		this.amigos = amigos;
		this.ciudades = ciudades;
		this.mascotas = mascotas;
		this.skills = skills;
		this.mascotas = mascotas;
		this.sociedades = sociedades;
		this.skillsMap = skillsMap;
	}

	// Getters y setters por orden alfabético
	// Agresividad
	public int getAgresividad() {
		return this.agresividad;
	}
	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}
	
	// Arcano
	public int getArcano() {
		return this.arcano;
	}
	public void setArcano(int arcano) {
		this.arcano = arcano;
	}
	
	// Ataque especial
	public int getAtaquEspecial() {
		return this.ataquEspecial;
	}
	public void setAtaquEspecial(int ataquEspecial) {
		this.ataquEspecial = ataquEspecial;
	}
	
	// Ataque
	public int getAtaque() {
		return this.ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	// Defensa
	public int getDefensa() {
		return this.defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	// Defensa especial
	public int getDefensaEspecial() {
		return this.defensaEspecial;
	}
	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}
	
	// Experiencia
	public int getExperiencia() {
		return this.experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia += experiencia;
		while ( this.experiencia >= this.nextExperiencia ) {
			this.setNivel(this.getNivel() + 1);
			this.setNextExperiencia();	
		}
	}
	
	// Fuerza
	public int getFuerza() {
		return this.fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	// HP
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
		if ( this.hp <= 0 ) {
			this.isAlive = false;
			this.hp = 0;
			System.out.println("\u001B[31m" + this.getNombre() + " se debilito" + "\033[37m");
		} else {
			this.isAlive = true;
		}
	}
	
	// ID
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// Próximo punto de experiencia para subir de nivel
	public int getNextExperiencia () {
		return this.nextExperiencia;
	}
	public void setNextExperiencia () {
		this.nextExperiencia += (int)Math.round(this.nextExperiencia * 0.5);
	}
	
	// Nivel
	public int getNivel() {
		return this.nivel;
	}
	private void setNivel(int nivel) {
		this.nivel = nivel;
		System.out.println(this.getNombre() + " ha subido al nivel " + this.getNivel() + "!");
	}
	
	// Resistencia
	public int getResistencia() {
		return this.resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	// Velocidad
	public int getVelocidad() {
		return this.velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	// Dinero
	public int getDinero() {
		return this.dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	// Comprobador de si está operativo
	public boolean isAlive() {
		return this.isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	// Empleo: parte 1
	public String getEmpleo () {
		return this.empleoName;
	}
	public void setEmpleo (String jobName) {
		try {
			Empleos.class.getMethod(jobName, Personaje.class).invoke(this.empleo, this);
			this.empleoName = jobName;
			System.out.println("Enhorabuena! Ahora eres " + this.empleoName);
		} catch (Exception e) {
			System.out.println("Ese empleo no esta disponible");
		}
	}
	
	// Nombre
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Ciudades: parte 1
	public Ciudades getCiudad () {
		return this.ciudad;
	}

	// Pais
	public Paises getPais() {
		return this.pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}

	// Mundo
	public Mundos getMundo() {
		return this.mundo;
	}
	public void setMundo(Mundos mundo) {
		this.mundo = mundo;
	}

	// Empleo: parte 2
	public Empleos getEmpleoObject () {
		return this.empleo;
	}
	
	// Liga
	public Liga getLiga() {
		return this.liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	// Equipo
	public List<Equipo> getEquipamiento() {
		return this.equipamiento;
	}
	public void updateEquipamiento(Equipo antiguo, Equipo nuevo) {
		if (this.equipamiento.contains(antiguo)) {
			this.equipamiento.remove(antiguo);
			this.equipamiento.add(nuevo);
		} else {
			System.out.println("El objeto indicado no esta equipado");
		}
	}

	// Arma
	public Arma getArma() {
		return this.arma;
	}
	public void setArma(Arma narma) {
		this.updateEquipamiento(this.arma, narma);
		this.arma = narma;
	}

	// Escudo 
	public Escudo getEscudo() {
		return this.escudo;
	}
	public void setEscudo(Escudo nescudo) {
		this.updateEquipamiento(this.escudo, nescudo);
		this.escudo = nescudo;
	}

	// Tipo
	public Tipo getTipo() {
		return this.tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	// Amigos
	public List<Personaje> getAmigos () {
		return this.amigos;
	}
	public void addAmigo (Personaje p) {
		if (this.amigos.contains(p)) {
			System.out.println(p.getNombre() + " ya es tu amigo");
		} else {
			this.amigos.add(p);
			System.out.println("Amigo anadido");
		}
	}
	public void removeAmigo (Personaje p) {
		if (this.amigos.contains(p)) {
			this.amigos.remove(p);
			System.out.println(p.getNombre() + " se ha eliminado de tu lista de amigos");
		} else {
			System.out.println(p.getNombre() + " no figura en tu lista de amigos");
		}
		
	}
	public void showAmigos () {
		System.out.println("Amigos de " + this.nombre);
		for ( Personaje amigo : this.amigos ) {
			System.out.println("\t" + amigo.getNombre());
		}
	}
	
	// Ciudades: parte 2
	public List<Ciudades> getCiudades () {
		return this.ciudades;
	}
	public void setCiudades (List<Ciudades> ciudades) {
		this.ciudades = ciudades;
	}
	public void addCiudad (Ciudades c) {
		this.ciudades.add(c);
		System.out.println("Se ha anadido una nueva residencia en " + c.getNombre());
	}
	public void removeCiudad(Ciudades c) {
		if (this.ciudades.contains(c)) {
			this.ciudades.remove(c);
			System.out.println(c.getNombre() + " se ha eliminado");
		} else {
			System.out.println("No tienes residencia en" + c.getNombre());
		}
		
	}
	public void setCiudad(Ciudades ciudad) {
		if (this.ciudad == ciudad) {
			System.out.println("Ya resides en esa ciudad");
		} else {
			this.ciudad = ciudad;
			this.ciudades.add(ciudad);
			System.out.println("Se ha anadido una nueva residencia en " + ciudad.getNombre());
		}	
	}
	public void showCiudades () {
		System.out.println("Ciudades de " + this.nombre);
		for ( Ciudades ciudad : this.ciudades ) {
			System.out.println("\t" + ciudad.getNombre());
		}
	}
	
	// Mascotas
	public List<Mascotas> getMascotas () {
		return this.mascotas;
	}
	public void addMascota (Mascotas m) {
		if (this.mascotas.contains(m)) {
			System.out.println("Ya posees esa mascota");
		} else {
			this.mascotas.add(m);
			System.out.println(m.getNombre() + " se ha anadido a la lista de mascotas");
		}
	}
	public void removeMascota (Mascotas m) {
		if (!this.mascotas.contains(m)) {
			System.out.println(m.getNombre() + " no es tu companero");
		} else {
			this.mascotas.remove(m);
			System.out.println(m.getNombre() + " ha sido eliminado de la lista de mascotas");
		}
	}
	public void showMascotas () {
		System.out.println("Mascotas de " + this.getNombre());
		for ( Mascotas m : this.mascotas ) {
			System.out.println("\t" + m.getNombre());
		}
	}
	public void showMascotasDisponibles () {
		System.out.println("Mascotas disponibles:");
		for ( Mascotas m : this.mascotas ) {
			if (m.isAvailable()) {
				System.out.println("\t" + m.getNombre() + ": " + "\u001B[32m" + "Disponible" + "\u001B[37m");
			} else {
				System.out.println("\t" + m.getNombre() + ": " + "\u001B[31m" + "No disponible" + "\u001B[37m");
			}	
		}
	}
	
	// Skills
	public List<Method> getSkills () {
		return this.skills;
	}
	public void addSkill(String methodName) {
		try {
			// Haciendo uso de la metaprogramación
			Method method = Habilidades.class.getMethod(methodName);
			if (this.skills.contains(method)) {
				System.out.println("Ya posees esa habilidad pero nunca viene mal refrescarla un poco!");
			} else {
				this.skills.add(method);
				System.out.println("Habilidad anadida");
			}
		} catch (Exception e) {
			System.out.println("Esa habilidad no esta disponible todavia");
		}
	}
	public int getIndexByName (String name) {
		this.getSkillsMap();
		return this.skillsMap.get(name);
	}
	private Map<String, Integer> getSkillsMap () {
		for (int i = 0; i < this.skills.size(); i++) {
			this.skillsMap.put(this.skills.get(i).getName(), i);
		}
		return this.skillsMap;
	}
	public void runSkill(String methodName) {
		try {
			this.getSkills().get(this.getIndexByName(methodName)).invoke(h);
		} catch (Exception e) {
			System.out.println("Aun no posees esa habilidad");
		}
	}
	public void showSkills () {
		System.out.println("Habilidades de " + this.nombre);
		for ( Method skill : this.skills ) {
			System.out.println("\t" + skill.getName());
		}
	}
	
	// Sociedades
	public List<Sociedades> getSociedades () {
		return this.sociedades;
	}
	public void setSociedades (List<Sociedades> sociedades) {
		this.sociedades = sociedades;
	}
	public void addSociedad(Sociedades s) {
		this.sociedades.add(s);
	}
	public void removeSociedad(Sociedades s) {
		this.sociedades.remove(s);
	}
	public void showSociedades() {
		System.out.println("Sociedades de " + this.nombre);
		for ( Sociedades sociedad : this.sociedades ) {
			System.out.println("\t" + sociedad.getName());
		}
	}
	
	// Métodos 
	@Override
	public String toString() {
		String returnedString = "\nNombre:\t\t" + this.nombre +
				"\nLiga:\t\t" + this.liga +
				"\nTipo:\t\t" + this.tipo +
				"\nHP:\t\t" + this.hp + 
				"\nAtaque:\t\t" + this.ataque +
				"\nAt. esp.:\t" + this.ataquEspecial +
				"\nDefensa:\t" + this.defensa +
				"\nDef. esp.:\t" + this.defensaEspecial +
				"\nResistencia:\t" + this.resistencia +
				"\nVelocidad:\t" + this.velocidad +
				"\nAgresividad:\t" + this.agresividad +
				"\nEmpleo:\t\t" + this.empleoName + 
				"\nExperiencia:\t" + this.experiencia +
				"\nArcano:\t\t" + this.arcano +
				"\nFuerza:\t\t" + this.fuerza
				;
		return returnedString;
	}

	@Override
	public String saluda() {
		return "Hola, soy " + this.getNombre();
	}
	
	public String despidete() {
		return "Nos vemos pronto!";
	}

}
