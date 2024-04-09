//import java.util.*; 
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.time.Clock;  
import java.time.Instant;  
import java.util.Scanner;

public class Account 
{
	private float balance;
	private int lastAction;    
	private float lastAmount; 
	private float totalSpent;
	private String firstName;
	private String lastName;
	private int accID;
	private String password;
	private Dictionary<String, Float> transaction= new Hashtable<>();
	
	
	public Account()
	{}
	
	
	public Account(String fname, String lname, int ID, String pass)
	{
		super();
		this.firstName=fname;
		this.lastName=lname;
		this.accID=ID;
		this.password=pass;
	}


	void deposit(float amount)
	{
		this.balance=balance+amount;
		this.lastAction= 1;
		this.lastAmount=amount;
		
	}
	
	void withdraw(float amount)
	{
		if(amount>balance)
		{
			System.out.println("Not enough money!");
		}
		else
		{
			Scanner scanner = new Scanner(System.in); 
			System.out.println("I need money for: ");
			String reason = scanner.nextLine();  
			this.balance=balance-amount;
			this.lastAction= 2;
			this.lastAmount=amount;
			this.totalSpent=totalSpent+amount;
			
			transaction.put(reason,amount);
		}
	}
	
	void checkBalance()
	{
		System.out.println("Account ID: " + this.accID);
		System.out.println("Account owner: " + this.firstName +" " + this.lastName );
		System.out.println("Current balance: " + this.balance );
		this.lastAction= 4;
	}
	
	
	void getTotalSpent()
	{
		Enumeration<String> it = transaction.keys();
        while (it.hasMoreElements()) 
        {
            String key = it.nextElement();
            System.out.println("Reason: " + key + ", Amount: " + transaction.get(key)); 
        }
        System.out.println("Total spent: " + this.totalSpent);
        this.lastAction= 3;
		
	}
	
	
	void getLastAction()
	{
		if(lastAction==0)
		{
			System.out.println("No action yet! Please select one! ");
		}
		else if(lastAction==1)
		{
			System.out.println("Last action: Deposit:  " + lastAmount);
		}
		else if(lastAction==2)
		{
			System.out.println("Last action: Withdraw:  " + lastAmount);
		}
		else if(lastAction==3)
		{
			System.out.println("Last action: Total Spent  " + totalSpent);	
		}
		else
		{
			System.out.println("Last action: Check Balance:  " + balance) ;	
		}
		
	}
	
	//getters
	
	public int getaccID()
	{
		return accID;
	}
	public String getPassword()
	{
		return password;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public float getBalance()
	{
		return this.balance;
	}
}

