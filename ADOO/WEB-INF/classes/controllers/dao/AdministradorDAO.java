package dao;

import java.util.*;
import java.sql.*;
import models.*;

public class AdministradorDAO implements DAOInterface<Administrador>
{
  Administrador admin;
  Connection conex = null;
  Statement statement = null;
  PreparedStatement ps = null;
  ResultSet rs = null;

  DAOInterface<Administrador> dao;

  public AdministradorDAO() throws SQLException
  {
    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Administrador;");

    if(rs.next())
    {
      admin = new Administrador(
      rs.getString("nombre"),
      rs.getString("password"),
      rs.getString("email")
      );

      admin.setId(rs.getInt("idAdministrador"));

    }
    conex.close();
  }

  public Connection getConnection()
  {
    try{

      Class.forName("com.mysql.jdbc.Driver");

      return DriverManager.getConnection(dao.url + dao.dbName, "root", "" );

    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(ClassNotFoundException cl){
      cl.printStackTrace();
    }

    return null;
  }

  public Administrador read(int id)
  {
    return admin;
  }
  //DAdo que no existe mas q un administrador no es necesario llamar a todos los registros
  public Vector<Administrador> read()
  { return null; }

    //Un administrador no puede ser creado
    public void create(Administrador t)
    {}

      public void update(int id, Administrador t)
      {

        try{
          String sql = "UPDATE administrador "+
          "SET nombre = '"+t.getNombre()+"', password = '"+t.getPassword()+
          "', email = '"+t.getEmail()+"' WHERE idAdministrador = "+this.admin.getId()+";";
          conex = getConnection();
          ps = conex.prepareStatement(sql);
          ps.executeUpdate();
          conex.close();

        }catch(SQLException sql){
          sql.printStackTrace();
        }
        t.setId(this.admin.getId());
        this.admin = t;
      }
      //No podemos borrar al administrador
      public void delete(int id)
      {}
      }
