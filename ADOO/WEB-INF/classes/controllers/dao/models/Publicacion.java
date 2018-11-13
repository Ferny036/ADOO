package models;

import java.util.*;

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

}
