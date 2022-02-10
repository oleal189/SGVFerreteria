
package sgvferreteria.Controller;

import java.util.ArrayList;
import sgvferreteria.Dao.Usuario;

public interface IOUsuarios {
    
    public Usuario obtenerUsuario(String cedula);
    public void cargarUsuarios();
    public void registrarUsuario(Usuario us);
    public void registrarUsuario();
    public void adicionarUsuario(Usuario us);
    public int size();
    public Usuario obtenerUsuario(int i);
    public int getMaxCodigo();
}