package models;

public class EspacioExterior extends Lugar
{
  private String ubicacion;
  private int id;
  //private String descripcion;

  public EspacioExterior(String ubicacion)
  {
    super();
    this.ubicacion = ubicacion;
  }

  public String getLugar()
  {
      return ubicacion;
  }

  public int getId()
  {
      return id;
  }

  public void setLugar()
  {
      this.ubicacion=ubicacion;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}
