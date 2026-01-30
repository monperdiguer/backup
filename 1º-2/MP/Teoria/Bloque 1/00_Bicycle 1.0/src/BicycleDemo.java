/**
 * Example using the class Bicycle
 * 
 */

class BicycleDemo {
     public static void main(String[] args) {

          // Create two different Bicycle objects
          Bicycle bike1 = new Bicycle(50,10,2);
          Bicycle bike2 = new Bicycle();
          Bicycle bike3 = new Bicycle();
          Bicycle bike4 = new Bicycle(0,2*bike2.getSpeed(),bike1.getGear());
          Bicycle bike5 = new Bicycle(bike1);

          // Invoke methods on those objects
          bike1.printStates();
          System.out.printf("bike1 %s\n", bike1);

          bike2.setCadence(50);
          bike2.speedUp(10);
          bike2.setGear(2);
          bike2.setCadence(40);
          bike2.speedUp(10);
          bike2.setGear(3);
          bike2.printStates();
          System.out.printf("bike2 %s\n", bike2);
          
          bike3.printStates();
          System.out.printf("bike3 %s\n", bike3);
          bike4.printStates();
          System.out.printf("bike4 %s\n", bike4);
          bike5.printStates();
          System.out.printf("bike5 %s\n", bike5);
          
     }
}

