package equipo;

public class Material {
    private String nombre;
    private int resistencia;
    private boolean isEnchanted;

    public Material(String nombre, int resistencia) {
        this.nombre = nombre;
        this.resistencia = resistencia;
    }

    // getters & setters
    public String getNombre () {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getResistencia () {
        return this.resistencia;
    }
    public void setResistencia (int resistencia) {
        this.resistencia = resistencia;
    }
    public boolean isEnchanted () {
        return this.isEnchanted;
    }
    public void setEnchanted (boolean enchanted) {
        this.isEnchanted = enchanted;
    }
}
