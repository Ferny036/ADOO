package dao;

import java.util.*;
import models.*;
import java.sql.*;

public class EventoDAO implements DAOInterface<Evento>
{
  Vector<Evento> listaEventos;
  DAOInterface<Evento> dao;

  public EventoDAO() throws SQLException
  {
    Connection conex = null;
    Statement statement = null;
    ResultSet rs = null;

    listaEventos = new Vector<Evento>();
    conex = getConnection();
    statement = conex.createStatement();

    rs = statement.executeQuery("SELECT * FROM Evento;");

    while(rs.next())
    {
      Evento m = new Evento(
      rs.getString("nombre"),
      rs.getString("descripcion"),
      rs.getDate("fecha"),
      null
      );
      m.setId(rs.getInt("idEvento"));

      asignarHorario(m);

      listaEventos.add(m);
    };
    conex.close();
  }

  public void asignarHorario(Evento ev) throws SQLException
  {
    Connection conex = getConnection();
    Statement statement = conex.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ");

    int index = 0;
    while(rs.next())
    {
      Horario horario = new Horario(
      rs.getDate("horaInicio"),
      rs.getDate("horaFin")
      );
      horario.setId(rs.getInt("idHorario"));
      (ev.getHora()[index]) = horario;
      conex.close();
    }
  }

  //Leer un unico evento de la lista
  public Evento read(int id)
  {
    return listaEventos.get(id);
  }

  //Leer todos los eventos
  public Vector<Evento> read()
  {
    return listaEventos;
  }

  //Crear un nuevo evento
  public void create(Evento c)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;

    listaEventos.add(c);

    try{
      String sql = "INSERT into evento(nombre, descripcion, fecha) VALUES (?,?,?)";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.setString(1, c.getNombre());
      ps.setString(2, c.getDescripcion());
      ps.setDate(3, c.getFecha());
      ps.executeUpdate();
      ps.close();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }
  }

  //Editar un evento
  public void update(int id, Evento t)
  {
    Connection conex = null;
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Evento c = read(id);

    try{
      String sql = "UPDATE Evento "+
      "SET nombre = '"+t.getNombre()+"', descripcion = '"+t.getDescripcion()+"', fecha = '"+t.getFecha()+
      "' WHERE idEvento = "+c.getId()+";";
      conex = getConnection();
      ps = conex.prepareStatement(sql);
      ps.executeUpdate();
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    t.setHora(c.getHora());
    t.setId(c.getId());
    listaEventos.set(id, t);
  }

  //Eliminar un evento
  public void delete(int id)
  {
    Connection conex = null;
    Statement statement = null;

    Evento c = read(id);

    try{
      String sql = "DELETE FROM Evento WHERE idEvento = "+c.getId()+";";
      conex = getConnection();
      statement = conex.createStatement();
      statement.executeUpdate(sql);
      conex.close();

    }catch(SQLException sql){
      sql.printStackTrace();
    }

    listaEventos.removeElementAt(id);
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
