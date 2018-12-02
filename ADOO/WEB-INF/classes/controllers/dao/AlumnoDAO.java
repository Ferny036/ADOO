package dao;

import java.util.*;
import java.sql.*;
import models.*;

public class AlumnoDAO implements DAOInterface<Alumno>
{

  Vector<Alumno> listaAlumnos;
  DAOInterface<Alumno> dao;

  public AlumnoDAO() throws SQLException
  {

    listaAlumnos = new Vector<Alumno>();
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM alumno;");
    while(rs.next()){
      Alumno al = new Alumno(
      rs.getString("nombre"),
      rs.getString("password"),
      rs.getString("email"),
      rs.getString("boleta"),
      rs.getString("apellidoMaterno"),
      rs.getString("apellidoPaterno"),
      new Vector<Publicacion>()
      );
      al.setId(rs.getInt("idAlumno"));
      asignarPublicaciones(al);
      listaAlumnos.add(al);

    }

    conex.close();
  }

  public void asignarPublicaciones(Alumno al)  throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM alumno;");//INNER con publicacionesRealizadas
    while(rs.next()){
      Publicacion publicacion = new Publicacion(
      rs.getString("contenido"),
      rs.getDate("fecha"),
      al,
      null
      );
      publicacion.setId(rs.getInt("idPublicacion"));
      al.getPublicacionesRealizadas().add(publicacion);
    }
    conex.close();
  }

  //Establecer conexion
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

  //Leer un unico alumno de la lista
  public Alumno read(int id)
  {
    return listaAlumnos.get(id);
  }

  //Leer todos los alumnos
  public Vector<Alumno> read()
  {
    return listaAlumnos;
  }

  //Crear un nuevo alumno
  public void create(Alumno c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaAlumnos.add(c);

    try{
      String sql = "INSERT into alumno(nombre, password, email, boleta, "
      +"apellidoMaterno, apellidoPaterno) VALUES (?,?,?,?,?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.setString(2, c.getPassword());
      ps.setString(3, c.getEmail());
      ps.setString(4, c.getBoleta());
      ps.setString(5, c.getApellidoMaterno());
      ps.setString(6, c.getApellidoPaterno());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un alumno
  public void update(int id, Alumno t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Alumno c = read(id);

    try{
      String sql = "UPDATE alumno "+
      "SET nombre = ?, apellidoMaterno = ?, apellidoPaterno = ?, "
      +"email = ?, password = ? WHERE idAlumno = ?";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, t.getNombre());
      ps.setString(2, t.getApellidoMaterno());
      ps.setString(3, t.getApellidoPaterno());
      ps.setString(4, t.getEmail());
      ps.setString(5, t.getPassword());
      ps.setInt(6, c.getId());
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
    t.setPublicacionesRealizadas(c.getPublicacionesRealizadas());
    t.setId(c.getId());
    listaAlumnos.set(id, t);
  }

  //Eliminar un alumno
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Alumno c = read(id);

    try{
      String sql = "DELETE FROM alumno WHERE idAlumno = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaAlumnos.removeElementAt(id);
  }

}
