package dao;

import java.util.*;

public class AlumnoDAO extends Alumno implements DAOInterface
{
  public  AlumnoDAO(String nombre, String password, String email, String boleta,
                String apellidoMaterno, String apellidoPaterno, Vector pub)
  {
    super(nombre, password, email, boleta, apellidoMaterno, apellidoPaterno, pub);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conex = DriverManager.getConnection(url+dbName, "root", "" );
    Statement statement = conex.createStatement();
  }

  Alumno read(int id)
  {
    this();
  }

  Vector<Alumno> read()
  {

  }

  void create()
  {

  }

  void update(int id)
  {

  }

  void delete(int id)
  {

  }
}
