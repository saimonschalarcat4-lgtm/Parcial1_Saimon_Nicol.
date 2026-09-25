/**
 * Clase que representa a un desarrollador de DevPlus.
 */
public class Desarrollador {

    // Atributos privados
    private String codigo;
    private String equipoTrabajo;
    private String nivel; // "Junior", "Semi Senior", "Senior"
    private int cantidadMaximaProyectos;
    private double tarifaPorDia;
    private String estado; // "Disponible", "Asignado", "Ocupado"

    // Constructor
    public Desarrollador(String codigo, String equipoTrabajo, String nivel,
                         int cantidadMaximaProyectos, double tarifaPorDia, String estado) {
        this.codigo = codigo;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.cantidadMaximaProyectos = cantidadMaximaProyectos;
        this.tarifaPorDia = tarifaPorDia;
        this.estado = estado;
    }

    /**
     * Cambia el estado actual del desarrollador.
     * Se valida contra los tres estados permitidos.
     */
    public void actualizarDisponibilidad(String nuevoEstado) {
        if (nuevoEstado.equalsIgnoreCase("Disponible")
                || nuevoEstado.equalsIgnoreCase("Asignado")
                || nuevoEstado.equalsIgnoreCase("Ocupado")) {
            this.estado = nuevoEstado;
        } else {
            // Estado no reconocido, se deja el valor anterior
            System.out.println("Estado no válido. Se mantiene: " + this.estado);
        }
    }

    // ---------- Getters y Setters ----------
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCantidadMaximaProyectos() {
        return cantidadMaximaProyectos;
    }

    public void setCantidadMaximaProyectos(int cantidadMaximaProyectos) {
        this.cantidadMaximaProyectos = cantidadMaximaProyectos;
    }

    public double getTarifaPorDia() {
        return tarifaPorDia;
    }

    public void setTarifaPorDia(double tarifaPorDia) {
        this.tarifaPorDia = tarifaPorDia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String obtenerInformacion() {
        return "[" + codigo + "] " + equipoTrabajo + " - Nivel: " + nivel
                + " - Tarifa/día: $" + tarifaPorDia + " - Estado: " + estado;
    }
