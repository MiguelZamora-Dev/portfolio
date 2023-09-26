package Main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fiesta {

	private String tipo;
	private LocalDateTime fechaHora;
	private String direccion;
	private int bebidas;
	private int bocadillos;
	private int invitados;
	
	public Fiesta() {
		int dia = 2;
		int mes = 4;
		int anio = 2022;
		int hora = 18;
		int minutos = 30;
		this.setTipo("Generica");
		this.setFechaHora(
				LocalDateTime.of(anio, mes, dia, hora, minutos)
				);
		this.setDireccion("Nuestra direccion");
		this.setBebidas(0);
		this.setBocadillos(0);
		this.setInvitados(0);
	}
	
	public Fiesta(String tipo, LocalDateTime fechaHora, String direccion, 
			int bebidas, int bocadillos) {
		this.setTipo(tipo);
		this.setFechaHora(fechaHora);
		this.setDireccion(direccion);
		this.setBebidas(bebidas);
		this.setBocadillos(bocadillos);
		this.setInvitados(0);
	}
	
	
	public String consulta() {
		
		return "La fiesta de tipo " + this.tipo 
				+ " el dia " 
				+ this.fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ " a las "
				+ this.fechaHora.format(DateTimeFormatter.ofPattern("HH:mm"))
				+ " en " + this.direccion
				+ " tendra " + this.invitados 
				+ " invitados y se compraran "
				+ this.bebidas + " bebidas y "
				+ this.bocadillos + " bocadillos";
	}
	
	@Override
	public String toString() {
		
		return "La fiesta de tipo " + this.tipo 
				+ " el dia " 
				+ this.fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ " a las "
				+ this.fechaHora.format(DateTimeFormatter.ofPattern("HH:mm"))
				+ " en " + this.direccion
				+ " tendra " + this.invitados 
				+ " invitados y se compraran "
				+ this.bebidas + " bebidas y "
				+ this.bocadillos + " bocadillos";
	}
	
	public void invitar() {
		this.invitados++;
	}
	
	public void cancelarInvitacion () {
		this.invitados--;
	}
	
	public double precioFiesta () {
		return 5 * this.invitados + 2 * this.bebidas + 3 * this.bocadillos;
	}

	
	
	
	
	// Getters and setters generados automaticamente 
	// source -> Generate getters and setters
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return the bebidas
	 */
	public int getBebidas() {
		return bebidas;
	}

	/**
	 * @return the bocadillos
	 */
	public int getBocadillos() {
		return bocadillos;
	}

	/**
	 * @return the invitados
	 */
	public int getInvitados() {
		return invitados;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param bebidas the bebidas to set
	 */
	public void setBebidas(int bebidas) {
		this.bebidas = bebidas;
	}

	/**
	 * @param bocadillos the bocadillos to set
	 */
	public void setBocadillos(int bocadillos) {
		this.bocadillos = bocadillos;
	}

	/**
	 * @param invitados the invitados to set
	 */
	public void setInvitados(int invitados) {
		this.invitados = invitados;
	}
	
	
}
