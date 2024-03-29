
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
  public Producto buscar(int id){
      Producto p=new Producto();
      String sql="select * from producto where idproducto="+id;
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
              p.setId(rs.getInt(1));
              p.setNom(rs.getString(2));
              p.setPre(rs.getDouble(3));
              p.setDesc(rs.getString(4));
              p.setTM(rs.getString(5));
          }
      } catch (Exception e) {
      }
     return p;
  }
  //*******Operaciones CRUD***************//    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                em.setDesc(rs.getString(4));
                em.setTM(rs.getString(5));                
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Producto p){ 
        String sql="insert into producto(Nombres, Precio,Descripcion,Tipo_Menu)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setString(3, p.getDesc());
            ps.setString(4, p.getTM());        
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public Producto listarId(int id){
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));               
                pr.setPre(rs.getDouble(3));
                pr.setDesc(rs.getString(4));
                pr.setTM(rs.getString(5));  
            }
        } catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Producto em){
        String sql="update producto set Nombres=?, Precio=?, Descripcion=?, Tipo_Menu=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
            ps.setString(3, em.getDesc());
            ps.setString(4, em.getTM());            
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
