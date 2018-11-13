package models;

import java.util.*;

public class Horario
{
  private Date horaInicio;
  private Date horaFin;
  private int id;

  public Horario(Date inicio, Date fin)
  {
    horaInicio = inicio;
    horaFin = fin;
  }

  public String obtenerHorario()
  {
    return horaInicio + " " + horaFin;
  }

  public void setHorario(Date inicio, Date fin)
  {
      horaInicio = inicio;
      horaFin = fin;
  }


}
