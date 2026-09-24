package co.edu.uniquindio.DevPlus;

public class Cliente{

        private String nombre;
        private String id;
        private int telefono;
        private String correo;
        private String pais;
        private Proyecto theProyecto;

        private Proyecto[] listProyectos;
        private int contadorProyectos;

    public Cliente(String nombre, String id, int telefono, String correo, String pais){
            this.nombre = nombre;
            this.id = id;
            this.telefono = telefono;
            this.correo = correo;
            this.pais = pais;
            listProyectos = new Proyecto[5];
            this.contadorProyectos = 0;

        }

        public void agregarProyecto (Proyecto Proyecto){
            boolean agregado = false;
            for (int i = 0; i < listProyectos.length; i++) {
                if (listProyectos[i] == null) {
                    listProyectos[i] = Proyecto;
                    agregado = true;
                    break;
                }
            }
            if (agregado) {
                System.out.println("Proyecto agregado al cliente");
            } else {
                System.out.println("Limite alcanzado de proyectos");
            }
        }

        public void mostrarInformacion () {
            boolean tieneProyectos = false;
            for (int i = 0; i < listProyectos.length; i++) {
                if (listProyectos[i] != null) {
                    tieneProyectos = true;
                    System.out.println("Codigo proyecto" + listProyectos[i]);
                }
            }
            System.out.println("Cliente:" + nombre + "ID" + id + "Telefono:" + telefono + "Correo:" + correo + "Pais" + pais);
        }
        public boolean esFrecuente(){
            int contadorProyectos=0;
            for (int i=0; i<contadorProyectos; i++){
                if(listProyectos[i]!= null){
                contadorProyectos++;
                }
            }
        return contadorProyectos>=2;
        }


        //Getters and setters
        public String getNombre () {

            return nombre;
        }
        public void setNombre (String nombre){

            this.nombre = nombre;
        }

        public String getId () {

            return id;
        }

        public void setId (String id){

            this.id = id;
        }

        public int getTelefono () {

            return telefono;
        }

        public void setTelefono ( int telefono){

            this.telefono = telefono;
        }

        public String getCorreo () {

            return correo;
        }

        public void setCorreo (String correo){

            this.correo = correo;
        }
        public String getPais () {

            return pais;
        }

        public void setPais (String pais){

            this.pais = pais;
        }
        public Proyecto[] getListProyectos () {

            return listProyectos;
        }

        public void setListProyectos (Proyecto[]listProyectos){

            this.listProyectos = listProyectos;
        }
    }

