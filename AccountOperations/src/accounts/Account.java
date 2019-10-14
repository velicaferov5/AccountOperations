package accounts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import customers.Customer;
import customers.CustomerCoordinator;

public class Account {

	private String name;
	private Integer accountId;
	private double balance;
	private List<String> transactions = new ArrayList<>();
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}
	
	public Account(Integer customerId,double amount) {
		CustomerCoordinator customerCoordinator = new CustomerCoordinator();
		if(customerCoordinator.doesIdBelongtoCustomer(customerId)) {
			this.setAccountId(customerId);
			this.transactions.add("Transactions of Customer: "+this.accountId.toString());
			this.balance = 0;
			if(amount > 0) {
				this.receive(amount, "", "Received");
			}
		}
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void receive(double amount, String from, String phrase) {
		if(phrase.equals("Received") && amount > 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			this.balance+=amount;
			this.transactions.add(dtf.format(now) +" Received: " + Double.toString(amount) + " EUR" + from);
		}
	}
	
	public void send(double amount, String to, String phrase) {
		if(phrase.equals("Sent") && amount > 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			this.balance-=amount;
			this.transactions.add(dtf.format(now) +" Sent: " + Double.toString(amount) + " EUR" + to);
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}