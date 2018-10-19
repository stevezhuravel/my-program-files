import java.util.ArrayList;
import java.util.*;

public class FruitClientclass{
  public static void main (String[]args){

    ArrayList<Fruit> fruitList = new ArrayList<>();
    Fruit f1 = new Fruit("peach");
    Fruit f2 = new Fruit("mango");
    Orange f3 = new Orange("goli");
    fruitList.add(f1);
    fruitList.add(f2);
    fruitList.add(f3);

    //fruitList.add(new Apple("blue"));
    //fruitList.add(new Fruit("bannana"));
    //fruitList.add(new Orange("apple"));

    System.out.println(f1.equals(f1));
    System.out.println(f1.hashCode());
    System.out.println(f2.hashCode());
    System.out.println("-------------------");

    for (int i = 0; i < fruitList.size(); i++){
      System.out.println(fruitList.get(i));
    }
    Fruit randomObject1 = fruitList.get(new Random().nextInt(fruitList.size()));
    Fruit randomObject2 = fruitList.get(new Random().nextInt(fruitList.size()));
    System.out.println(randomObject1.hashCode());
    System.out.println(randomObject2.hashCode());
    System.out.println(randomObject1);
    System.out.println(randomObject2);
    System.out.println(randomObject1.equals(randomObject1));
    //System.out.println("cities: " +fruitList);
  } ///////////////////////////////////////////main method brace
  // method to print referenced object
  public static Fruit getRandom(List<Fruit> fruits) {
    return fruits.get(new Random().nextInt(fruits.size()));
  }
  //public Fruit anyFruit(){
  //  int index = (int)(Math.random() * fruitList.size());
  //  fruitList.get(index);
  //}

}
