package models;

public class Club
{
  private String nombre;
  private float creditos;
  private Horario hora[];
  private int id;

  public Club(String nombre, float creditos, Horario hora[])
  {
    this.nombre=nombre;
    this.creditos=creditos;
    this.hora = hora;
  }

  public String getNombre()
  {
    return nombre;
  }

  public float getCreditos()
  {
    return creditos;
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

  public void setCreditos(float creditos)
  {
    this.creditos = creditos;
  }

  public void setHora(Horario[] hora)
  {
    this.hora = hora;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}
