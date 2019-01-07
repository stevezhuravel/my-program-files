import java.util.Random;



public class Person{

  //Data Field

  private String lname;

  private String fname;

  private int id;

  private String phoneNumber;

  private String membertype;

  private String mentor;

  private String comment;

  private int pinging;

  private String address;



  public Person(String lname, String fname, int id, String membertype,String mentor, String phoneNumber, String address, String comment, int pinging){

    this.lname = lname;

    this.fname = fname;

    this.id=id;

    this.membertype=membertype;

    this.mentor=mentor;

    this.phoneNumber=phoneNumber;

    this.address=address;

    this.comment=comment;

    this.pinging=pinging;

  }



  public void setphoneNumber(String phoneNumber){

    this.phoneNumber=phoneNumber;

  }



  public void setAddress(String address){

    this.address=address;

  }

  public void setComment(String comment){

    this.comment =comment;

  }

  public void setPing(int pinging){

    this.pinging=pinging;

  }

  public String getMembertype(){

    return membertype;

  }

  public String getLastName(){

    return lname;

  }

  public String getFirstName(){

    return fname;

  }

  public int getId(){

    return id;

  }

  public String getMentorName(){

    return mentor;

  }

  public int getPing(){

    return pinging;

  }

  public String getPhoneNumber(){

    return phoneNumber;

  }

  public String getAddress(){

    return address;

  }

  public String getComment(){

    return comment;

  }



  public String toString(){

    return "Name["+lname+", "+fname+"] ID["+id+"] MemberType["+membertype+"] Mentor's Name["+mentor+"] phoneNumber["+phoneNumber+"] Address["+address+"] PingStatus["+pinging+"]";

  }

}
