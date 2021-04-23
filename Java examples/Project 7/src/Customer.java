/**
 * Customer.java
 *
 *
 * <UPDATE THE DOCUMENTATION HEADING FOR THIS CLASS>
*/

public class Customer {

private String custID, name, address, 
		city, state, zip, phone;

    /**
     * Dummy Constructor
     */
    public Customer(){
        this("null","","","","","");
    }

//**STUDENTS COMPLETE THIS CONSTRUCTOR	
    /**
     * Contructs a customer object
     * @param name
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phone
     */
	 public Customer(String name, String address, String city, 
						String state, String zip, String phone){
		
		
    }

//**STUDENTS COMPLETE THE TWO METHODS BELOW	
    /**
     * Two customers are equal if they have the same custID.
     * @param customer the other customer
     * @return TRUE if they are the same else FALSE
     */
    public boolean equals(Customer customer){
		
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
