
package sgvferreteria.Controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import sgvferreteria.Dao.Usuario;


public class IOUsuarioImplements implements IOUsuarios{
    
    private ArrayList<Usuario> usuario;
    private Usuario nuevoU; 

    public IOUsuarioImplements() {
        usuario= new ArrayList<Usuario>();
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    
    
    @Override
    public Usuario obtenerUsuario(String cedula) {
     
          Usuario us = null;
          
        try {
            String sql= " select * from ferreteriadb.usuarios where cedula ='"+cedula+"' ";
            Statement s = ConexionMySQL.obtener().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
              
               us = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)); 
            }
          
            } catch (SQLException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
      return us;  
            
    }

    @Override
    public void cargarUsuarios() {
        String urlArchivo;
       try{
           
         

           urlArchivo="C:/Users/USUARIO/Desktop/usuarios.txt";
           BufferedReader br;
           String lineaUsuarioArch, lineaUsuarioArreglo[];//lineaUsuarioArch almacena cada linea que se obtiene del archivo
           //lineaUsuarioArreglo almacena la linea que se obtiene del archibo en un arreglo.
           int codUsuario;
           String nombre,cedula,correo,tipoUsuario,provincia,distrito,canton;
           
           br= new BufferedReader(new FileReader(urlArchivo));
           while((lineaUsuarioArch=br.readLine())!=null){
               lineaUsuarioArreglo= lineaUsuarioArch.split(",");
               codUsuario = Integer.parseInt(lineaUsuarioArreglo[0].trim());
               nombre = lineaUsuarioArreglo[1].trim();
               cedula = lineaUsuarioArreglo[2].trim();
               correo = lineaUsuarioArreglo[3].trim();
               tipoUsuario = lineaUsuarioArreglo[4].trim();
               provincia = lineaUsuarioArreglo[5].trim();
               distrito = lineaUsuarioArreglo[6].trim();
               canton = lineaUsuarioArreglo[7].trim();
               
               nuevoU = new Usuario(codUsuario,nombre,cedula,correo,tipoUsuario,provincia,distrito,canton);
               this.adicionarUsuario(nuevoU);
               
           }
       
       }catch(Exception e){
           
       }
    }

    @Override
    public void registrarUsuario(Usuario us) {
         PreparedStatement registro;
     
       
            try {
                registro = (PreparedStatement) ConexionMySQL.obtener().prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?)");
                registro.setInt(1,us.getCodUsuario());
                registro.setString(2, us.getNombre());
                registro.setString(3, us.getCedula());
                registro.setString(4, us.getCorreo());
                registro.setString(5, us.getTipoUsuario());
                registro.setString(6,us.getProvincia());
                registro.setString(7,us.getCanton());
                registro.setString(8, us.getDistrito());
                registro.executeUpdate();
            
            
            
            } catch (SQLException ex) {
                Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente....!");
     
    }

    @Override
    public void registrarUsuario() {
        PreparedStatement registro;
        Usuario u;
        for(int i = 0; i <=usuario.size()-1; i++){
            u = usuario.get(i);
            try {
                registro = (PreparedStatement) ConexionMySQL.obtener().prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?)");
                registro.setInt(1,u.getCodUsuario());
                registro.setString(2, u.getNombre());
                registro.setString(3, u.getCedula());
                registro.setString(4, u.getCorreo());
                registro.setString(5, u.getTipoUsuario());
                registro.setString(6,u.getProvincia());
                registro.setString(7,u.getCanton());
                registro.setString(8, u.getDistrito());
                registro.executeUpdate();
            
            
            
            } catch (SQLException ex) {
                Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Usuarios Registrados Exitosamente....!");
    
    }

    @Override
    public void adicionarUsuario(Usuario us) {
          usuario.add(us);
    }

    @Override
    public int size() {
      return usuario.size();
    }

    @Override
    public Usuario obtenerUsuario(int i) {
      return usuario.get(i);
    }

    @Override
    public int getMaxCodigo() {
        int codigoU=0;
        try {
            String sql= "select max(codUsuario)+1 codigo from  ferreteriadb.usuarios ";
            Statement s = ConexionMySQL.obtener().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
               codigoU = rs.getInt(1);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOUsuarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       return codigoU;
    }
    
    
}
