package combate;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import personajes.Personaje;


public class Combate {

	Scanner scanner = new Scanner(System.in);
	private List<Personaje> e1;
	private List<Personaje> e2;
	private boolean isE1Alive = true;
	private boolean isE2Alive = true;
	private List<Personaje> pe1 = new ArrayList<Personaje>();
	private List<Personaje> pe2 = new ArrayList<Personaje>();
	// Como e1 y pe1 se refieren al mismo objeto, guardo los hp en otras dos listas
	private List<Integer> hpe1 = new ArrayList<Integer>();
	private List<Integer> hpe2 = new ArrayList<Integer>();
	private Map<String, Integer> killsMap1 = new HashMap<String, Integer>();
	private Map<String, Integer> killsMap2 = new HashMap<String, Integer>();
	private int plusKill = 100;
	private int plusNivel = 50;
	
	public Combate(List<Personaje> e1, List<Personaje> e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	// Esta método permite elegir entre los modos de juego y llama al método correspondiente
	public List<Personaje> combatir() {
		List<Personaje> eganador = null;
		
		int modoJuego = 0;	
		
		for ( int i = 0; i < this.e1.size(); i++) {
			this.killsMap1.put(this.e1.get(i).getNombre(), 0);
			this.killsMap2.put(this.e2.get(i).getNombre(), 0);
		}
		
		
		while (!(modoJuego > 0 && modoJuego < 3)) {
			System.out.println("Modo de juego:\n1. Simulacion combate\n2. Contra la IA");
			modoJuego = scanner.nextInt();
		}

		// Aunque los métodos simulacionCombate y combateContraIA son muy similares he decidido hacerlos 
		// por separado para que en un futuro puedan ser modificados más cómodamente y se pueda añadir 
		// una mejor estrategia de ataque
		switch (modoJuego) {
			case 1:
				System.out.println("Simulacion lista para comenzar");
				eganador = simulacionCombate();
				break;
			case 2:
				System.out.println("IA lista para comenzar");
				eganador = combateContraIA();
				break;
		}
		
		return eganador;
	}
	
	// Este método simula el combate. No requiere ninguna acción
	private List<Personaje> simulacionCombate () {
		List<Personaje> eganador = null;
		boolean turno = true;
		int ie1 = 0, ie2 = 0;
		Personaje atacado;
		Personaje masAgresivo = this.e1.get(0);
		
		System.out.println("\nSalud equipo 1: ");
		for ( int j = 0; j < this.e1.size(); j++) {
			System.out.println(this.e1.get(j).getNombre() + " HP: " + this.e1.get(j).getHp());
			// Guardar la vida inicial de cada jugador
			this.hpe1.add(this.e1.get(j).getHp());
			// Guardar una lista auxiliar de los jugadores que permanecerá intacta hasta el final
			this.pe1.add(this.e1.get(j));
			// Comprobar quién es el más agresivo para que empiece el combate
			if ( this.e1.get(j).getAgresividad() > masAgresivo.getAgresividad() ) {
				masAgresivo = this.e1.get(j);
			}
		}
		
		System.out.println("Salud equipo 2: ");
		for ( int j = 0; j < this.e2.size(); j++) {
			System.out.println(this.e2.get(j).getNombre() + " HP: " + this.e2.get(j).getHp());
			this.hpe2.add(this.e2.get(j).getHp());
			this.pe2.add(this.e2.get(j));
			if ( this.e2.get(j).getAgresividad() > masAgresivo.getAgresividad() ) {
				masAgresivo = this.e2.get(j);
			}
		}
		System.out.println();
		
		// Si el equipo 1 no posee al jugador con mas agresividad empieza el equipo contrario
		// Si lo contiene se mantiene el valor con el que se inicializó
		if (!this.e1.contains(masAgresivo)) {
			turno = false;
		}
		
		System.out.println("Jugador mas agresivo: " + masAgresivo.getNombre());
		
		while (this.isE1Alive && this.isE2Alive) {

			if ( ie1 == e1.size() ) {
				ie1 = 0;
			}
			
			if ( ie2 == e2.size() ) {
				ie2 = 0;
			}
			
			// Se  realiza el ataque en funcion del turno que sea
			if(turno) {
				// atacante - defensor
				atacado = e2.get(ie2);
				ataque(e1.get(ie1), atacado);
				// Si ha caido el atacado se comprueba el estado del equipo
				if ( !e2.get(ie2).isAlive() ) {
					this.e2.remove(e2.get(ie2));
					this.killsMap1.put(
							this.e1.get(ie1).getNombre(), 
							this.killsMap1.get(this.e1.get(ie1).getNombre()) + 1);
					this.isE2Alive = false;
					if (this.e2.size() > 0) {
						this.isE2Alive = true;
					}
				}
				// Si el equipo rival ha sido vencido se finaliza el combate
				if (!this.isE2Alive) {
					System.out.println("Gana el equipo 1");
					eganador = this.e1;
					this.recuentoKills();
					this.otorgarExperiencia(this.pe1, this.pe2);
					this.restaurarSalud();
				}
				ie1++;			
				
			} else {
				atacado = e1.get(ie1);
				ataque(e2.get(ie2), atacado);
				if ( !e1.get(ie1).isAlive() ) {
					this.e1.remove(e1.get(ie1));
					this.killsMap2.put(
							this.e2.get(ie2).getNombre(), 
							this.killsMap2.get(this.e2.get(ie2).getNombre()) + 1);
					this.isE1Alive = false;
					if (this.e1.size() > 0) {
						this.isE1Alive = true;
					}
				}
				if (!this.isE1Alive) {
					System.out.println("Gana el equipo 2");
					eganador = this.e2;
					this.recuentoKills();
					this.otorgarExperiencia(this.pe2, this.pe1);
					this.restaurarSalud();
				}
				ie2++;	
			}
			
			turno = !turno;

		}
		return eganador;
	}
	
	// Este método te permite pelear como el primer miembro del equipo 1 contra la máquina
	// No es una IA pero es automático. Se requiere indicar a quién atacar mientras se esté vivo
	private List<Personaje> combateContraIA () {
		List<Personaje> eganador = null;
		boolean turno = true;
		int ie1 = 0, ie2 = 0;
		int indAtacado = 0;
		Personaje atacado;
		Personaje jugador = this.e1.get(0);
		Personaje masAgresivo = this.e1.get(0);
		
		System.out.println("\nSalud equipo 1: ");
		for ( int j = 0; j < this.e1.size(); j++) {
			System.out.println(this.e1.get(j).getNombre() + " HP: " + this.e1.get(j).getHp());
			this.hpe1.add(this.e1.get(j).getHp());
			this.pe1.add(this.e1.get(j));
			if ( this.e1.get(j).getAgresividad() > masAgresivo.getAgresividad() ) {
				masAgresivo = this.e1.get(j);
			}
		}
		
		System.out.println("Salud equipo 2: ");
		for ( int j = 0; j < this.e2.size(); j++) {
			System.out.println(this.e2.get(j).getNombre() + " HP: " + this.e2.get(j).getHp());
			this.hpe2.add(this.e2.get(j).getHp());
			this.pe2.add(this.e2.get(j));
			if ( this.e2.get(j).getAgresividad() > masAgresivo.getAgresividad() ) {
				masAgresivo = this.e2.get(j);
			}
		}
		System.out.println();
		
		if (!this.e1.contains(masAgresivo)) {
			turno = false;
		}
		
		while (this.isE1Alive && this.isE2Alive) {

			if ( ie1 == this.e1.size() ) {
				ie1 = 0;
			}
			
			if ( ie2 == this.e2.size() ) {
				ie2 = 0;
			}
			
			// Se  realiza el ataque en funcion del turno que sea
			if(turno) {
				// atacante - defensor

				if ( ie1 == 0 && jugador.isAlive()) {
					System.out.println("Tu turno");
					while (!(indAtacado > 0 && indAtacado <= this.e2.size())) {
						System.out.println("A cual deseas atacar: ");
						for ( int i = 0; i < this.e2.size(); i++) {
							System.out.println(i+1 + ". " + this.e2.get(i).getNombre() + " : " + this.e2.get(i).getHp());
						}
						indAtacado = scanner.nextInt();
					}
					atacado = this.e2.get(indAtacado - 1);
					indAtacado = 0;
				} else {
					atacado = this.e2.get((int)(Math.random()*this.e2.size()));
				}
				
				ataque(this.e1.get(ie1), atacado);
				// Si ha caido el atacado se comprueba el estado del equipo
				if ( !atacado.isAlive() ) {
					this.e2.remove(atacado);
					this.killsMap1.put(
							this.e1.get(ie1).getNombre(), 
							this.killsMap1.get(this.e1.get(ie1).getNombre()) + 1);
					this.isE2Alive = false;
					if (this.e2.size() > 0) {
						this.isE2Alive = true;
					}
				}
				// Si el equipo rival ha sido vencido se finaliza el combate
				if (!this.isE2Alive) {
					System.out.println("Gana el equipo 1");
					eganador = this.e1;
					this.recuentoKills();
					this.otorgarExperiencia(this.pe1, this.pe2);
					this.restaurarSalud();
				}
				ie1++;			
				
			} else {
				
				atacado = this.e1.get((int)(Math.random()*this.e1.size()));
				ataque(e2.get(ie2), atacado);
				if ( !atacado.isAlive() ) {
					this.e1.remove(atacado);
					this.killsMap2.put(
							this.e2.get(ie2).getNombre(), 
							this.killsMap2.get(this.e2.get(ie2).getNombre()) + 1);
					this.isE1Alive = false;
					if (this.e1.size() > 0) {
						this.isE1Alive = true;
					}
				}
				if (!this.isE1Alive) {
					System.out.println("Gana el equipo 2");
					eganador = this.e2;
					this.recuentoKills();
					this.otorgarExperiencia(this.pe2, this.pe1);
					this.restaurarSalud();
				}
				ie2++;	
			}
			
			turno = !turno;

		}
		return eganador;
	}
	
	// Ejecutar cada ataque del combate
	private void ataque(Personaje p1, Personaje p2) {
		int ataque = Math.round((int)Math.round((p1.getAtaque() + p1.getFuerza() + p1.getArcano()) * 0.3 ));
		if (p1.getArma() != null) {
			ataque = Math.round((int)Math.round((p1.getAtaque() + p1.getFuerza() + p1.getArcano()) * 0.3 + p1.getArma().getPlus()));
		}
		int defensa = Math.round((int)Math.round((p2.getDefensa() + p2.getFuerza() + p2.getArcano()) * 0.3));
		if (p1.getEscudo() != null) {
			defensa = Math.round((int)Math.round((p2.getDefensa() + p2.getFuerza() + p2.getArcano()) * 0.3 + p2.getEscudo().getPlus()));
		}
		int danioRecibido = algoritmoDanio(p1, p2, ataque, defensa);
		System.out.println(p1.getNombre()  + " inflige " + danioRecibido + " a " + p2.getNombre());
		System.out.println("Antes:\t\t" + p2.getNombre() + " HP: " + p2.getHp());
		p2.setHp( p2.getHp() - danioRecibido );
		System.out.println("\033[33m" + "Despues:\t" + p2.getNombre() + " HP: " + p2.getHp() + "\033[37m");
		System.out.println();
	}
	
	// Algoritmo que devuelve el daño que recibe el atacado
	private int algoritmoDanio (Personaje p1, Personaje p2, int ataque, int defensa) {
		int danio, totalAtaque, totalDefensa;
		double multiplicadorTipo = this.multiplicadorTipo(p1.getTipo().toString().toLowerCase(), p2.getTipo().toString().toLowerCase());
		int critico = this.critico(p1);
		int defensaCritica = this.defensaCritica(p2);
		System.out.println("Multiplicador dano: " + multiplicadorTipo);
		// por definir un mejor algoritmo
		totalAtaque = (int)Math.round(ataque * multiplicadorTipo) + critico;
		totalDefensa = (int)Math.round(defensa * (2 - multiplicadorTipo)) + defensaCritica;
		if( totalAtaque <= totalDefensa ) {
			danio = (int)Math.round( totalAtaque * 0.2 );
		} else {
			danio = (int)Math.abs( totalAtaque - totalDefensa );
		}
		return danio;
	}
	
	// Hay critico cada cierto tiempo. 
	private int critico (Personaje p) {
		int critico = 0;
		if ( Math.random() > 0.95 ) {
			critico = p.getAtaquEspecial();
			System.out.println("Ataque critico!");
		}
		return critico;
	}
	
	// Hay defensa especial cada cierto tiempo
	private int defensaCritica(Personaje p) {
		int defCritica = 0;
		if ( Math.random() > 0.95 ) {
			defCritica = p.getDefensaEspecial();
			System.out.println("Se uso un escudo especial!");
		}
		return defCritica;
	}
	
	// Devuelve el multiplicador por tipo del atacante y defensor
	private double multiplicadorTipo (String tipoAtacante, String tipoDefensor) {
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		dict.put("fuego", 0);
		dict.put("agua", 1);
		dict.put("tierra", 2);
		dict.put("aire", 3);
		dict.put("electrico", 4);
		double[][] matrizDanio = {
				{ 1, 1.25, 0.75, 0.75, 1 },
				{ 0.75, 1, 1.25, 1, 1.25 },
				{ 1.25, 0.75, 1, 0.75, 0.75 },
				{ 1.25, 1, 1.25, 1, 0.75 },
				{ 1, 0.75, 1.25, 1.25, 1 },
		};
		
		return matrizDanio[dict.get(tipoDefensor)][dict.get(tipoAtacante)];
	}
	
	// Suma XP a los jugadores en función de su participación en el combate
	private void otorgarExperiencia (List<Personaje> ganadores, List<Personaje> perdedores) {
		
		int expMediaGanadores = 0;
		int expMediaPerdedores = 0;
		
		// Experiencia media ganadores 
		for ( int i = 0; i < ganadores.size(); i++) {
			expMediaGanadores += ganadores.get(i).getExperiencia();
		}
		expMediaGanadores /= ganadores.size();
		
		// Experiencia media perdedores 
		for ( int i = 0; i < perdedores.size(); i++) {
			expMediaPerdedores += perdedores.get(i).getExperiencia();
		}
		expMediaPerdedores /= perdedores.size();
		
		System.out.println("Ganadores: ");
		for ( int i = 0; i < ganadores.size(); i++) {
			System.out.println("\t" + ganadores.get(i).getNombre());
			ganadores.get(i).setExperiencia( 
					ganadores.get(i).getExperiencia() +
					algoritmoExperiencia(ganadores.get(i).isAlive(), expMediaGanadores, expMediaPerdedores, ganadores.get(i).getNombre())
					);
			System.out.println("Exp.: " + ganadores.get(i).getExperiencia());
			System.out.println("Proximo nivel en: " + ganadores.get(i).getNextExperiencia());
			System.out.println("Faltan " 
					+ (ganadores.get(i).getNextExperiencia() - ganadores.get(i).getExperiencia()) 
					+ " XP para el proximo nivel\n");
		}
		
		System.out.println("Perdedores: ");
		for ( int i = 0; i < perdedores.size(); i++) {
			System.out.println("\t" + perdedores.get(i).getNombre());
			perdedores.get(i).setExperiencia(  
					perdedores.get(i).getExperiencia() +
					algoritmoExperiencia(expMediaGanadores, expMediaPerdedores, perdedores.get(i).getNombre())
					);
			System.out.println("Exp.: " + perdedores.get(i).getExperiencia());
			System.out.println("Proximo nivel en: " + perdedores.get(i).getNextExperiencia());
			System.out.println("Faltan " 
					+ (perdedores.get(i).getNextExperiencia() - perdedores.get(i).getExperiencia()) 
					+ " XP para el proximo nivel\n");
		}
	}
	
	// Algoritmo para calcular cuántos puntos le corresponde a cada jugador del equipo ganador
	private int algoritmoExperiencia (boolean alive, int expMediaGanadores, int expMediaPerdedores, String nombre) {
		int exp = 25;
		if ( expMediaGanadores < expMediaPerdedores ) {
			this.plusNivel += expMediaPerdedores - expMediaGanadores;
		}
		if (this.killsMap1.keySet().contains(nombre) || this.killsMap2.keySet().contains(nombre)) {
			// Es una gestion de la excepcion por no contener el nombre en el diccionario. 
			// Si no está en un uno, está necesariamente en el otro, porque ya se ha comprobado que está en uno de los dos
			try {
				exp += this.plusKill * this.killsMap1.get(nombre);
			} catch (Exception e) {
				exp += this.plusKill * this.killsMap2.get(nombre);
			}
		}
		if (alive) {
			exp += (this.plusNivel * 2);
		} else {
			exp += this.plusNivel;
		}
		System.out.println("Exp.: +" + exp);
		return exp;
	}
	
	// Método sobrecargado. Algoritmo para calcular cuántos puntos le corresponde a cada jugador del equipo perdedor
	private int algoritmoExperiencia (int expMediaGanadores, int expMediaPerdedores, String nombre) {
		int exp = 25;
		if ( expMediaGanadores > expMediaPerdedores ) {
			this.plusNivel += expMediaGanadores - expMediaPerdedores;
			exp += this.plusNivel; 
		}
		if (this.killsMap1.keySet().contains(nombre) || this.killsMap2.keySet().contains(nombre)) {
			try {
				exp += this.plusKill * this.killsMap1.get(nombre);
			} catch (Exception e) {
				exp += this.plusKill * this.killsMap2.get(nombre);
			}
		}
		System.out.println("Exp.: +" + exp);
		return exp;
	}
	
	// Le devuelve los HP iniciales a todos los participantes
	private void restaurarSalud () {
		for ( int j = 0; j < this.pe1.size(); j++) {
			this.pe1.get(j).setHp(this.hpe1.get(j));
			System.out.println(this.pe1.get(j).getNombre() + " ->\tHP: " + this.pe1.get(j).getHp());
		}
		System.out.println("Salud del equipo 1 restaurada");
		
		for ( int j = 0; j < this.pe2.size(); j++) {
			this.pe2.get(j).setHp(this.hpe2.get(j));
			System.out.println(this.pe2.get(j).getNombre() + " ->\tHP: " + this.pe2.get(j).getHp());
		}
		System.out.println("Salud del equipo 2 restaurada");
	}
	
	// Lista las kills de los participantes 
	private void recuentoKills () {
		System.out.println("Recuento de kills: ");
		for ( int k = 0; k < this.killsMap1.values().size(); k++) {
			System.out.println(this.pe1.get(k).getNombre() + ": " + this.killsMap1.get(this.pe1.get(k).getNombre()));
		}
		for ( int k = 0; k < this.killsMap2.values().size(); k++) {
			System.out.println(this.pe2.get(k).getNombre() + ": " + this.killsMap2.get(this.pe2.get(k).getNombre()));
		}
	}
}
