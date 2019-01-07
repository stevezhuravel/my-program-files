import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.NoSuchElementException;
public class Client{

  public static void main(String[] args) {

    File file = new File(args[0]);

    String line;

    ArrayList<String> datafield = new ArrayList<String>();

    LinkedList<Person> person = new LinkedList<Person>();

    ArrayList<String> comment = new ArrayList<String>();

    try(Scanner read = new Scanner(file);){



      while(read.hasNextLine()){

        line = read.nextLine();

        datafield.add(line);

      }

      toPersonList(datafield, person);

      Collections.sort(person, new PersonComparator());



    }catch(FileNotFoundException e){

      System.err.println(e.getMessage());

    }

    while(true){

      Scanner input = new Scanner(System.in);

      System.out.println("==================================================");

      System.out.println("[1]Search FirstName\n[2]Search LastName\n[3]Search MemberType\n[4]Search Mentor Name\n[5]Edit or Delete\n[6]Set Comment for Student\n[7]check Comment\n[8]Add Entry\n[9]PrintAll\n[0]Exit");

      int s1 = input.nextInt();

      if(s1==1){

        System.out.println("==================================================");

          searchByFirstname(person);

      }

      else if(s1==2){

        System.out.println("==================================================");

          searchByLastname(person);

        }

      else if(s1==3){

        System.out.println("==================================================");

        System.out.println("Enter Searching Type : \n[1]Graduate Student\n[2]Undergraduate Student\n[3]Mentor\n[4]Advisor");

        int s2 = input.nextInt();

        if(s2==1){

          System.out.println("==================================================");

          for(Person p:person){

            searchGraduate(p);

          }

        }

        else if(s2==2){

          System.out.println("==================================================");

          for(Person p :person){

            searchUnderGraduate(p);

          }

        }

        else if(s2==3){

          System.out.println("==================================================");

          for(Person p:person){

            searchMentor(p);

          }

        }

        else if(s2==4){

          System.out.println("==================================================");

          for(Person p :person){

            searchAdvisor(p);

          }

        }

        else{

          continue;

        }

      }

      else if(s1==4){

        System.out.println("==================================================");

        searchbyMentor(person);

      }

      else if(s1==5){

        System.out.println("==================================================");

        editORdelete(person);

      }

      else if(s1==6){

        System.out.println("==================================================");

        giveComment(person);

      }



      else if(s1==7){

        viewComment(person);

      }

      else if(s1==8){

        System.out.println("==================================================");

        addEntry(person);

      }

      else if(s1==9){

        System.out.println("==================================================");

        for(Person p: person){

          System.out.println(p.toString());

        }

      }

      else if(s1==0){

        System.exit(0);

      }

      else{

        System.out.println("Entry Error, Re-enter");

        continue;

      }



      try(PrintWriter write = new PrintWriter(file);){

        for(Person p: person){

          write.println(p.getLastName()+"/"+p.getFirstName()+"/"+p.getId()+"/"+p.getMembertype()+"/"+p.getMentorName()+"/"+p.getPhoneNumber()+"/"+p.getAddress()+"/"+p.getComment()+"/"+p.getPing());

        }

      }catch(FileNotFoundException e){

        System.out.println(e.getMessage());

      }

    }

  }

  public static void toPersonList(List<String> datafield, List<Person> person){



    String data = "";

    String[] s1;

    for(int i = 0 ; i<datafield.size();i++){

      data=datafield.get(i);

      s1 = data.split("\\/");

      Person p1;

      int pinging = Integer.valueOf(s1[8]);

      int id =Integer.valueOf(s1[2]);

      if(s1[3].equalsIgnoreCase("Graduate Student")){

        p1 = new GraduateStudent(s1[0], s1[1], id, s1[3], s1[4], s1[5], s1[6], s1[7],pinging);

        person.add(p1);

      }

      else if(s1[3].equalsIgnoreCase("Undergraduate Student")){

        p1 = new UndergraduateStudent(s1[0], s1[1], id, s1[3], s1[4], s1[5], s1[6], s1[7],pinging);

        person.add(p1);

      }

      else if(s1[3].equalsIgnoreCase("Mentor")){

        p1 = new Mentor(s1[0], s1[1], id, s1[3], s1[4], s1[5], s1[6], s1[7],pinging);

        person.add(p1);

      }

      else if(s1[3].equalsIgnoreCase("Advisor")){

        p1 = new Advisor(s1[0], s1[1], id, s1[3], s1[4], s1[5], s1[6], s1[7],pinging);

        person.add(p1);

      }

    }



  }

  public static void searchGraduate(Person person){

    Scanner input = new Scanner(System.in);

    if(person.getMembertype().equalsIgnoreCase("Graduate Student")){

      System.out.println(person.toString());

    }

  }

  public static void searchUnderGraduate(Person person){

    Scanner input = new Scanner(System.in);

    if(person.getMembertype().equalsIgnoreCase("Undergraduate Student")){

      System.out.println(person.toString());

    }

  }

  public static void searchMentor(Person person){

    Scanner input = new Scanner(System.in);

      if(person.getMembertype().equalsIgnoreCase("Mentor")){

        System.out.println(person.toString());

      }

    }

  public static void searchAdvisor(Person person){



    Scanner input = new Scanner(System.in);

    if(person.getMembertype().equalsIgnoreCase("Advisor")){

      System.out.println(person.toString());

    }







  }

