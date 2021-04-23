/**
 * WorkTicket.java 
 *
 *
 * <UPDATE THE DOCUMENTATION HEADING FOR THIS CLASS>
 */

public class WorkTicket {

    private String ticketNum;
    private Customer customer;
    private Car car;
    private ServiceQuote quote;

    /**
     * Dummy Constructor
     */
    public WorkTicket(){
        this(null,null,null);
    }

//**STUDENTS COMPLETE THIS CONSTRUCTOR	
    /**
     * WorkTicket constructor
     * @param customer the customer
     * @param car the car
     * @param quote the quote
     */
    public WorkTicket(Customer customer, Car car, ServiceQuote quote){
		
    }


//**STUDENTS COMPLETE THE TWO METHODS BELOW	
    /**
     * Two worktickets are equal if they have the same ticketNum
     * OR Customer ID OR Car VIN OR Service Quote Number.
	 * Calls the equals method in each of these classes
     * @param ticket ticket being compared to.
     * @return
     */
    public boolean equals(WorkTicket ticket){

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
