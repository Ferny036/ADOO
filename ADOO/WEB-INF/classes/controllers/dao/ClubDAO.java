package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class ClubDAO implements DAOInterface<Club>
{

  Vector<Club> listaClubs;
  DAOInterface<Club> dao;

  public ClubDAO() throws SQLException
  {
    listaClubs = new Vector<Club>();
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = null;

    rs = statement.executeQuery("SELECT * FROM Club;");

    while(rs.next())
    {
      //String nombre, float creditos, Horario hora[]
      Club m = new Club(
      rs.getString("nombre"),
      rs.getFloat("creditos"),
      new Horario[5]
      );
      m.setId(rs.getInt("idClub"));
      asignarHorario(m);
      listaClubs.add(m);
    }
    conex.close();
  }

  public void asignarHorario(Club m) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = null;

    rs = statement.executeQuery("SELECT * FROM Club;"); // INNER de horarios

    int index = 0;
    while(rs.next())
    {
      (m.getHora())[index] = new Horario(
      rs.getDate("hInicio"),
      rs.getDate("hFin")
      );
      (m.getHora())[index].setId(rs.getInt("idHorario"));
      index++;
    }
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

  public Club read(int id)
  {
    return listaClubs.get(id);
  }

  public Vector<Club> read()
  {
    return listaClubs;
  }


  //Crear un nuevo Club
  public void create(Club c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaClubs.add(c);

    try{//String nombre, float creditos

      String sql = "INSERT into Club(nombre, creditos) VALUES (?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.setFloat(2, c.getCreditos());
      ps.executeUpdate();
      ps.close();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un Club
  public void update(int id, Club t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Club c = read(id);

    try{
      String sql = "UPDATE Club "+
      "SET nombre = '"+t.getNombre()+"', creditos = '"+t.getCreditos()+
      "' WHERE idClub = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    t.setId(c.getId());
    t.setHora(c.getHora());
    listaClubs.set(id, t);
  }

  //Eliminar un Club
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Club c = read(id);

    try{
      String sql = "DELETE FROM Club WHERE idClub = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();//

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaClubs.removeElementAt(c.getId());
  }

}
