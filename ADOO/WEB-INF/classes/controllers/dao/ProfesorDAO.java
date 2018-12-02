package dao;

import java.util.*;
import java.sql.*;
import java.io.*;
import models.*;


public class ProfesorDAO implements DAOInterface<Profesor>
{
  Vector<Profesor> listaProfesores;
  DAOInterface<Profesor> dao;

  public ProfesorDAO() throws SQLException
  {
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    listaProfesores = new Vector<Profesor>();
    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Profesor;");

    while(rs.next())
    {
      Profesor m = new Profesor(
      rs.getString("nombre"),
      new File(rs.getString("curriculum")),
      new Vector<Grupo>(),
      new Vector<UnidadDeAprendizaje>()
      );
      m.setId(rs.getInt("idProfesor"));
      asignarUnidadesDeAprendizaje(m);
      asignarGrupos(m);
      listaProfesores.add(m);
    }
    conex.close();
  }

  public void asignarUnidadesDeAprendizaje(Profesor prof) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ");

    while(rs.next())
    {
      UnidadDeAprendizaje ua = new UnidadDeAprendizaje(
      rs.getString("nombre"),
      new File(rs.getString("temario")),
      rs.getFloat("creditos"),
      null,
      null
      );
      ua.setId(rs.getInt("idUA"));
      prof.getUnidadesDeAprendizajeAsignadas().add(ua);
    }
    conex.close();
  }

  public void asignarGrupos(Profesor prof) throws SQLException
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
      prof.getGruposAsignados().add(grupo);
    }
    conex.close();
  }

  //Leer un unico profesor de la lista
  public Profesor read(int id)
  {
    return listaProfesores.get(id);
  }

  //Leer todos los profesores
  public Vector<Profesor> read()
  {
    return listaProfesores;
  }

  //Crear un nuevo profesor
  public void create(Profesor c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaProfesores.add(c);

    try{
      String sql = "INSERT into profesor(nombre, curriculum) VALUES (?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.setString(2, c.getCurriculum().getCanonicalPath());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(IOException io){
      io.printStackTrace();
    }
  }

  //Editar un profesor
  public void update(int id, Profesor t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Profesor c = read(id);

    try{
      String sql = "UPDATE Profesor "+
      "SET nombre = '"+t.getNombre()+"', curriculum = '"+t.getCurriculum().getCanonicalPath()+
      "' WHERE idProfesor = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }catch(IOException io){
      io.printStackTrace();
    }
    t.setId(c.getId());
    t.setUnidadesDeAprendizajeAsignadas(c.getUnidadesDeAprendizajeAsignadas());
    t.setGruposAsignados(c.getGruposAsignados());
    listaProfesores.set(id, t);
  }

  //Eliminar un profesor
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Profesor c = read(id);

    try{
      String sql = "DELETE FROM Profesor WHERE idProfesor = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaProfesores.removeElementAt(id);
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
