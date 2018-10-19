import java.util.Objects;
public final class McIntosh extends Apple{
  private String name;

  public McIntosh(){

  }
  public McIntosh(String myName){
    name = myName;
  }
  public String toString(){
    return "Class name is:  " + this.getClass().getName()
         + "\nValue in the variable name is:  " + name;
  }
  public boolean equals(Object obj){
    if (obj instanceof McIntosh){
      return name.equals(((McIntosh)obj).name);
    }
    else{
      return false;
    }
  }
  public int hashCode(){
    return Objects.hash(name);
  }

}
