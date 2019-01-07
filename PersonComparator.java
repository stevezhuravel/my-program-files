import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{



  public int compare(Person p1, Person p2){



    if(p1.getLastName().compareTo(p2.getLastName())>0)

    return 1;



    else if(p1.getLastName().compareTo(p2.getLastName())<0)

    return -1;



    else

    return 0;

  }

}
