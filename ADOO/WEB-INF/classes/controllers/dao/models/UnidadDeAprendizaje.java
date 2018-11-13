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

  public void setId(int id)
  {
      this.id = id;
  }
}
