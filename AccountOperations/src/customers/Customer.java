package customers;

public class Customer {
	private static Integer Id = 0;
	private Integer customerId;
	private String customerName;
	private String customerSurname;

	public Integer getCustomerId() {
		return this.customerId; 
	}
	
	public void setCustomerId(String phrase) {
		if(phrase.equals("new ID")) {
			this.customerId = Id++;
		}
		else this.customerId = -1;
		
	}
	
	public static int getLastCustomerId(String phrase) {
		if(phrase.equals("last ID")) {
			return Id;
		}
		else return -1;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	
	public String getCustomerFullname() {
		return (customerName + " " + customerSurname);
	}
}
