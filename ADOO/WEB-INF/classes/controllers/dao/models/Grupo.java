package models;

import java.util.*;

public class Grupo
{
  private int id;
  private String nombre;
  private UnidadDeAprendizaje ua;
  private Vector<Horario> horario;
  private Profesor profesor;

  public Grupo(String nombre, UnidadDeAprendizaje ua, Vector<Horario> horario, Profesor profesor)
  {
    this.nombre = nombre;
    this.ua = ua;
    this.horario = horario;
    this.profesor = profesor;

  }

  public String getNombre()
  {
    return nombre;
  }

  public int getId()
  {
      return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
   }

  public void setUa(UnidadDeAprendizaje ua)
  {
    this.ua = ua;
  }

  public void setHorario(Vector<Horario> horario)
  {
    this.horario = horario;
  }

  public void setProfesor(Profesor profesor)
  {
    this.profesor = profesor;
  }

  public UnidadDeAprendizaje getUa()
  {
    return ua;
  }

  public Vector<Horario> getHorario()
  {
    return horario;
  }

  public Profesor getProfesor()
  {
    return profesor;
  }
}
