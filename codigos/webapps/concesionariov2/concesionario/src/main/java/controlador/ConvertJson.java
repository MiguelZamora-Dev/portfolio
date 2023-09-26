package controlador;

import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Vehiculo;

public class ConvertJson {
	
	/**
	 * Este método devuelve un string correspondiente a la apertura de llaves de un json
	 * @param texto parámetro opcional por si se desea añadir un texto después de la llave
	 * @return string con llave de apertura
	 */
	public String abrirLlave (String texto) {
		String returnable = "{";
		if (texto.length()>0) {
			returnable += texto;
		}
		return returnable;
	}
	
	/**
	 * Este método devuelve un string correspondiente a la llave de cierre de un json
	 * @param texto parámetro opcional por si se desea añadir un texto antes de la llave
	 * @return string con llave de cierre
	 */
	public String cerrarLlave (String texto) {
		String returnable = "}";
		if (texto.length()>0) {
			returnable = texto + returnable;
		}
		return returnable;
	}
	
	/**
	 * Este método convierte un objeto de tipo Cliente a formato JSON 
	 * @param cli objeto de tipo Cliente
	 * @return string con los datos del objeto del tipo del parámetro sin las llaves de apertura ni cierre
	 */
	public String convertCliToJson (Cliente cli) {
    	String returnable = "'nombre': '" + cli.getNombreCompleto() + "'"
    	+ ", 'email': '" + cli.getEmail() + "'"
    	+ ", 'telefono': " + cli.getTelefono()
    	+ ", 'psw': '" + cli.getPsw() + "'"
    	+ ", 'usuario': '" + cli.getUsuario() + "'";
    	return returnable;
    }
    
	/**
	 * Este método convierte un objeto de tipo Cita a formato JSON 
	 * @param cita objeto de tipo Cita
	 * @return string con los datos del objeto del tipo del parámetro sin las llaves de apertura ni cierre
	 */
    public String convertCitaToJson (Cita cita) {
    	String returnable = "'fecha': '" + cita.getFecha() + "'";
    	return returnable;
    }
    
    /**
	 * Este método convierte un objeto de tipo Vehiculo a formato JSON 
	 * @param ve objeto de tipo Vehiculo
	 * @return string con los datos del objeto del tipo del parámetro sin las llaves de apertura ni cierre
	 */
    public String convertVehiculoToJson (Vehiculo ve) {
    	String returnable = "'modelo': '" + ve.getModelo() + "'"
    	+ ", 'matricula': '" + ve.getMatricula() + "'"
    	+ ", 'precio': " + ve.getPrecio()
    	+ ", 'color': '" + ve.getColor() + "'"
    	+ ", 'caballos': " + ve.getCaballos()
    	+ ", 'capacidad': " + ve.getCapacidadMaletero()
    	+ ", 'puertas': " + ve.getPuertas();
    	return returnable;
    }
    
    /**
     * Este método convierte los objetos de tipo Cliente, Cita y Vehiculo a formato JSON 
     * @param cli objeto de tipo Cliente
     * @param ci objeto de tipo Cita
     * @param ve objeto de tipo Vehiculo
     * @return string con los datos del objeto del tipo del parámetro CON las llaves de apertura y cierre
     */
    public String convertCuentaToJson (Cliente cli, Cita ci, Vehiculo ve) {
    	String returnable;
    	returnable = this.abrirLlave("") 
    			+ this.convertCliToJson(cli)
    			+ ", "
    			+ this.convertCitaToJson(ci)
    			+ ", "
    			+ this.convertVehiculoToJson(ve)
    			+ this.cerrarLlave("");
    	System.out.println(returnable);
    	return returnable;
    }
    
    
    /**
     * Este método convierte un objeto del tipo Empleado a JSON
     * @param emp objeto del tipo Empleado
     * @return string con los datos del objeto del tipo del parámetro sin las llaves de apertura ni cierre
     */
    public String convertEmpToJson (Empleado emp) {
    	String returnable = "'nombre': '" + emp.getNombreCompleto() + "'"
    	    	+ ", 'email': '" + emp.getEmail() + "'"
    	    	+ ", 'telefono': " + emp.getTelefono()
    	    	+ ", 'puesto': '" + emp.getPuesto() + "'"
    	    	+ ", 'departamento': '" + emp.getDepartamento().getNombre()  + "'"
    	    	+ ", 'sueldo': " + emp.getSueldo()
    	    	+ ", 'usuario': '" + emp.getUsuario() + "'";
    	return returnable;
    }
    
    /** Este método convierte un objeto de tipo Empleado a formato JSON 
     * @param emp objeto del tipo Empleado
     * @return string con los datos del objeto del tipo del parámetro CON las llaves de apertura y cierre
     */
    public String convertCuentaToJson (Empleado emp) {
    	String returnable;
    	
    	returnable = this.abrirLlave("") 
    			+ this.convertEmpToJson(emp)
    			+ this.cerrarLlave("");
    	
    	return returnable;
    }
}
