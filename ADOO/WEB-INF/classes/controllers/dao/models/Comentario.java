package models;

import java.util.*;

public class Comentario
{

  private String contenido;
  private Date fecha;
  private Vector<Comentario> comentarios;
  private Alumno autor;

  public Comentario(String contenido, Date fecha, Alumno autor, Vector comentarios)
  {
    this.contenido=contenido;
    this.fecha=fecha;
    this.autor = autor;
    this.comentarios = comentarios;
  }


  public String getContenido()
  {
    return contenido;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public Vector<Comentario> getComentarios()
  {
    return comentarios;
  }

  public Alumno getAutor()
  {
    return autor;
  }
}
