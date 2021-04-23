/**
 * Car.java
 *
 * <UPDATE THE DOCUMENTATION HEADING FOR THIS CLASS>
*/

public class Car {

    private String vin, make, model;
    private int year;

    /**
     * Dummy Constructor
     */
    public Car(){
        this("","","",0);
    }

    /**
     * Constructs a car object.
     * @param vin
     * @param make
     * @param model
     * @param year
     */
    public Car(String vin, String make, String model, int year){
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
    }

//**STUDENTS COMPLETE THE TWO METHODS BELOW	
    /**
     * Two cars are equal if they have the same VIN
     * @param car the other car
     * @return TRUE if they are the same else FALSE
     */
    public boolean equals(Car car){

    }

	/** 
	 * Converts required attributes to a Formatted String
	 * 
	 * @param no parameters are passed in 
	 * @return a Formatted String using for display 
	 */     
	 public String toString(){
		 
    }
}
