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

  public Vector<Grupo> getGruposAsignados()
  {
    return gruposAsignados;
  }

}
