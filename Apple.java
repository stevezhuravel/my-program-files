import java.util.Objects;
public class Apple extends Fruit{
  private String name;

  public Apple(){
  }
  public Apple(String name){
    this.name = name;
  }
  protected String getName(){
    return this.name;
  }
  public String toString(){
    return "Class name is:  " + this.getClass().getName()
         + "\nValue in the variable name is:  " + name;
  }
  public String getApplePieRecipe(){
    return "This is apple pie recipe";
  }
  public boolean equals(Object obj){
    if (obj instanceof Apple){
      return name.equals(((Apple)obj).name);
    }
    else {
      return false;
    }
  }
  public int hashCode(){
    return Objects.hash(name);
  }

}
