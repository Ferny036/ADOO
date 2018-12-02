package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class HorarioDAO implements DAOInterface<Horario>
{
  Vector<Horario> listaHorarios;
  DAOInterface<Horario> dao;

  public HorarioDAO() throws SQLException
  {
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    listaHorarios = new Vector<Horario>();
    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Horario;");

    while(rs.next())
    {
      Horario m = new Horario(
        rs.getDate("horaInicio"),
        rs.getDate("horaFin")
      );
      m.setId(rs.getInt("idHorario"));

      listaHorarios.add(m);
    };
    conex.close();
  }

  //Leer un unico horario de la lista
  public Horario read(int id)
  {
    return listaHorarios.get(id);
  }

  //Leer todos los horarios
  public Vector<Horario> read()
  {
    return listaHorarios;
  }

  //Crear un nuevo horario
  public void create(Horario c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaHorarios.add(c);

    try{
      String sql = "INSERT into horario(horaInicio, horaFin) VALUES (?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setDate(1, c.getHoraInicio());
      ps.setDate(2, c.getHoraFin());
      ps.executeUpdate();
      ps.close();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un horario
  public void update(int id, Horario t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Horario c = read(id);

    try{
      String sql = "UPDATE Horario "+
      "SET horaInicio = '"+t.getHoraInicio()+"', horaFin = '"+t.getHoraFin()+
      "' WHERE idHorario = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }
    t.setId(c.getId());
    t.setHorario(c.getHoraInicio(), c.getHoraFin());
    listaHorarios.set(id, t);
  }

  //Eliminar un horario
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Horario c = read(id);

    try{
      String sql = "DELETE FROM Horario WHERE idHorario = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaHorarios.removeElementAt(id);
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
