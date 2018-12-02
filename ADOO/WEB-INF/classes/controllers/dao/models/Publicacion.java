package models;

import java.util.*;
import java.sql.Date;

public class Publicacion
{
    private int id;
    private String contenido;
    private Date fecha;
    private Alumno autor;
    private Vector<Comentario> comentarios;


    public Publicacion(String contenido, Date fecha, Alumno autor, Vector comentarios)
    {
      this.contenido=contenido;
      this.fecha=fecha;
      this.autor=autor;
      this.comentarios=comentarios;
    }

    public String getContenido()
    {
      return contenido;
    }

    public Date getFecha()
    {
      return fecha;
    }

    public Alumno getAutor()
    {
      return autor;
    }

    public Vector<Comentario> getComentarios()
    {
      return comentarios;
    }

    public int getId()
    {
        return id;
    }

    public void setComentarios(Vector<Comentario> comentarios)
    {
        this.comentarios = comentarios;
    }

    public void setAutor(Alumno autor)
    {
      this.autor = autor;
    }

    public void setContenido(String contenido)
    {
        this.contenido = contenido;
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