  public static void searchByLastname(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter Last Name : ");

    String s1 = input.next();

    for(Person p: person){

      if(s1.equalsIgnoreCase(p.getLastName())){

        System.out.println(p.toString());



      }

    }

  }

  public static void searchByFirstname(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter First Name : ");

    String s1 = input.next();

    try{

      for(Person p: person){

        if(s1.equalsIgnoreCase(p.getFirstName())){

          System.out.println(p.toString());

        }

      }

    }catch(NoSuchElementException e){

      System.out.println("person not found");

    }

  }

  public static void searchbyMentor(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("Enter Mentor's Name : ");

    String s1 = input.next();

    System.out.println("==================================================");

    for(Person p : person){

      if(s1.equalsIgnoreCase(p.getMentorName())){

        System.out.println(p.toString());



      }

    }

  }

  public static void editORdelete(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("[1]Edit profile\n[2]Delete Profile\n[3]System Exit");

    int ok = input.nextInt();

    if(ok==1){

      editProfile(person);



    }

    else if(ok==2){

      deleteProfile(person);



    }

    else if(ok==3){

      System.exit(0);

    }

    else{

      System.out.println("Invaid Input");

      System.exit(1);

    }



  }

  public static void editProfile(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("Enter Person's ID# to edit Profile or enter 0 to exit the System");

    int id = input.nextInt();

    for(Person p : person){

      if(p.getId()==id){

        System.out.println("[1]Change address\n[2]Change Phone Number\n[3]Exit");

          int s3 = input.nextInt();

          if(s3==1){

            System.out.println("Enter new addess");

            String address = input.next();

            address+= input.nextLine();

            p.setAddress(address);

            System.out.println("Address changed\n"+p.toString());



          }

          else if(s3==2){

            System.out.println("Enter new Phone #");

            String phonenumber = input.next();

            p.setphoneNumber(phonenumber);

            System.out.println("Phonen# changed\n"+p.toString());

          }

          else if(s3==3){

            System.exit(0);

          }

          else{

            System.out.println("Invaild Input");

            continue;

          }

      }

      else if(id==0){

        System.exit(0);

      }

      else{

        System.out.println("Invaild ID #");

        continue;

      }



    }





  }

  public static void deleteProfile(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("Enter Person's ID# to edit Profile or enter 0 to exit the System");

    int id = input.nextInt();

    for(Person p : person){

      if(p.getId()==id){

        person.remove(p);

      }

      else if(id==0){

        System.exit(0);

      }

      else{

        System.out.println("Invaild Input");

        continue;

      }

    }





  }

  public static void giveComment(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("Enter Person's ID# to target the Student or enter 0 to exit the System");

    int id = input.nextInt();

    for(Person p: person){

      if(p.getId()==id){

        int ping=p.getPing();

        System.out.println(" Comment (do not comput '/'; to avoid Error) : ");

        String comment = input.next();

        comment+=input.nextLine();

        p.setComment(comment);

        ping++;

        p.setPing(ping);

      }

      else if(id==0){

        System.exit(0);

      }

    }

  }

  public static void viewComment(List<Person> person){

    System.out.println("==================================================");

    Scanner input = new Scanner(System.in);

    System.out.println("Enter Person's ID# to target the Student or enter 0 to exit the System");

    int id = input.nextInt();

    System.out.println("==================================================");

    for(Person p: person){

      if(p.getId()==id){

        System.out.println("Comment: "+p.getComment());

      }

    }



  }

  public static void addEntry(List<Person> person){

    Scanner input = new Scanner(System.in);

    System.out.println("==================================================");

    System.out.println("Choose your MemberType\n[1]GraduateStudent\n[2]Undergraduate\n[3]Mentor\n[4]Advisor");

    int membertype = input.nextInt();

    System.out.println("Enter your Last Name");

    String lname = input.next();

    System.out.println("Enter your First Name");

    String fname = input.next();

    System.out.println("Enter your Phone #");

    String phonenumber = input.next();

    phonenumber+=input.nextLine();

    System.out.println("Enter your Address");

    String address = input.next();

    address += input.nextLine();



    int id = generateIDforNewUser(person);



    if(membertype==1){

      System.out.println("Enter your mentor's name");

      String mentor = input.nextLine();



      Person p = new GraduateStudent(lname,fname,id,"Graduate Student",mentor,phonenumber,address,null,0);

      System.out.println("==================================================");

      System.out.println(p.toString());

      System.out.println("Entry Added");



      person.add(p);

    }

    else if(membertype==2){

      System.out.println("Enter your mentor's name");

      String mentor = input.nextLine();



      Person p = new UndergraduateStudent(lname,fname,id,"Undergraduate Student",mentor,phonenumber,address,null,0);

      person.add(p);

      System.out.println("==================================================");

      System.out.println(p.toString());

      System.out.println("Entry Added");



    }

    else if(membertype==3){

      Person p = new Mentor(lname,fname,id,"Mentor",null,phonenumber,address,null,0);

      person.add(p);

      System.out.println("==================================================");

      System.out.println(p.toString());

      System.out.println("Entry Added");



    }

    else if(membertype==4){

      Person p = new Advisor(lname,fname,id,"Advisor",null,phonenumber,address,null,0);

      person.add(p);

      System.out.println("==================================================");

      System.out.println(p.toString());

      System.out.println("Entry Added");



    }

    else{

      System.out.println("Invaild Input");

    }



  }

  public static int generateIDforNewUser(List<Person> person){

    int count = person.size();

    int id = count+1;



    return id;

  }

}
