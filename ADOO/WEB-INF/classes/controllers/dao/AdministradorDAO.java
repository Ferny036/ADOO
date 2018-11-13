package dao;

import java.util.*;
import java.sql.*;
import models.*;

public class AdministradorDAO extends Administrador implements DAOInterface
{

  public AdministradorDAO(String nombre, String password, String email)
  {
      super(nombre, password, email);
      Class.forName("com.mysql.jdbc.Driver");
      Connection conex = DriverManager.getConnection(url+dbName, "root", "" );
      Statement statement = conex.createStatement();
  }

  Administrador read(int id)
  {

  }
  //DAdo que no existe mas q un administrador no es necesario llamar a todos los registros
  Vector<Administrador> read()
  {}

  //Un administrador no puede ser creado
  void create()
  {}

  void update(int id)
  {

  }

  //No puedes eliminar el administrador
  void delete(int id)
  {

  }
}
