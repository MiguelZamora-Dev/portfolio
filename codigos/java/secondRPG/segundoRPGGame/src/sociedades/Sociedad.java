package sociedades;

import java.util.List;

import personajes.Personaje;

public interface Sociedad {
	public String getName();
	public Personaje getLider();
	public List<Personaje> getTeam();
	public int getXP();
	public int getNivel();

	public void setName(String name);
	public void setLider(Personaje lider);
	public void addToTeam(Personaje p);
	public void setXP(int xp);
	public void setNivel(int nivel);
	
	public void aceptar(Personaje p);
	public void invitar(Personaje p);
	public void listarMiembros();
	public boolean[] expulsar(Personaje p);
}
