package models;

import java.util.*;
import java.io.File;

public class UnidadDeAprendizaje{

  private String nombre;
  private File temario;
  private float creditos;
  private int id;
  private Vector<Profesor> profesores;
  private Vector<Grupo> grupos;

  public UnidadDeAprendizaje(String nombre, File temario, float creditos,
                            Vector profesores, Vector grupos)
  {
    this.nombre = nombre;
    this.temario = temario;
    this.creditos = creditos;
    this.profesores = profesores;
    this.grupos = grupos;
  }

  public String getNombre()
  {
    return nombre;
  }

  public File getTemario()
  {
    return temario;
  }

  public float getCreditos()
  {
      return creditos;
  }

  public Vector<Profesor> getProfesores()
  {
    return profesores;
  }

  public Vector<Grupo> getGrupos()
  {
    return grupos;
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

  public void setTemario(File temario)
  {
    this.temario = temario;
  }

  public void setCreditos(float creditos)
  {
    this.creditos = creditos;
  }

  public void setProfesores(Vector<Profesor> profesores)
  {
    this.profesores = profesores;
  }

  public void setGrupos(Vector<Grupo> grupos)
  {
    this.grupos = grupos;
  }

}
