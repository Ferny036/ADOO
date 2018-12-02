package models;

import java.util.*;

public class Aula extends Lugar
{
  private String numeroSalon;
  private String numeroPiso;
  private String edificio;
  private Vector<Grupo> gruposAsignados;
  private int id;

  public Aula(String salon, String piso, String edificio,Vector<Grupo> grupos)
  {
    numeroSalon = salon;
    numeroPiso = piso;
    this.edificio = edificio;
    gruposAsignados = grupos;
  }

  public String getLugar()
  {
    return edificio + numeroPiso + numeroSalon;
  }

  public String getSalon()
  {
    return numeroSalon;
  }

  public String getPiso()
  {
    return numeroPiso;
  }

  public String getEdificio()
  {
    return edificio;
  }

  public Vector<Grupo> getGruposAsignados()
  {
    return gruposAsignados;
  }

  public int getId()
  {
      return id;
  }

  public void setNumeroSalon(String numeroSalon)
  {
     this.numeroSalon = numeroSalon;
  }

  public void setNumeroPiso(String numeroPiso)
  {
    this.numeroPiso = numeroPiso;
  }

  public void setEdificio(String edificio)
  {
   this.edificio = edificio;
  }

  public void setGruposAsignados(Vector<Grupo> gruposAsignados)
  {
   this.gruposAsignados = gruposAsignados;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}
