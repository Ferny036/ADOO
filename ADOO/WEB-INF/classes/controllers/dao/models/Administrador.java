package models;

public class Administrador extends Usuario{

  public Administrador(String nombre, String password, String email){
    super(nombre, password, email);
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmail()
  {
    return email;
  }

  public int getId()
  {
    return id;
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

   public void setId(int id)
   {
     this.id = id;
   }
}
