
package sgvferreteria.Dao;


public class Usuario {
    private int codUsuario;
    private String nombre;
    private String cedula;
    private String correo;
    private String tipoUsuario;
    private String provincia;
    private String canton;
    private String distrito;
    private String login;
    private String password;

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

 
    public Usuario(int codUsuario, String nombre, String cedula, String correo, String tipoUsuario, String provincia, String distrito, String canton) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.provincia = provincia;
        this.distrito = distrito;
        this.canton = canton;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", tipoUsuario=" + tipoUsuario + ", provincia=" + provincia + ", distrito=" + distrito + ", canton=" + canton + '}';
    }
    
    
    
}
