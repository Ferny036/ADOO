package models;

import java.sql.Date;
import java.util.*;

public class Comentario
{

  private String contenido;
  private Date fecha;
  private Vector<Comentario> comentarios;
  private Alumno autor;
  private int id;

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

  public int getId()
  {
      return id;
  }

  public void setAutor(Alumno autor)
  {
    this.autor = autor;
  }

  public void setContenido(String contenido)
  {
      this.contenido = contenido;
  }

  public void setComentarios(Vector<Comentario> comentarios)
  {
    this.comentarios = comentarios;
  }

  public void setFecha(Date fecha)
  {
      this.fecha = fecha;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}
