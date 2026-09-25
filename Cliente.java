package co.edu.uniquindio.DevPlus;
/**
 * Clase que representa a un cliente de DevPlus.
 */
public class Cliente {

    // Tamaño fijo del arreglo de proyectos asociados a este cliente
    private static final int MAX_PROYECTOS = 10;

    // Atributos privados
    private String nombreCompleto;
    private String documento; // NIT o documento de identidad
    private String telefono;
    private String correo;
    private String pais;

    // Relación: arreglo estático de proyectos + contador de elementos usados
    private Proyecto[] proyectos;
    private int cantidadProyectos;

    // Constructor
    public Cliente(String nombreCompleto, String documento, String telefono,
                   String correo, String pais) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
        this.proyectos = new Proyecto[MAX_PROYECTOS];
        this.cantidadProyectos = 0;
    }

    /**
     * Determina si el número de teléfono del cliente es un "número perfecto".
     * Un número perfecto es aquel que es igual a la suma de sus divisores
     * propios (todos los divisores menores que él mismo).
     * Ej: 28 es perfecto porque 1 + 2 + 4 + 7 + 14 = 28.
     *
     * Como el teléfono puede tener muchos dígitos (más de lo que un int
     * puede manejar cómodamente), primero se limpia el String dejando solo
     * dígitos y, si el número es muy largo, se toman únicamente los últimos
     * 5 dígitos para poder trabajar con un int de forma segura.
     */
    public boolean esTelefonoPerfecto() {
        // 1. Dejar solo los dígitos del teléfono
        String soloDigitos = "";
        for (int i = 0; i < telefono.length(); i++) {
            char c = telefono.charAt(i);
            if (Character.isDigit(c)) {
                soloDigitos = soloDigitos + c;
            }
        }

        if (soloDigitos.length() == 0) {
            return false; // No hay dígitos que evaluar
        }

        // 2. Si el número es muy largo, tomar solo los últimos 5 dígitos
        //    para que quepa cómodamente en un int
        String numeroTrabajo;
        if (soloDigitos.length() > 5) {
            numeroTrabajo = soloDigitos.substring(soloDigitos.length() - 5);
        } else {
            numeroTrabajo = soloDigitos;
        }

        int numero = Integer.parseInt(numeroTrabajo);

        if (numero <= 1) {
            return false; // 0 y 1 no son números perfectos
        }

        // 3. Sumar los divisores propios (de 1 hasta numero/2)
        int sumaDivisores = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores = sumaDivisores + i;
            }
        }

        // 4. Comparar la suma de divisores con el número original
        return sumaDivisores == numero;
    }

    /**
     * Asocia un proyecto a este cliente, siempre que haya espacio
     * disponible en el arreglo (tamaño fijo).
     */
    public boolean agregarProyecto(Proyecto proyecto) {
        if (cantidadProyectos < proyectos.length) {
            proyectos[cantidadProyectos] = proyecto;
            cantidadProyectos++;
            return true;
        }
        System.out.println("No se pudo agregar el proyecto: el cliente alcanzó el máximo de proyectos.");
        return false;
    }

    // ---------- Getters y Setters ----------
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Devuelve el arreglo completo de proyectos (tamaño fijo; las posiciones
    // desde "cantidadProyectos" en adelante están vacías/null).
    public Proyecto[] getProyectos() {
        return proyectos;
    }

    public int getCantidadProyectos() {
        return cantidadProyectos;
    }

    public String toString() {
        return nombreCompleto + " - Doc: " + documento + " - Tel: " + telefono
                + " - " + pais;
    }
}

