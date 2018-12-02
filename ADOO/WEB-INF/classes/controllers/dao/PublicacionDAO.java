package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class PublicacionDAO implements DAOInterface<Publicacion>
{
  Vector<Publicacion> listaPublicaciones;
  DAOInterface<Publicacion> dao;

  public PublicacionDAO() throws SQLException
  {
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;
    listaPublicaciones = new Vector<Publicacion>();

    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Publicacion;");

    while(rs.next())
    {
      Publicacion p = new Publicacion(
      rs.getString("contenido"),
      rs.getDate("Fecha"),
      null,
      null
      );
      p.setId(rs.getInt("idPublicacion"));

      asignarAutor(p);
      asignarComentarios(p);

    }
    conex.close();
  }

  public void asignarAutor(Publicacion p) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM "); // INNNER para obtener al autor

    if(rs.next())
    {
      Alumno al = new Alumno(
      rs.getString("nombre"),
      rs.getString("password"),
      rs.getString("email"),
      rs.getString("boleta"),
      rs.getString("apellidoMaterno"),
      rs.getString("apellidoPaterno"),
      null
      );
      al.setId(rs.getInt("idAlumno"));
      p.setAutor(al);
    }
    conex.close();
  }

  public void asignarComentarios(Publicacion pub) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ");

    while(rs.next())
    {
      Comentario com = new Comentario(
      rs.getString("contenido"),
      rs.getDate("fecha"),
      null,
      null
      );
      com.setId(rs.getInt("idComentario"));
      pub.getComentarios().add(com);
    }
    conex.close();
  }

  //Leer una publicacion
  public Publicacion read(int id)
  {
    return listaPublicaciones.get(id);
  }
  //Leer todas las publicaciones
  public Vector<Publicacion> read()
  {
    return listaPublicaciones;
  }

  //Crear
  public void create(Publicacion c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaPublicaciones.add(c);

    try{
      String sql = "INSERT into publicacion(contenido, fecha) VALUES (?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getContenido());
      ps.setDate(2, c.getFecha());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar
  public void update(int id, Publicacion t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Publicacion c = read(id);

    try{
      String sql = "UPDATE Publicacion "+
      "SET contenido = '"+t.getContenido()+"', fecha = '"+t.getFecha()+
      "' WHERE idPublicacion = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    t.setId(c.getId());
    t.setComentarios(c.getComentarios());
    t.setAutor(c.getAutor());
    listaPublicaciones.set(id, t);
  }

  //Eliminar
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Publicacion c = read(id);

    try{
      String sql = "DELETE FROM Publicacion WHERE idPublicacion = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaPublicaciones.removeElementAt(id);
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
