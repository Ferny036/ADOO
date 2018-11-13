package dao;

import java.util.*;
import com.models.*;

public class AulaDAO extends Aula implements DAOInterface<Aula>
{
  public AulaDAO(String salon, String piso, String edificio,Vector<Grupo> grupos)
  {
    super(salon, piso, edificio, grupos);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conex = DriverManager.getConnection(url+dbName, "root", "" );
    Statement statement = conex.createStatement();
  }

  Aula read(int id)
  {

  }

  Vector<Aula> read()
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
