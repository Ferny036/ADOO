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

  public void setId(int id)
  {
      this.id = id;
  }

}
