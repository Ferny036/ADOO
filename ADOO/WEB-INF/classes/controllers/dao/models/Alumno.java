package models;

import java.util.*;

public class Alumno extends Usuario
{

  private String boleta;
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
    return nombre + " " + apellidoMaterno + " " + apellidoPaterno;
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
}
