package misiones;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mascotas.Mascotas;


class VueltaMision extends TimerTask {

	private Timer timer;
	private Misiones mision;
	private List<Mascotas> operadores;
	
	public VueltaMision(Timer timer, List<Mascotas> operadores, Misiones mision) {
		this.timer = timer;
		this.operadores = operadores;
		this.mision = mision;
	}
	
	@Override
	public void run() {
		int deltaXP;
		for ( int i = 0; i < this.operadores.size(); i++ ) {
			System.out.println( this.operadores.get(i).getNombre() + " ha vuelto de la mision");
			this.operadores.get(i).setAvailable(true);
		}
		deltaXP = this.mision.getDificultad() * 10 + (int)Math.round(this.mision.getTiempoMision() / 100);
		System.out.println("\t" + this.operadores.get(0).getCompanero().getNombre());
		System.out.println("Exp.: +" + deltaXP);
		this.operadores.get(0).getCompanero().setExperiencia(deltaXP);
		System.out.println("Exp.: " + this.operadores.get(0).getCompanero().getExperiencia());
		this.timer.cancel();
	}
}

public class Misiones {

	private String tituloOperacion;
	private int tiempoMision;
	private int dificultad;
	private List<Mascotas> operadores = new ArrayList<Mascotas>();
	private Mascotas[] disponiblePara;
	
	public Misiones (String to, int tm, int dificultad, List<Mascotas> operadores) {
		this.tituloOperacion = to;
		this.tiempoMision = tm;
		this.dificultad = dificultad;
		this.operadores = operadores;
	}

	// Titulo Operacion
	public String getTituloOperacion() {
		return this.tituloOperacion;
	}
	public void setTituloOperacion(String tituloOperacion) {
		this.tituloOperacion = tituloOperacion;
	}
	
	// Tiempo de misión
	public int getTiempoMision() {
		return this.tiempoMision;
	}
	public void setTiempoMision(int tiempoMision) {
		this.tiempoMision = tiempoMision;
	}

	// Operadores
	public List<Mascotas> getOperadores() {
		return this.operadores;
	}
	public void setOperadores(List<Mascotas> operadores) {
		this.operadores = operadores;
	}

	// Disponibilidad
	public Mascotas[] getDisponiblePara() {
		return this.disponiblePara;
	}
	public void setDisponiblePara(Mascotas[] disponiblePara) {
		this.disponiblePara = disponiblePara;
	}

	// Dificultad
	public int getDificultad() {
		return this.dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public void start() {
		Timer timer = new Timer();
		VueltaMision vm = new VueltaMision(timer, this.operadores, this);
		timer.schedule(vm, this.tiempoMision);
		for ( int i = 0; i < this.operadores.size(); i++) {	
			this.operadores.get(i).setAvailable(false);
			System.out.println(this.operadores.get(i).getNombre() + " ha comenzado la mision " + this.tituloOperacion);
		}
		
	}
	
	

}
