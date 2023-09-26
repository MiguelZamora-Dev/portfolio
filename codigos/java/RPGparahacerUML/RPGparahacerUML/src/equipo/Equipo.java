package equipo;

public abstract class Equipo {
    private String nombre;
    private Material material;
    private int plus;

    public Equipo (String nombre, Material material, int plus) {
        this.nombre = nombre;
        this.material = material;
        this.plus = plus;
    }

    // getters & setters
    public String getNombre () {
        return this.nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public Material getMaterial () {
        return this.material;
    }
    public void setMaterial (Material material) {
        this.material = material;
    }
    public int getPlus () {
        return this.plus;
    }
    public void setPlus (int plus) {
        this.plus = plus;
    }
}

