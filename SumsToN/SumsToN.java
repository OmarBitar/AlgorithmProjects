import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Scanner;

public class SumsToN {
   public static void main( String[] args) { 
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a positive number: "); 
      int n = scan.nextInt(); scan.close(); 
      ArrayList<ArrayList> possibilities = new ArrayList<ArrayList>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(0))));  
      SumsToN(n, possibilities); 
   }

   private static void SumsToN( int n,  ArrayList<ArrayList> possibilities) { 
      ArrayList<ArrayList> subPossibilities = new ArrayList<ArrayList>();
      //clone
      for(int index = 0; index < n; index++){
         subPossibilities.add((ArrayList) possibilities.get(0).clone());
      }
      //appened
      for(int index = 0; index < n; index++){
         subPossibilities.get(index).add(index+1);
      } 
      //check
      int sum = 0; 
      for (int index = 0; index < possibilities.size(); index++) { 
         for (int counter = 0; counter < possibilities.get(index).size(); counter++){
            sum += (int) possibilities.get(index).get(counter);
         }
         //print 
         if (sum == n) {
            for (int counter = 0; counter < possibilities.get(index).size(); counter++){
               if((int) possibilities.get(index).get(counter) != 0) {
                  System.out.print(possibilities.get(index).get(counter) + "+");
               }  
            }
            System.out.print("0 \n"); 
         } else if(sum > n)  {return;}
         sum = 0;
      }  
      //new threads
      int size = subPossibilities.size();
      for(int index = 0; index < size; index++){ 
         SumsToN(n, new ArrayList<ArrayList>(Arrays.asList(subPossibilities.get(index))));
      }
   }
}