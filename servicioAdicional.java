package co.edu.uniquindio.DevPlus;

public class servicioAdicional {
    private String nombreServicio;
    private double costoAdicional;

    public servicioAdicional(String nombreServicio, double costoAdicional){
        this.nombreServicio= nombreServicio;
        this.costoAdicional= costoAdicional;
    }
    //Getters
    public String getNombreServicio(){

        return nombreServicio;
    }

    public double getCostoAdicional(){

        return costoAdicional;
    }

}
