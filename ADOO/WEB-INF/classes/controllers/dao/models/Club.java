package models;

public class Club
{
  private String nombre;
  private float creditos;
  private Horario hora[];

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
}
