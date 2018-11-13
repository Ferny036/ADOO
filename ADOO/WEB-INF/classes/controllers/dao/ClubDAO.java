package dao;

import java.util.*;
import models.*;

public class ClubDAO extends Club implements DAOInterface<Club>
{

  public ClubDAO(String nombre, float creditos, Horario hora[])
  {
    super(nombre, creditos, hora);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conex = DriverManager.getConnection(url+dbName, "root", "" );
    Statement statement = conex.createStatement();
  }

  Club read(int id)
  {

  }

  Vector<Club> read()
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
