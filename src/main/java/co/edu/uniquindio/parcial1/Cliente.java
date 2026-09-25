package co.edu.uniquindio.parcial1;

public class Cliente {
}/**
 * Clase administradora del sistema. Representa a la empresa DevPlus
 * y mantiene los arreglos generales de clientes, proyectos, desarrolladores
 * y servicios adicionales.
 */
public class Empresa {

    // Tamaños fijos de los arreglos generales de la empresa
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_PROYECTOS = 50;
    private static final int MAX_DESARROLLADORES = 50;
    private static final int MAX_SERVICIOS = 50;

    // Atributos privados
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String web;

    // Relaciones generales: arreglos estáticos + contador de elementos usados
    private Cliente[] clientes;
    private int cantidadClientes;
    private Proyecto[] proyectos;
    private int cantidadProyectos;
    private Desarrollador[] desarrolladores;
    private int cantidadDesarrolladores;
    private ServicioAdicional[] servicios;
    private int cantidadServicios;

    // Constructor
    public Empresa(String nombre, String nit, String direccion, String telefono, String web) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.web = web;
        this.clientes = new Cliente[MAX_CLIENTES];
        this.cantidadClientes = 0;
        this.proyectos = new Proyecto[MAX_PROYECTOS];
        this.cantidadProyectos = 0;
        this.desarrolladores = new Desarrollador[MAX_DESARROLLADORES];
        this.cantidadDesarrolladores = 0;
        this.servicios = new ServicioAdicional[MAX_SERVICIOS];
        this.cantidadServicios = 0;
    }

    // Métodos de registro
    public boolean registrarCliente(Cliente cliente) {
        if (cantidadClientes >= clientes.length) {
            System.out.println("No se pudo registrar: se alcanzó el máximo de clientes.");
            return false;
        }
        clientes[cantidadClientes] = cliente;
        cantidadClientes++;
        return true;
    }

    public boolean registrarProyecto(Proyecto proyecto) {
        if (cantidadProyectos >= proyectos.length) {
            System.out.println("No se pudo registrar: se alcanzó el máximo de proyectos.");
            return false;
        }
        proyectos[cantidadProyectos] = proyecto;
        cantidadProyectos++;
        return true;
    }

    public boolean registrarDesarrollador(Desarrollador desarrollador) {
        if (cantidadDesarrolladores >= desarrolladores.length) {
            System.out.println("No se pudo registrar: se alcanzó el máximo de desarrolladores.");
            return false;
        }
        desarrolladores[cantidadDesarrolladores] = desarrollador;
        cantidadDesarrolladores++;
        return true;
    }

    public boolean registrarServicio(ServicioAdicional servicio) {
        if (cantidadServicios >= servicios.length) {
            System.out.println("No se pudo registrar: se alcanzó el máximo de servicios.");
            return false;
        }
        servicios[cantidadServicios] = servicio;
        cantidadServicios++;
        return true;
    }

    /**
     * Recorre todos los proyectos registrados y acumula el valor total de
     * aquellos cuya fecha de solicitud coincide exactamente con la fecha
     * consultada.
     */
    public double calcularIngresosPorFecha(String fechaConsulta) {
        double acumulado = 0.0;
        for (int i = 0; i < cantidadProyectos; i++) {
            Proyecto p = proyectos[i];
            if (p.getFechaSolicitud().equalsIgnoreCase(fechaConsulta)) {
                acumulado = acumulado + p.getValorTotal();
            }
        }
        return acumulado;
    }

    /**
     * Busca un cliente por su número de teléfono.
     * Retorna el objeto Cliente si lo encuentra, o null si no existe.
     */
    public Cliente buscarClientePorTelefono(String telefono) {
        for (int i = 0; i < cantidadClientes; i++) {
            Cliente c = clientes[i];
            if (c.getTelefono().equals(telefono)) {
                return c;
            }
        }
        return null; // No encontrado
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    // Los siguientes getters devuelven el arreglo completo (tamaño fijo);
    // usamos el respectivo getCantidad...() para saber cuántas posiciones
    // están realmente ocupadas.
    public Cliente[] getClientes() {
        return clientes;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public Proyecto[] getProyectos() {
        return proyectos;
    }

    public int getCantidadProyectos() {
        return cantidadProyectos;
    }

    public Desarrollador[] getDesarrolladores() {
        return desarrolladores;
    }

    public int getCantidadDesarrolladores() {
        return cantidadDesarrolladores;
    }

    public ServicioAdicional[] getServicios() {
        return servicios;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }
}