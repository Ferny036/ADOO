package models;

public abstract class Usuario
{
  protected int id;
  protected String nombre;
  protected String password;
  //protected String nickname;
  protected String email;

  public Usuario(String nombre, String password, String email)
  {
    this.nombre = nombre;
    this.password = password;
    this.email = email;
  }

  public abstract String getNombre();
  public abstract String getPassword();
  public abstract String getEmail();
  public abstract int getId();
  public abstract void setId(int id);
}
