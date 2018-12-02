package dao;

import java.util.*;
import java.sql.*;
import models.*;

public class AulaDAO implements DAOInterface<Aula>
{

  Vector<Aula> listaAulas;
  DAOInterface dao;

  public AulaDAO() throws SQLException
  {//String salon, String piso, String edificio,Vector<Grupo> grupos
    listaAulas = new Vector<Aula>();
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM Aula;");
    while(rs.next())
    {
      Aula t = new Aula(
      rs.getString("salon"),
      rs.getString("piso"),
      rs.getString("edificio"),
      new Vector<Grupo>()
      );
      t.setId(rs.getInt("idAula"));
      asignarGrupos(t);
      listaAulas.add(t);
    }
  }

  public void asignarGrupos(Aula t) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM Aula;"); //INNER
    while(rs.next())
    {
      Grupo grupo = new Grupo(
      rs.getString("nombre"),
      null,
      null,
      null
      );
      grupo.setId(rs.getInt("idGrupo"));
      t.getGruposAsignados().add(grupo);
    }
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

  //Leer un unico Aula de la lista
  public Aula read(int id)
  {
    return listaAulas.get(id);
  }

  //Leer todos los Aulas
  public Vector<Aula> read()
  {
    return listaAulas;
  }

  //Crear un nuevo Aula
  //String salon, String piso, String edificio
  public void create(Aula c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaAulas.add(c);

    try{
      String sql = "INSERT into Aula(salon, piso, edificio) VALUES (?,?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getSalon());
      ps.setString(2, c.getPiso());
      ps.setString(3, c.getEdificio());
      ps.executeUpdate();
      ps.close();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un aula
  //String salon, String piso, String edificio
  public void update(int id, Aula t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Aula c = read(id);

    try{
      String sql = "UPDATE Aula "
      +"SET salon = ?, piso = ?, edificio = ? "
      +"WHERE idAula = ?";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, t.getSalon());
      ps.setString(2, t.getPiso());
      ps.setString(3, t.getEdificio());
      ps.setInt(4, c.getId());
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    t.setGruposAsignados(c.getGruposAsignados());
    t.setId(c.getId());
    listaAulas.set(id, t);
  }

  //Eliminar un Aula
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Aula c = read(id);

    try{
      String sql = "DELETE FROM Aula WHERE idAula = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaAulas.removeElementAt(id);
  }
}
