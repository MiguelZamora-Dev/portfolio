package principal;

import java.util.ArrayList;
import java.util.List;

import ciudad.Ciudades;
import combate.Combate;
import empleos.Empleos;
import habilidades.Habilidades;
import mascotas.Mascotas;
import mascotas.gato.Gato;
import mascotas.perro.Perro;
import mascotas.unicornio.Unicornio;
import misiones.Misiones;
import mundo.Mundos;
import mundo.Paises;
import personajes.Personaje;
import personajes.personajeAgua.PersonajeAgua;
import personajes.personajeAire.PersonajeAire;
import personajes.personajeElectrico.PersonajeElectrico;
import personajes.personajeFuego.PersonajeFuego;
import personajes.personajeTierra.PersonajeTierra;
import sociedades.Sociedades;
import equipo.Arma;
import equipo.Escudo;
import equipo.Material;

public class Main {

	public static void main(String[] args) {
		
		// Se han formado equipos de 5 pero se pueden hacer de cualquier número dentro de los 
		// límites del tipo int (hasta 2.147.483.647)
		Personaje p1 = new Personaje("primero");
		Personaje p2 = new Personaje("segundo");
		// Aprovechando el polimorfismo para que se puedan utilizar subclases de Personaje en Combate.combatir()
		PersonajeAgua p3 = new PersonajeAgua("tercero");
		Personaje p4 = new Personaje("cuarto");
		Personaje p5 = new Personaje("quinto");
		Personaje p6 = new Personaje("sexto");
		Personaje p7 = new Personaje("septimo");
		PersonajeFuego p8 = new PersonajeFuego("octavo");
		Personaje p9 = new Personaje("noveno");
		Personaje p10 = new Personaje("decimo");
		List<Personaje> e1 = new ArrayList<Personaje>();
		List<Personaje> e2 = new ArrayList<Personaje>();
		e1.add(p1);
		e1.add(p2);
		e1.add(p3);
		e1.add(p4);
		e1.add(p5);
		e2.add(p6);
		e2.add(p7);
		e2.add(p8);
		e2.add(p9);
		e2.add(p10);

		
		System.out.println("Buscando combate...");
		Combate fight = new Combate(e1, e2);
		fight.combatir();

		
		// PROBAR TODAS LAS FUNCIONALIDADES DE CADA CLASE
		// Sociedades
		Sociedades s = new Sociedades("Mi Sociedad", p1);
		
		System.out.println("Nombre de la sociedad: " + s.getName());
		s.setName("Alcaldia");
		System.out.println("Nombre de la sociedad: " + s.getName());
		System.out.println("Lider de la sociedad: " + s.getLider().getNombre());
		s.setLider(p2);
		System.out.println("Lider de la sociedad: " + s.getLider().getNombre());
		System.out.println("Experiencia de la sociedad: " + s.getXP());
		s.setXP(s.getXP() + 100);
		System.out.println("Experiencia de la sociedad: " + s.getXP());
		System.out.println("Miembros en " + s.getName() + ": " + s.getTeam().size());
		s.addToTeam(p3);
		s.setLider(p3);
		System.out.println("Lider de la sociedad: " + s.getLider().getNombre());
		System.out.println("Miembros en " + s.getName() + ": " + s.getTeam().size());
		System.out.println("Lista de miembros: ");
		s.listarMiembros();
		s.expulsar(p3);
		System.out.println("Nueva lista de miembros: ");
		s.listarMiembros();
		System.out.println("Lider de la sociedad: " + s.getLider().getNombre());
		
		System.out.println("\n");
		
		// Ciudades
		Ciudades c = new Ciudades("Mi ciudad", p1);
		
		System.out.println("Nombre de la ciudad: " + c.getNombre());
		c.setName("Mi Ciudad Renombrada");
		System.out.println("Nombre de la ciudad: " + c.getNombre());
		System.out.println("Alcalde: " + c.getAlcalde().getNombre());
		c.listarCiudadanos();
		// p1 reside en la ciudad: es el alcalde
		c.addCiudadano(p1);
		// p2 y p3 se añaden correctamente a la ciudad
		c.addCiudadano(p2);
		c.addCiudadano(p3);
		c.listarCiudadanos();
		// p10 no pertenece a la ciudad
		c.removeCiudadano(p10);
		// p3 sí pertenece a la ciudad
		c.removeCiudadano(p3);
		c.listarCiudadanos();
		c.listarSociedades();
		Sociedades policia = new Sociedades("Policia", p2);
		c.addSociedad(policia);
		c.listarSociedades();
		// No se puede eliminar la Alcaldia
		c.removeSociedad(s);
		// Las demás sociedades se pueden eliminar
		c.removeSociedad(policia);
		c.listarSociedades();
		System.out.println("Poblacion: " + c.poblacion());
		System.out.println("Sociedades en la ciudad: " + c.numSociedadesEnCiudad());
		
		System.out.println("\n");
		
		// Empleos
		Empleos e = new Empleos();
		e.artista(p10);
		e.comerciante(p8);
		e.daw(p9);
		e.herrero(p2);
		
		System.out.println("\n");
		
		// Habilidades
		Habilidades h = new Habilidades();
		h.amasarPan();
		h.martillear();
		
		
		
		// Probar todas las funcionalidades de Personaje
		System.out.println(p1.saluda());
		p1.addAmigo(p2);
		// Este amigo ya esta anadido
		p1.addAmigo(p2);
		// Este es nuevo
		p1.addAmigo(p3);
		p1.showAmigos();
		System.out.println("Getters de " + p1.getNombre());
		System.out.println(p1.getNombre());
		System.out.println(p1.getLiga());
		System.out.println(p1.getHp());
		System.out.println(p1.getAtaque());
		System.out.println(p1.getAtaquEspecial());
		System.out.println(p1.getDefensa());
		System.out.println(p1.getDefensaEspecial());
		System.out.println(p1.getResistencia());
		System.out.println(p1.getVelocidad());
		System.out.println(p1.getAgresividad());
		System.out.println(p1.getEmpleoObject());
		System.out.println(p1.getEmpleo());
		System.out.println(p1.getCiudad());
		System.out.println(p1.getSociedades());
		System.out.println(p1.isAlive());
		System.out.println(p1.getSkills());
		System.out.println(p1.getAmigos());
		System.out.println(p1.getExperiencia());

		Material material = new Material("Diamante", 150);
		Arma arma = new Arma("Bestiario", material, 200);
		Escudo escudo = new Escudo("Protector", material, 500);
		p1.setArma(arma);
		p1.setEscudo(escudo);
		System.out.println(p1.getArma().getNombre());
		System.out.println(p1.getEscudo().getNombre());

		
		p1.setNombre("First");
		p1.setLiga(Liga.NEUTRAL);
		p1.setHp(100);
		p1.setAtaque(100);
		p1.setAtaquEspecial(100);
		p1.setDefensa(100);
		p1.setDefensaEspecial(100);
		p1.setResistencia(100);
		p1.setVelocidad(100);
		p1.setAgresividad(100);
		p1.setEmpleo("herrero");
		// Aqui surgira el mensaje 'Ya resides en esa ciudad' porque el constructor de la ciudad añade la ciudad al alcalde
		p1.setCiudad(new Ciudades("Ciudad 2", p1));
		System.out.println("Anadir y eliminar sociedades");
		p1.addSociedad(policia);
		p1.showSociedades();
		p1.removeSociedad(policia);
		p1.showSociedades();
		// patinar no es una habilidad todavia
		p1.addSkill("patinar");
		p1.addSkill("martillear");
		p1.runSkill("martillear");
		p1.setExperiencia(20);
		System.out.println("Anadir y eliminar amigos");
		p1.addAmigo(p10);
		p1.showAmigos();
		p1.removeAmigo(p10);
		p1.showAmigos();
		
		System.out.println(p1.toString());
		p1.addAmigo(p10);
		p1.addSociedad(policia);
		p1.showAmigos();
		p1.showSociedades();
		p1.showCiudades();
		p1.showSkills();
		
		System.out.println(p1.despidete());
		
		
		// Probar los métodos de las subclases de cada tipo y comprobar la herencia de su superclase Personaje
		PersonajeFuego fuego = new PersonajeFuego("Llamitas");
		System.out.println(fuego.saluda());
		fuego.aplicarQuemadura();
		fuego.setNombre("Fueguitos");
		System.out.println(fuego.getNombre());
		
		PersonajeAgua agua = new PersonajeAgua("Gotitas");
		System.out.println(agua.saluda());
		agua.aplicarMojado();
		
		PersonajeAire aire = new PersonajeAire("Brisitas");
		System.out.println(aire.saluda());
		aire.aplicarCortes();
		
		PersonajeTierra tierra = new PersonajeTierra("Arenita");
		System.out.println(tierra.saluda());
		tierra.aplicarAplastamiento();
		
		PersonajeElectrico electrico = new PersonajeElectrico("Chispitas");
		System.out.println(electrico.saluda());
		electrico.aplicarParalisis();
		
		// Mascotas
		Gato gato = new Gato("Misifu", p1);
		System.out.println(gato.saluda());
		gato.setNivel(100);
		System.out.println("Nivel de " + gato.getNombre() + ": " + gato.getNivel());
		
		Perro perro = new Perro("Arya", p1);
		System.out.println(perro.saluda());
		
		Unicornio unicornio = new Unicornio("Cuernito", p1);
		System.out.println(unicornio.saluda());
		
		p1.addMascota(gato);
		p1.addMascota(perro);
		p1.addMascota(unicornio);
		// No se puede añadir otra vez porque ya lo tiene el personaje
		p1.addMascota(unicornio);
		p1.showMascotas();
		p1.removeMascota(gato);
		// No se puede quitar esta segunda vez porque no lo tiene el personaje
		p1.removeMascota(gato);
		p1.showMascotas();
		
		System.out.println(gato.saluda());
		System.out.println(gato.toString());
		
		// Misiones
		List<Mascotas> ops = new ArrayList<Mascotas>();
		ops.add(perro);
		p1.showMascotasDisponibles();
		System.out.println(p1.getNombre() + " -> XP: " + p1.getExperiencia());
		Misiones mision = new Misiones("Conseguir comida", 5000, 1, ops);
		mision.start();
		p1.showMascotasDisponibles();
		
		Sociedades as = new Sociedades("deleteable", p2);
		boolean[] res = as.expulsar(p2);
		as.listarMiembros();
		System.out.println(res[0]);
		System.out.println(res[1]);
		if (res[1]) {
			s = null;
			System.out.println("Sociedad eliminada");
		}

		// Crear mundo 
		Sociedades apolicia = new Sociedades("Policia", p2);
		Ciudades ciudad1 = new Ciudades("MiCiudad", p1);
		ciudad1.addSociedad(apolicia);
		ciudad1.addCiudadano(p10);
		Ciudades ciudad2 = new Ciudades("MiCiudad2", p2);
		ciudad2.addSociedad(apolicia);
		List<Ciudades> misciudades = new ArrayList<Ciudades>();
		misciudades.add(ciudad1);
		misciudades.add(ciudad2);
		Paises pais1 = new Paises("MiPais1", misciudades);
		Paises pais2 = new Paises("MiPais2", misciudades);
		List<Paises> mispaises = new ArrayList<Paises>();
		mispaises.add(pais1);
		mispaises.add(pais2);
		Mundos mundo = new Mundos("Tierra", mispaises);
		System.out.println("Ciudadanos");
		mundo.showTreeCiudadanos(0);
		System.out.println("Sociedades");
		mundo.showTreeSociedades(0);




		/*mundo.deleteSelf();
		mundo = null;
		System.out.println(mundo);
		try {
			System.out.println(mundo.getPaises());
			System.out.println(mundo.getPaises().get(0).getCiudades());
		} catch (Exception exception) {
			System.out.println("No se ha podido acceder a esa informacion");
		}*/
		

		/*
		// Para probar equipos de diferentes tamaños. Añadir arriba junto a las demás instancias
		int size = 20;
		List<Personaje> e12 = new ArrayList<Personaje>();
		List<Personaje> e22 = new ArrayList<Personaje>();
		for( int i = 0; i < size; i++) {
			Personaje p12 = new Personaje("p1-" + i);
			e12.add(p12);
		}
		for( int i = 0; i < size; i++) {
			Personaje p22 = new Personaje("p2-" + i);
			e22.add(p22);
		}
		System.out.println(e12.size() + " " + e22.size());
		Combate fight = new Combate(e12, e22);
		fight.combatir();
		*/
	}

}
