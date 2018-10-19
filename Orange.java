import java.util.Objects;
public class Orange extends Fruit{
  public String name;

  public Orange(){

  }
  public Orange(String name){
    this.name = name;
  }
  protected String getName(){
    return this.name;
  }
  public String toString(){
    return "Class name is:  " + this.getClass().getName()
         + "\nValue in the variable name is:  " + name;
  }
  public String getOrangeJuiceRecipe(){
    return "This is orange juice recipe";
  }
  public boolean equals(Object obj){
    if (obj instanceof Orange){
      return name.equals(((Orange)obj).name);
    }
    else {
      return false;
    }
  }
  public int hashCode(){
    return Objects.hash(name);
  }

}
