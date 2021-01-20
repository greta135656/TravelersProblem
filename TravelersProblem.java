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

    //Makes random possibilities
    int[] random = new int[cities.size()];
    ArrayList<Integer> temp = new ArrayList<Integer>(cities.size());
    for (int i = 0; i < cities.size(); i++) {
    	temp.add(i);
    }
  	int randomIndex, smallerCity, largerCity;
    int sum = 0;
    int smallestDistance = 1000000;
    for (int times = 0; times < 5 * calculateFactorial(cities.size()); times++) {
    	for (int i = 0; i < cities.size(); i++) {
     		randomIndex = (int)(Math.random() * (temp.size()));
        random[i] = temp.get(randomIndex);
        temp.remove(randomIndex);
    	}

      for (int i = 0; i < random.length - 1; i++) {
        smallerCity = Math.min(random[i], random[i+1]);
        largerCity = Math.max(random[i], random[i+1]);

        sum += orderedDistances[smallerCity][largerCity];
      }

      smallestDistance = Math.min(smallestDistance, sum);
      sum = 0;
      for (int i = 0; i < cities.size(); i++) {
      	temp.add(i);
      }
    }

    System.out.println(smallestDistance);
  }

  public static int calculateFactorial(int x) {
  	int ans = 1;
    while (x > 0) {
    	ans = ans * x;
      x--;
    }
    return ans;
  }

}
