package dao;

import java.util.*;
import java.io.File;
import models.*;
import java.sql.*;

public class GrupoDAO implements DAOInterface<Grupo>
{
  Vector<Grupo> listaGrupos;
  DAOInterface<Grupo> dao;

  public GrupoDAO() throws SQLException
  {
    listaGrupos = new Vector<Grupo>();
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Grupo;");

    while(rs.next())
    {
      //String nombre, UnidadDeAprendizaje ua, Vector<Horario> horario, Profesor profesor
      Grupo m = new Grupo(
      rs.getString("nombre"),
      null,
      null,
      null
      );
      m.setId(rs.getInt("idGrupo"));
      listaGrupos.add(m);
      asignarHorario(m);
      asignarUnidadDeAprendizaje(m);
      asignarProfesor(m);
    }
    conex.close();
  }

  public void asignarHorario(Grupo grupo) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM "); // INNNER para obtener al autor

    while(rs.next())
    {
      //Date inicio, Date fin
      Horario horario = new Horario(
      rs.getDate("horaInicio"),
      rs.getDate("horaFin")
      );
      horario.setId(rs.getInt("idHorario"));
      grupo.getHorario().add(horario);
    }
    conex.close();

  }

  public void asignarProfesor(Grupo grupo) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM "); // INNER para obtener al profesor

    if(rs.next())
    {
      //String nombre, File curriculum, Vector<Grupo> grupos, Vector<UnidadDeAprendizaje> uas
      Profesor prof = new Profesor(
      rs.getString("nombre"),
      new File(rs.getString("temario")),
      null,
      null
      );
      prof.setId(rs.getInt("idProfesor"));
      grupo.setProfesor(prof);
    }
    conex.close();
  }

  public void asignarUnidadDeAprendizaje(Grupo grupo) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM "); // INNNER para obtener al autor

    if(rs.next())
    {//String nombre, File temario, float creditos,Vector profesores, Vector grupos
      UnidadDeAprendizaje ua = new UnidadDeAprendizaje(
      rs.getString("nombre"),
      new File(rs.getString("temario")),
      rs.getFloat("creditos"),
      null,
      null
      );
      ua.setId(rs.getInt("idUA"));
      grupo.setUa(ua);
    }
    conex.close();
  }

  //Leer un unico Grupo de la lista
  public Grupo read(int id)
  {
    return listaGrupos.get(id);
  }

  //Leer todos los Grupos
  public Vector<Grupo> read()
  {
    return listaGrupos;
  }

  //Crear un nuevo Grupo
  public void create(Grupo c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaGrupos.add(c);

    try{
      //
      String sql = "INSERT into Grupo(nombre) VALUES (?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un Grupo
  public void update(int id, Grupo t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Grupo c = listaGrupos.get(id);

    try{
      String sql = "UPDATE Grupo "+
      "SET nombre = '"+t.getNombre()+
      "' WHERE idGrupo = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
    t.setId(c.getId());
    listaGrupos.set(id, t);
  }

  //Eliminar un Grupo
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Grupo c = listaGrupos.get(id);

    try{
      String sql = "DELETE FROM Grupo WHERE idGrupo = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaGrupos.removeElementAt(id);
  }


  public Connection getConnection()
  {
    try{

      Class.forName("com.mysql.jdbc.Driver");

      return DriverManager.getConnection(dao.url+dao.dbName, "root", "" );


    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(ClassNotFoundException cl){
      cl.printStackTrace();
    }

    return null;
  }
}
