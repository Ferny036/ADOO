package models;

import java.util.*;
import java.sql.Date;

public class Evento
{
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Horario hora[];
    private int id;

    public Evento(String nombre, String descripcion, Date fecha, Horario hora[]) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public Horario[] getHora()
    {
        return hora;
    }

    public int getId()
    {
        return id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public void setHora(Horario hora[])
    {
        this.hora = hora;
    }

    public void setId(int id)
    {
      this.id = id;
    }
}
