/*
 * Fecha de creacion: 05/09/2023 16:00:24
 * Version: v.0.1
 * Detalles: 
 */

package datos;

/**
 * @author Willy Stbn
 */

public class Usuario {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String estatus;
    private String pass;
    private String usuario;

    public Usuario() {
        
    }

    public Usuario(String nombre, String apellido, int edad, String estatus, String pass, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estatus = estatus;
        this.pass = pass;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", estatus=" + estatus + ", usuario=" + usuario + '}';
    }
   
    
}
