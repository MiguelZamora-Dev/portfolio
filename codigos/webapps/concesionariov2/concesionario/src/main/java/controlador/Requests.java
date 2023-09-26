package controlador;

import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Vehiculo;
import modelo.Ataque;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class Requests
 */
@WebServlet("/Requests")
public class Requests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IntroducirDBDAO cdao;
	private RecuperarDBDAO rdao;
	private ActualizarDBDAO udao;
	private BorrarDBDAO ddao;
	private ConvertJson conJSON;
	private Cliente cli;
	private Empleado emp;
	private HttpSession session;
	private String usuario;
	private boolean isCookiesAcepted;
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public Requests() throws SQLException {
        super();
        this.cdao = new IntroducirDBDAO();
        this.rdao = new RecuperarDBDAO();
        this.udao = new ActualizarDBDAO();
        this.ddao = new BorrarDBDAO();
        this.conJSON = new ConvertJson();
        this.cli = new Cliente("sdfan", "nomrbeesd", 1524852, "nacsnacoino", "a");
        this.emp = new Empleado();
        }
 
    /**
     * Método que recupera los datos de la cuenta del cliente de la base de datos y los devuelve al frontend
     * @param response permite enviar la información al frontend
     * @throws IOException
     */
    private void cargarCuenta (HttpServletResponse response) throws IOException {

		System.out.println("Cargando cuenta en CClM");
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if (this.session.getAttribute("usuario")!=null) {
			try {
				Cliente cli = this.rdao.getClienteFromDB((String)this.session.getAttribute("usuario"));
				Cita ci = this.rdao.getCitaFromDBByCli(cli.getId());
				Vehiculo ve = this.rdao.getVehiculoFromDBByCli(cli.getId());
				out.print(this.conJSON.convertCuentaToJson(cli, ci, ve));
				out.flush();
			} catch (Exception e) {
				System.out.println("No se han podido recuperar los datos del cliente");
			}
		} else {
			out.print("./iniciarSesion.html");
			out.flush();
		}
		
    }
    
    
    /**
     * Método que permite editar la información de la cuenta del cliente
     */
    private void editarDatos () {
    	System.out.println("cuenta de cliente");
		ActualizarDBDAO act = new ActualizarDBDAO();
		try {
			act.actualizarCliente(new Cliente(), new Cliente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Método que permite iniciar sesión. Coteja los datos introducidos con la base de datos
     * @param request permite obtener la información enviada desde el frontend
     * @param response permite enviar la información al frontend
     * @throws IOException
     */
    private void iniciarSesion (HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("Inicio de sesion");
    	PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
				
		
		System.out.println("Sesion en ISM: " + this.session.getAttribute("usuario"));

		
    	if (this.session.getAttribute("usuario")==null) {
    		String usuario = request.getParameter("inicio-sesion-usuario");
    	    String password = request.getParameter("inicio-sesion-password");
    	    
    	    try {
    	    	cli = this.rdao.getClienteFromDB(usuario, password);
    	    } catch (SQLException e1) {
    	    	e1.printStackTrace();
    	    }
    	    
    	    try {
    	    	emp = this.rdao.getEmpleadoFromDB(usuario, password);
    	    } catch (SQLException e1) {
    	    	e1.printStackTrace();
    	    }
    	    
    		if (cli.getUsuario()==null && emp.getUsuario()==null) {
    			out.print("./iniciarSesion.html");
    			out.flush();
    			//response.sendRedirect("./iniciarSesion.html");
    		} else if (cli.getUsuario()!=null) {
    			this.session.setAttribute("usuario", usuario);
    			out.print("./cuenta.html");
    			out.flush();
    			//response.sendRedirect("./cuenta.html");
    		} else if (emp.getUsuario()!=null) {
    			this.session.setAttribute("usuario", usuario);
    			out.print("./fichaEmpleado.html");
    			out.flush();
    			//response.sendRedirect("./indexPrivado.html");
    		} 
    	} else {
    		out.print("./cuenta.html");
    		out.flush();
    	}
	         	
		
    }
    
    /**
     * Deprecated
     * Método que permite iniciar sesión en la parte privada de la aplicación. Coteja los datos con la base de datos
     * @param response permite enviar información al frontend
     * @throws IOException
     */
    private void iniciarSesionPrivado (HttpServletResponse response) throws IOException {
    	System.out.println("Inicio de sesion privado");
    	PrintWriter out = response.getWriter();
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	
		if (this.session.getAttribute("usuario")==null) {
			out.print("./iniciarSesion.html");
			out.flush();
		}
		
    }
    
    /**
     * Método que permite registrar un empleado en la base de datos
     * @param request obtiene los datos del frontend
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void registrarEmpleado (HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("registro de empleado");
		int existe = 0;
		String usuario = request.getParameter("reg-usuario-emp");
		String nombre = request.getParameter("reg-nombre-emp");
		int telefono = Integer.parseInt(request.getParameter("reg-telefono-emp"));
		String email = request.getParameter("reg-email-emp");
		String departamento = request.getParameter("reg-dpt-emp");
		String puesto = request.getParameter("reg-puesto-emp");
		double sueldo = Double.parseDouble(request.getParameter("reg-sueldo-emp"));
		String password = request.getParameter("reg-psw-emp");
		String reppsw = request.getParameter("reg-rep-psw-emp");
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if (password.equals(reppsw)) {
			emp.setUsuario(usuario);
			emp.setNombreCompleto(nombre);
			emp.setTelefono(telefono);
			emp.setEmail(email);
			try {
				emp.setDepartamento(departamento);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			emp.setPuesto(puesto);
			emp.setSueldo(sueldo);
			emp.setPsw(password);
			
			try {
				existe = this.cdao.insertarEmpleado(emp);
				System.out.println(existe);
				if (existe == 1) {
					out.print("./registroEmpleado.html");
					out.flush();
				} else {
					this.session.setAttribute("usuario", usuario);
					out.print("./cuenta.html");
					out.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    /**
     * Método que permite registrar un cliente
     * @param request obtiene los datos del frontend
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void registrarCliente (HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("registro de cliente");
		int existe = 0;
		String usuario = request.getParameter("reg-usuario");
		String nombre = request.getParameter("reg-nombre");
		int telefono = Integer.parseInt(request.getParameter("reg-telefono"));
		String email = request.getParameter("reg-email");
		String password = request.getParameter("reg-psw");
		String reppsw = request.getParameter("reg-rep-psw");
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if (password.equals(reppsw)) {
			cli.setUsuario(usuario);
			cli.setNombreCompleto(nombre);
			cli.setTelefono(telefono);
			cli.setEmail(email);
			cli.setPsw(password);
			
			try {
				existe = this.cdao.insertarCliente(cli);
				if (existe == 1) {
					out.print("./registroCliente.html");
					out.flush();
				} else {
					this.session.setAttribute("usuario", usuario);
					out.print("./cuenta.html");
					out.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    /**
     * Método que recupera un empleado de la base de datos
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void recuperarEmp (HttpServletResponse response) throws IOException {
    	System.out.println("Recuperando empleado de DB");
    		
	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    if (this.session.getAttribute("usuario")!=null) {
	    	out.print(this.conJSON.convertCuentaToJson(emp));
	    	out.flush();
	    	System.out.println(this.conJSON.convertCuentaToJson(emp));
	    } else {
	    	out.print("./iniciarSesion.html");
	    	out.flush();
	    }

    }
    
    /**
     * Método que recupera la información de un vehículo seleccionado para mostrarlo por pantalla 
     * @param request obtiene los datos del frontend
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void seleccionarVehiculo (HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("Seleccion de modelo");
    	PrintWriter out = response.getWriter();
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	
    	System.out.println(request.getParameter("modelo"));
    	
    	try {
			out.print("./jsons/vehiculos/" + request.getParameter("modelo") + ".json");
			out.flush();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Método que redirige a la página de inicio de sesión si no se ha iniciado sesión en una zona de la app en la que se requiere
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void obligarIniciarSesion (HttpServletResponse response) throws IOException {
    	System.out.println("Se debe iniciar sesion");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		out.print("./iniciarSesion.html");
		out.flush();
    }
    
    
    /**
     * Método que "envía" una solicitud a la central para que envíen el vehículo indicado
     * @param request obtiene los datos del frontend
     * @param response envía una respuesta al frontend
     * @throws IOException
     */
    private void solicitarVehiculo (HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("Enviando solicitud del coche");
		
		PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    System.out.println("Solicitando vehiculo: ");
	    System.out.println("Modelo: " + request.getParameter("smodelo"));
	    System.out.println("Precio: " + request.getParameter("sprecio"));
	    System.out.println("Color: " + request.getParameter("scolores"));
	    System.out.println("Caballos: " + request.getParameter("scaballos"));
	    System.out.println("Maletero: " + request.getParameter("smaletero"));
	    System.out.println("Puertas: " + request.getParameter("spuertas"));

	    out.print("Vehiculo solicitado");
    	out.flush();
    	
    }
    
    /**
     * Guarda mientras dure la sesión el estado de aceptación de las cookies
     */
    private void setCookiesAceptadas () {
    	this.isCookiesAcepted = true;
    	System.out.println("Set cookies: " + this.isCookiesAcepted);
    }
    
    /**
     * Indica si se han aceptado las cookies o no y lo indica al frontend 
     * @param response
     * @throws IOException
     */
    private void getIsCookiesAceptadasInFront (HttpServletResponse response) throws IOException {
    	PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
    	System.out.println("Get cookies: " + this.isCookiesAcepted);
    	if (this.isCookiesAcepted) {
    		out.print("true");
        	out.flush();
    	}
	    
    }
    
    /**
     * Método que añade un nuevo ataque al log de ataques
     * @param request
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws FileNotFoundException
     * @throws SQLException 
     */
    private void addNuevoAtaque (HttpServletRequest request){
    	System.out.println("Intentando leer el attacks log");
    	try {
			this.cdao.insertarAtaque(request.getParameter("nuevoAtaque"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    /**
     * Método que le añade una nueva cita a un cliente
     * @param request obtiene la información del frontend
     * @throws SQLException
     */
    private void setNuevaCita (HttpServletRequest request) throws SQLException {
    	System.out.println(request.getParameter("nuevaCita"));
    	String citaDate = request.getParameter("nuevaCita").replace("T", " ");
    	System.out.println(citaDate);

    	Cita cita = new Cita(this.rdao.getClienteFromDB(this.usuario), citaDate);
    	this.cdao.insertarCita(cita);
    }
    
    /**
     * Método que recupera los ataques de la DB
     * @param response para mostrar los ataques guardados en la base de datos
     */
    private void comprobarAtaques (HttpServletResponse response) {
    	
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			try {
				ArrayList<Ataque> ataques = this.rdao.getAtaquesFromDB();
				String ataquesList = "<div>";
				for (int i = 0; i < ataques.size(); i++) {
					ataquesList += "<p class=\"attacks\">" + ataques.get(i).getHora() + " : " + ataques.get(i).getTipo() + "</p>";
				}
				ataquesList += "</div>";
				out.print(ataquesList);
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Intentando un GET");
		//this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		if (this.session == null) {
			this.session = request.getSession();
		}
		if (this.usuario == null ) {
			this.usuario = (String) this.session.getAttribute("usuario");
		}
		
		System.out.println("Sesion en Servlet: " + this.session.getAttribute("usuario"));
		System.out.println("Usuario en Servlet: " + this.usuario);
		
		// mirar response.sendRedirect
        if (this.usuario!=null) {
        	 if (request.getParameter("cuenta")!=null) {
    			this.cargarCuenta(response);
    		} else if (request.getParameter("cuenta-edit-usuario")!=null) {
    			this.editarDatos();
    		} else if (request.getParameter("nombre-emp-vm")!=null) {
    			System.out.println("ver mas empleado");
    		} else if (request.getParameter("fichaEmp")!=null) {
    			this.recuperarEmp(response);
    		} else if (request.getParameter("smodelo")!=null) {
    			this.solicitarVehiculo(request, response);
    		} else if (request.getParameter("nuevaCita")!=null) {
    			try {
					this.setNuevaCita(request);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		} else if (request.getParameter("ataques")!=null) {
    			this.comprobarAtaques(response);
    		}
        } else {
        	if (request.getParameter("inicio-sesion-usuario")!=null) {
    			this.iniciarSesion(request, response);
    		} else if (request.getParameter("reg-usuario-emp")!=null) {
    			this.registrarEmpleado(request, response);
    		} else if (request.getParameter("reg-usuario")!=null) {
    			this.registrarCliente(request, response);
    		} else if (request.getParameter("modelo")!=null) {
    	    	this.seleccionarVehiculo(request, response);
    		} else if (request.getParameter("inicioPrivado")!=null) {
    			this.iniciarSesionPrivado(response);
    		} else if (request.getParameter("aceptarCookies")!=null) {
    			this.setCookiesAceptadas();
    		} else if (request.getParameter("isCookiesAceptadas")!=null) {
    			this.getIsCookiesAceptadasInFront (response);
    		} else if (request.getParameter("nuevoAtaque")!=null) {
    			this.addNuevoAtaque(request);
        	} else {
    			this.obligarIniciarSesion(response);
    		}
        } // fin if else de sesion

	} // fin post

} // fin clase
