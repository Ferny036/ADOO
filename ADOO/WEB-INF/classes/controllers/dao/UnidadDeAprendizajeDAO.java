package dao;

import java.util.*;
import java.io.*;
import models.*;
import java.sql.*;

public class UnidadDeAprendizajeDAO implements DAOInterface<UnidadDeAprendizaje>
{
  Vector<UnidadDeAprendizaje> listaUnidadesDeAprendizaje;
  DAOInterface<UnidadDeAprendizaje> dao;

  public UnidadDeAprendizajeDAO() throws SQLException
  {
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    listaUnidadesDeAprendizaje = new Vector<UnidadDeAprendizaje>();
    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM UnidadDeAprendizaje;");

    while(rs.next())
    {
      UnidadDeAprendizaje m = new UnidadDeAprendizaje(
      rs.getString("nombre"),
      new File(rs.getString("temario")),
      rs.getFloat("creditos"),
      null,
      null
      );
      m.setId(rs.getInt("idUnidadDeAprendizaje"));
      asignarProfesores(m);
      asignarGrupos(m);
      listaUnidadesDeAprendizaje.add(m);
    }
    conex.close();
  }

  public void asignarProfesores(UnidadDeAprendizaje ua) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ");

    while(rs.next())
    {
      Profesor prof = new Profesor(
      rs.getString("nombre"),
      new File(rs.getString("curriculum")),
      null,
      null
      );
      prof.setId(rs.getInt("idProfesor"));
      ua.getProfesores().add(prof);
    }
    conex.close();
  }

  public void asignarGrupos(UnidadDeAprendizaje ua) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ");

    while(rs.next())
    {
      Grupo grupo = new Grupo(
      rs.getString("nombre"),
      null,
      null,
      null
      );
      grupo.setId(rs.getInt("idGrupo"));
      ua.getGrupos().add(grupo);
    }
    conex.close();
  }

  public UnidadDeAprendizaje read(int id)
  {
    return listaUnidadesDeAprendizaje.get(id);
  }

  public Vector<UnidadDeAprendizaje> read()
  {
    return listaUnidadesDeAprendizaje;
  }

  public void create(UnidadDeAprendizaje c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaUnidadesDeAprendizaje.add(c);

    try{
      String sql = "INSERT into UnidadDeAprendizaje(nombre, temario, creditos) VALUES (?,?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.setString(2, c.getTemario().getCanonicalPath());
      ps.setFloat(3, c.getCreditos());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(IOException io){
      io.printStackTrace();
    }
  }

  public void update(int id, UnidadDeAprendizaje t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    UnidadDeAprendizaje c = read(id);

    try{
      String sql = "UPDATE UnidadDeAprendizaje "+
      "SET nombre = '"+t.getNombre()+"', temario = '"+t.getTemario().getCanonicalPath()+"', creditos ='"+t.getCreditos()+
      "' WHERE idUnidadDeAprendizaje = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(IOException io){
      io.printStackTrace();
    }
    t.setId(c.getId());
    t.setProfesores(c.getProfesores());
    t.setGrupos(c.getGrupos());
    listaUnidadesDeAprendizaje.set(id, t);
  }

  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    UnidadDeAprendizaje c = read(id);

    try{
      String sql = "DELETE FROM UnidadDeAprendizaje WHERE idUnidadDeAprendizaje = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaUnidadesDeAprendizaje.removeElementAt(id);
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

}
