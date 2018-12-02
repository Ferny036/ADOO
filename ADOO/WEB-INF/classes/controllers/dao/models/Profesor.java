package models;

import java.util.*;
import java.io.File;

public class Profesor
{

  private String nombre;
  private File curriculum;
  private int id;
  private Vector<UnidadDeAprendizaje> unidadesDeAprendizajeAsignadas;
  private Vector<Grupo> gruposAsignados;
  public Profesor(String nombre, File curriculum, Vector<Grupo> grupos,
                  Vector<UnidadDeAprendizaje> uas)
  {
    this.nombre = nombre;
    this.curriculum = curriculum;
    this.gruposAsignados = grupos;
    this.unidadesDeAprendizajeAsignadas = uas;
  }

  public File getCurriculum()
  {
      return curriculum;
  }

  public String getNombre()
  {
    return nombre;
  }

  public Vector<UnidadDeAprendizaje> getUAS()
  {
    return unidadesDeAprendizajeAsignadas;
  }

  public Vector<Grupo> getGruposAsignados()
  {
    return gruposAsignados;
  }

  public Vector<UnidadDeAprendizaje> getUnidadesDeAprendizajeAsignadas()
  {
    return unidadesDeAprendizajeAsignadas;
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

  public void setCurriculum(File curriculum)
  {
    this.curriculum = curriculum;
  }

  public void setUnidadesDeAprendizajeAsignadas(Vector<UnidadDeAprendizaje> unidadesDeAprendizajeAsignadas)
  {
    this.unidadesDeAprendizajeAsignadas = unidadesDeAprendizajeAsignadas;
  }

  public void setGruposAsignados(Vector<Grupo> gruposAsignados)
  {
    this.gruposAsignados = gruposAsignados;
  }
}
