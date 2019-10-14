package customers;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class CustomerCoordinator{
	
	public Map<String,Customer> newCustomer(List<CustomerRequestDto> customerList){
		Map<String,Customer> resultMap = new HashMap<>();
		
		for(CustomerRequestDto customerRequestDto:customerList) {
			if(customerRequestDto.getCustomerName().isEmpty()) {
				resultMap.put("ERROR: Please fill customer name field.", new Customer());
			}
			
			else if(customerRequestDto.getCustomerSurname().isEmpty()) {
				resultMap.put("ERROR: Please fill customer Surname field.", new Customer());
			}
			
			else {
				Customer customer = new Customer();
				customer.setCustomerName(customerRequestDto.getCustomerName());
				customer.setCustomerSurname(customerRequestDto.getCustomerSurname());
				customer.setCustomerId("new ID");
				resultMap.put("SUCCESS ("+customer.getCustomerId()+")", customer);
			}
		}
		
		return resultMap;
	}
	
	public boolean doesIdBelongtoCustomer(Integer Id) {
		Customer customer = new Customer();
		if(customer.getLastCustomerId("last ID")>-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
