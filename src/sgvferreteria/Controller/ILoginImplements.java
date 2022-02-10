
package sgvferreteria.Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sgvferreteria.Dao.Usuario;


public class ILoginImplements extends IOUsuarioImplements {

    public ILoginImplements() {
    }
    
     @Override
    public Usuario obtenerUsuario(String usuarioIngreso) {
          String loginU=null;
          String passU = null;
          Usuario us = null;
          
        try {
            String sql= " select login, password from ferreteriadb.usuarios where login ='"+usuarioIngreso+"' ";
            Statement s = ConexionMySQL.obtener().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
               loginU = rs.getString(1);
               passU = rs.getString(2);
               us = new Usuario(loginU,passU); 
            }
          
            } catch (SQLException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
      return us;  
            
    }
    
}
