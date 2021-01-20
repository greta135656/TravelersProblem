import java.util.*;
import java.lang.*;
import java.util.Arrays;

public class TravelersProblem {

  public static void main(String[] args) {
    //First loop to find all the cities, their orders, and distances
     Scanner sc = new Scanner(System.in);
     ArrayList<String> cities = new ArrayList<String>(10);
     ArrayList<Integer> city1Index = new ArrayList<Integer>(10);
     ArrayList<Integer> city2Index = new ArrayList<Integer>(10);
     ArrayList<Integer> distances = new ArrayList<Integer>(10);

     while (sc.hasNext()) {
       String line = sc.nextLine();
       Scanner lineSc = new Scanner(line);

       String city = lineSc.next();
       if (! cities.contains(city)) {
         cities.add(city);
       }
       city1Index.add(cities.indexOf(city));
       lineSc.next();
       city = lineSc.next();
       if (! cities.contains(city)) {
         cities.add(city);
       }
       city2Index.add(cities.indexOf(city));
       lineSc.next();
       distances.add(Integer.parseInt(lineSc.next()));
     }
     sc.close();

     //puts distances into order
     int[][] orderedDistances = new int[cities.size()][cities.size()];
     for (int i = 0; i < distances.size(); i++) {
       orderedDistances[city1Index.get(i)][city2Index.get(i)] = distances.get(i);
  }
 }
}
