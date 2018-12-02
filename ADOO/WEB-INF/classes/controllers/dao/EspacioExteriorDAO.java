package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class EspacioExteriorDAO implements DAOInterface<EspacioExterior>
{
  Vector<EspacioExterior> listaEspaciosExteriores;
  DAOInterface<EspacioExterior> dao;

  public EspacioExteriorDAO() throws SQLException
  {
    listaEspaciosExteriores = new Vector<EspacioExterior>();
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM EspacioExterior;");

    while(rs.next())
    {
      //String ubicacion; int id;
      EspacioExterior m = new EspacioExterior(
      rs.getString("ubicacion")
      );
      m.setId(rs.getInt("idEspacioExterior"));
      listaEspaciosExteriores.add(m);
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

  //Leer un unico EspacioExterior de la lista
  public EspacioExterior read(int id)
  {
    return listaEspaciosExteriores.get(id);
  }

  //Leer todos los EspacioExteriors
  public Vector<EspacioExterior> read()
  {
    return listaEspaciosExteriores;
  }

  //Crear un nuevo EspacioExterior
  public void create(EspacioExterior c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaEspaciosExteriores.add(c);

    try{
      String sql = "INSERT INTO EspacioExterior(ubicacion) VALUES (?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getLugar());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un EspacioExterior
  public void update(int id, EspacioExterior t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    EspacioExterior c = read(id);

    try{
      String sql = "UPDATE EspacioExterior "+
      "SET ubicacion = '"+t.getLugar()+
      "' WHERE idEspacioExterior = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    t.setId(c.getId());
    listaEspaciosExteriores.set(id, t);
  }

  //Eliminar un EspacioExterior
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    EspacioExterior c = read(id);

    try{
      String sql = "DELETE FROM EspacioExterior WHERE idEspacioExterior = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaEspaciosExteriores.removeElementAt(id);
  }

}
