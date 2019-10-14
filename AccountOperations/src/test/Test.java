package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import accounts.Account;
import customers.Customer;
import customers.CustomerCoordinator;
import customers.CustomerRequestDto;
import java.util.List;

public class Test {
	
	public static void main(String Args[]) {
		//Testing Customer services
		
		List<CustomerRequestDto> customerList = new ArrayList<>();
		CustomerRequestDto customerOne = new CustomerRequestDto();
		customerOne.setCustomerName("Vali");
		customerOne.setCustomerSurname("Jafarov");
		customerList.add(customerOne);
		
		CustomerRequestDto customerTwo = new CustomerRequestDto();
		customerTwo.setCustomerName("Michael");
		customerTwo.setCustomerSurname("Adams");
		customerList.add(customerTwo);
		
		CustomerCoordinator customerCoordinator = new CustomerCoordinator();
		Map<String, Customer> coordinatorResult = new HashMap<>(); 
		coordinatorResult = customerCoordinator.newCustomer(customerList);

		for (String key : coordinatorResult.keySet()) {
			System.out.print(key);
			if (key.startsWith("SUCCESS")) {
				System.out.println(": " + coordinatorResult.get(key).getCustomerFullname());
			}
		}
		
		//Testing Account service

		for(int index1=0;index1<Customer.getLastCustomerId("last ID");index1++) {
			Random r = new Random();
			double randomAmount = Math.round((0 + 500 * r.nextDouble()) * 10) / 10;
			Account account = new Account(index1,randomAmount);
			for(String transaction:account.getTransactions()){
				System.out.println(transaction);
			}
		}
	}
}
