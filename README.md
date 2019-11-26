# AccountOperations

To set accounts of customers and monitor transactions.
A new account is opened by sending (customerID, initialCredit) parameters.
If initialCredit is not 0, a transaction will be sent to the new account.

Instructions to use project:
1)	In a new java program, create new customers calling: 
Customer(Integer customerId, String customerName, String customerSurname)
1)	Create new accounts by calling: 
Account(Integer accountId, double balance)
2)	Add account to lists via: 
App.getAccountList().add(accountId);
3)	Print account info via:
App.getAccountList().forEach(System.out::println);
