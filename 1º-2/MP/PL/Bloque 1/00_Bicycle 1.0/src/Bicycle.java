/**
 * Class Bicycle with visibility public and private
 * 
 */

class Bicycle {

       private int cadence = 0;
       private int speed = 0;
       private int gear = 1;
       
    // Constructors
       public Bicycle() {
    	   this(0,0,1);
       }
       
       public Bicycle(int startCadence, int startSpeed, int startGear) {
           setGear(startGear);
           setCadence(startCadence);
           setSpeed(startSpeed);
       }
       public Bicycle(Bicycle b) {
    	   setGear(b.getGear());
           setCadence(b.getCadence());
           setSpeed(b.getSpeed());
       }
       
    // Observers
       public int getCadence() {
    	   return cadence;
   	   }
   		
   	   public int getGear() {
   		   return gear;
   	   }
   	   
    
    // Modifiers
       public void setCadence(int newValue) {
           cadence = newValue;
       }
   	
       public void setGear(int newValue) {
           gear = newValue;
       }
       public void setSpeed(int newSpeed) {
    	   if(newSpeed>0)
    		   speed = newSpeed;
       }
   	
       public void applyBrake(int decrement) {
           this.speed -= decrement;
       }
   	
       public void speedUp(int increment) {
           this.speed += increment;
       }
       
    // Other observer
       public void printStates() {
    	    System.out.println(" -- Bicycle -- ");
            System.out.println("cadence:"+cadence+" speed:"+speed+" gear:"+gear);
       }
       @Override
       public String toString(){
           return String.format("Bicycle: Cadence=%s, Speed=%s Gear=%s", getCadence(), getSpeed(), getGear());
       }

	public int getSpeed() {
		return speed;
	}

	
}

