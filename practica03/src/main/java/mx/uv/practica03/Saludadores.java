@Entity
public class Saludadores{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Interger Id;
  private String nombre;
  
  public String getNombre(){
    return nombre;
  }
  
  public Interger getId(){
    return Id;
  }
  
  public void seId(Interger Id){
    this.Id = Id;
  }
  
  public void setNombre(String nombre){
    this.nombre = nombre
  }
  
}
