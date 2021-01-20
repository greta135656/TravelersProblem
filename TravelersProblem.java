import java.util.*;
import java.lang.*;

public class TravelersProblem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> cities = new ArrayList<String>(10);

    while (sc.hasNext()) {
      String line = sc.nextLine();
      Scanner lineSc = new Scanner(line);

      String city = lineSc.next();
      if (! cities.contains(city)) {
        cities.add(city);
      }
      lineSc.next();
      city = lineSc.next();
      if (! cities.contains(city)) {
        cities.add(city);
      }
    }
    // System.out.println(cities);
  }

}
