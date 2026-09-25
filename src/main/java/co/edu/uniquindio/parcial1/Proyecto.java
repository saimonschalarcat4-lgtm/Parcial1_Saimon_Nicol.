/**
 * Clase que representa un proyecto de desarrollo de software gestionado
 * por DevPlus.
 */
public class Proyecto {

    // Tamaños fijos de los arreglos asociados al proyecto
    private static final int MAX_DESARROLLADORES = 10;
    private static final int MAX_SERVICIOS = 10;

    // Atributos privados
    private String codigo;
    private String fechaSolicitud;
    private String fechaInicio;
    private String fechaEntrega;
    private String estado; // Ej: "Pendiente", "Confirmado", "Finalizado"
    private String metodoPago; // Ej: "Efectivo", "Transferencia", "Tarjeta"
    private double valorTotal;
    private int diasDesarrollo;

    // Relaciones: arreglos estáticos + contador de elementos usados
    private Desarrollador[] desarrolladores;
    private int cantidadDesarrolladores;
    private ServicioAdicional[] servicios;
    private int cantidadServicios;

    // Constructor
    public Proyecto(String codigo, String fechaSolicitud, String fechaInicio,
                    String fechaEntrega, String estado, String metodoPago,
                    int diasDesarrollo) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.diasDesarrollo = diasDesarrollo;
        this.valorTotal = 0.0;
        this.desarrolladores = new Desarrollador[MAX_DESARROLLADORES];
        this.cantidadDesarrolladores = 0;
        this.servicios = new ServicioAdicional[MAX_SERVICIOS];
        this.cantidadServicios = 0;
    }

    /**
     * Agrega un desarrollador al proyecto, pero solo si su estado
     * actual es "Disponible" y si aún hay espacio en el arreglo.
     */
    public boolean agregarDesarrollador(Desarrollador dev) {
        if (!dev.getEstado().equalsIgnoreCase("Disponible")) {
            return false; // No se agregó porque no estaba disponible
        }
        if (cantidadDesarrolladores >= desarrolladores.length) {
            System.out.println("No se pudo agregar: el proyecto alcanzó el máximo de desarrolladores.");
            return false;
        }
        desarrolladores[cantidadDesarrolladores] = dev;
        cantidadDesarrolladores++;
        return true;
    }

    /**
     * Agrega un servicio adicional al proyecto, si aún hay espacio
     * en el arreglo.
     */
    public boolean agregarServicio(ServicioAdicional servicio) {
        if (cantidadServicios >= servicios.length) {
            System.out.println("No se pudo agregar: el proyecto alcanzó el máximo de servicios.");
            return false;
        }
        servicios[cantidadServicios] = servicio;
        cantidadServicios++;
        return true;
    }

    /**
     * Calcula el valor total del proyecto:
     * suma (días de desarrollo * tarifa por día de cada desarrollador)
     * + suma (precio de cada servicio adicional)
     * - descuento
     * Actualiza el atributo valorTotal y lo retorna.
     */
    public double calcularValorTotal(double descuento) {
        double totalDesarrolladores = 0.0;
        for (int i = 0; i < cantidadDesarrolladores; i++) {
            Desarrollador dev = desarrolladores[i];
            totalDesarrolladores = totalDesarrolladores
                    + (diasDesarrollo * dev.getTarifaPorDia());
        }

        double totalServicios = 0.0;
        for (int i = 0; i < cantidadServicios; i++) {
            totalServicios = totalServicios + servicios[i].getPrecio();
        }

        double total = totalDesarrolladores + totalServicios - descuento;

        if (total < 0) {
            total = 0; // El valor total no debería quedar negativo
        }

        this.valorTotal = total;
        return this.valorTotal;
    }

    /**
     * Cambia el estado del proyecto. Si el nuevo estado es "Confirmado",
     * recorre la lista de desarrolladores asignados y cambia su estado
     * a "Asignado".
     */
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;

        if (nuevoEstado.equalsIgnoreCase("Confirmado")) {
            for (int i = 0; i < cantidadDesarrolladores; i++) {
                desarrolladores[i].actualizarDisponibilidad("Asignado");
            }
        }
    }

    // ---------- Getters y Setters ----------
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getDiasDesarrollo() {
        return diasDesarrollo;
    }

    public void setDiasDesarrollo(int diasDesarrollo) {
        this.diasDesarrollo = diasDesarrollo;
    }

    // Devuelve el arreglo completo (tamaño fijo); usar getCantidadDesarrolladores()
    // para saber cuántas posiciones están realmente ocupadas.
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

    public String toString() {
        return "[" + codigo + "] Estado: " + estado + " - Solicitado: "
                + fechaSolicitud + " - Valor: $" + valorTotal;
    }
}