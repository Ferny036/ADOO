package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class ComentarioDAO extends Comentario implements DAOInterface<Comentario>
{
  public ComentarioDAO(String contenido, Date fecha, Alumno autor, Vector comentarios)
  {
    super(contenido, fecha, autor, comentarios);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conex = DriverManager.getConnection(url+dbName, "root", "" );
    Statement statement = conex.createStatement();
  }

  Comentario read(int id)
  {

  }

  Vector<Comentario> read()
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
