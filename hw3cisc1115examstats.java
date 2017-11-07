//Steve Zhuravel
import java.util.Scanner;
import java.io.*;
public class hw3cisc1115examstats {

   public static void main (String [] args) throws IOException{
    int score1=0, score2=0, score3=0;
    int avg, valid=0, invalid=0, total=0;

    PrintWriter outputFile = new PrintWriter("/Users/Stevezhuravel/Desktop/intro class/topic 3");
    File inputFile = new File("//Users/Stevezhuravel/Desktop/intro class");
    Scanner input = new Scanner(inputFile);
    
    while(input.hasNextLine()){ 
        score1 = input.nextInt();
        score2 = input.nextInt();
        score3 = input.nextInt();
        
        outputFile.printf("%d %d %d", score1, score2, score3);
        outputFile.println();
        if(validgroup( score1, score2, score3, outputFile) == 1){
            onegamescore(score1,outputFile);
            onegamescore(score2,outputFile);
            onegamescore(score3,outputFile);
            valid++;
        }else
            invalid++;

        avg = avg3scores(score1, score2, score3);
        total++;
        outputFile.println("average of scores of group " + total + ": "+ avg);
        onegamescore(avg,outputFile);
        outputFile.println("\n\n\n");
    }
    
    outputFile.println("Number of invalid groups: "+invalid);
    outputFile.println("Number of valid groups: "+valid);
    outputFile.println("Number of all groups: "+total);
    
    input.close();
    outputFile.close();
}
	

    /*Input:
     Process:
     Output:
     */
    public static int validgroup(int score1,int score2, int score3, PrintWriter outputFile)
    {
        if(score1 > 0 && score2 > 0 && score3 > 0 && score1 <300 && score2 < 300 && score3 < 300 ){
            outputFile.println("Group is vaild");
            return 1; 
        }else {
            outputFile.println("Group is invaild"); 
            if(score1 < 0 || score1 > 300)
               outputFile.println("First score not in range 0-300: " + score1);
            if(score2 < 0 || score2 > 300)
               outputFile.println("Second score not in range 0-300: " + score2);
            if(score3 < 0 || score3 > 300)
               outputFile.println("Third score not in range 0-300: " + score3);
            return 0;
        }
    }

    /*Input:
     Process:
     Output:
     */
    public static void onegamescore(int score, PrintWriter outputFile) {
        if(score >= 250 && score <= 300)
           outputFile.println("professional game: " + score);
        else if(score >= 200 && score <= 249)
           outputFile.println("excellent game: " + score);
        else if(score >= 140 && score <= 199)
           outputFile.println("Very good game: " + score);
        else if(score >= 100 && score <= 139)
           outputFile.println("is a good game: " + score);
        else if(score > 50 && score <= 99)
           outputFile.println("poor game: " + score);
        else 
           outputFile.println("horrible game: " + score);
    }
    /*Input:
     Process:
     Output:
     */
    public static int avg3scores(int score1,int score2,int score3) {
        int avg, sum = 0;
        sum = (score1 + score2 + score3);
        avg = sum/3;

        return avg;
    }
}


	