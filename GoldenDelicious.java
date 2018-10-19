import java.util.Objects;
public final class GoldenDelicious extends Apple{
  private String name;

  public GoldenDelicious(){

  }
  public GoldenDelicious(String myName){
    name = myName;
  }
  public String toString(){
    return "Class name is:  " + this.getClass().getName()
         + "\nValue in the variable name is:  " + name;
  }
  public boolean equals(Object obj){
    if (obj instanceof GoldenDelicious){
      return name.equals(((GoldenDelicious)obj).name);
    }
    else{
      return false;
    }
  }
  public int hashCode(){
    return Objects.hash(name);
  }
}
