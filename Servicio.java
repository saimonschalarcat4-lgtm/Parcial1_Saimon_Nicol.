package co.edu.uniquindio.DevPlus;
/**
 * Clase que representa un servicio adicional que la empresa DevPlus
 * puede ofrecer dentro de un proyecto (soporte, capacitación, despligue, migracion).
 */
    //Atributos privados
    public class Servicio {
        private String codigo;
        private String nombre;
        private String descripcion;
        private double precio;
        private String disponibilidad;

        //Constructor
        public Servicio(String codigo, String nombre, String descripcion, double precio, String disponibilidad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.disponibilidad= disponibilidad;
        }
        public void estadoDisponible(){
            if(disponibilidad!= null && disponibilidad.equalsIgnoreCase("Se encuentra disponible")) {
                System.out.println("El servicio se encuentra disponible");
            }else{
                System.out.println("El servicio no se encuentra disponible");
            }
        }

        //Getters and setters
        public String getCodigo(){

            return codigo;
        }
        public void setCodigo(String codigo){

            this.codigo= codigo;
        }
        public String getNombre(){

            return nombre;
        }
        public void setNombre(String nombre){

            this.nombre = nombre;
        }

        public String getDescripcion(){

            return descripcion;
        }

        public void setDescripcion (String descripcion){

            this.descripcion = descripcion;
        }

        public double getPrecio() {

            return precio;
        }

        public void setPrecio(double precio){

            this.precio = precio;
        }

        public String getDisponibilidad() {

            return disponibilidad;
        }

        public void setDisponibilidad(String disponibilidad){

            this.disponibilidad = disponibilidad;
        }



    }



