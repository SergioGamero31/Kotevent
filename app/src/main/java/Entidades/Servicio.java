package Entidades;
//Renzo Cuadros Salazar
//Sergio Gamero Calle
//Gricel Ramos Ramos
public class Servicio {
    private String nombre;
    private String descrip;
    private int imagenId;

    public Servicio(){}
    public Servicio(String nombre, String descrip, int imagenId) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}

