package models;

import java.util.*;

public class Alumno extends Usuario
{

  private String boleta;
  private int id;
  private String apellidoMaterno;
  private String apellidoPaterno;
  private Vector<Publicacion> publicacionesRealizadas;
  //private String descripcion;

  public Alumno(String nombre, String password, String email, String boleta,
                String apellidoMaterno, String apellidoPaterno, Vector pub)
  {
    super(nombre, password, email);
    this.boleta = boleta;
    this.apellidoMaterno = apellidoMaterno;
    this.apellidoPaterno = apellidoPaterno;
    publicacionesRealizadas = pub;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getApellidoMaterno()
  {
    return apellidoMaterno;
  }

  public String getApellidoPaterno()
  {
    return apellidoMaterno;
  }

  public String getNombreCompleto()
  {
    return nombre + " " + apellidoPaterno + " " + apellidoPaterno;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmail()
  {
    return email;
  }

  public String getBoleta()
  {
    return boleta;
  }

  public Vector<Publicacion> getPublicacionesRealizadas()
  {
      return publicacionesRealizadas;
  }

  public int getId()
  {
      return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }

  public void setApellidoMaterno(String apellidoMaterno)
  {
      this.apellidoMaterno = apellidoMaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno)
  {
      this.apellidoPaterno = apellidoPaterno;
  }

  public void setNombre(String nombre)
  {
      this.nombre = nombre;
  }

  public void setPassword(String password)
  {
      this.password = password;
  }

  public void setEmail(String email)
  {
      this.email = email;
  }

  public void setPublicacionesRealizadas(Vector<Publicacion> publicacionesRealizadas)
  {
      this.publicacionesRealizadas = publicacionesRealizadas;
  }

  public void setBoleta(String boleta)
  {
      this.boleta = boleta;
  }
}
