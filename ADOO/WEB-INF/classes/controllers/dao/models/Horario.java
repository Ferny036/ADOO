package models;

import java.util.*;
import java.sql.Date;

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

  public int getId()
  {
      return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public Date getHoraInicio()
  {
    return horaInicio;
  }

  public Date getHoraFin()
  {
    return horaFin;
  }


  public void setHorario(Date inicio, Date fin)
  {
      horaInicio = inicio;
      horaFin = fin;
  }

  public void setHoraInicio(Date inicio)
  {
    horaInicio = inicio;
  }

  public void setHoraFin(Date fin)
  {
    horaFin = fin;
  }

}
