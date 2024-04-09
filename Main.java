import java.util.Scanner;
import java.util.*;


public class Main 
{
	static Scanner scan;
	static int lastID=0;
	private static ArrayList<Account> accounts;   

	
	public static void main(String[] args) 
	{
		scan= new Scanner(System.in);
		accounts=new ArrayList<>();
		
		// display Main Menu
		System.out.println("-------------------------------------------------");
		System.out.println("Welcome!\n");
		int o;
			do
			{
				System.out.println("Chose an option\n");
				System.out.println("1. Create new account");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.println("-------------------------------------------------");
				System.out.print("Option: ");
				o=scan.nextInt();
				System.out.println("\n");
				switch(o)
				{
				case 1: 
					createAccount();
					break;
				
				case 2:
					login();
					break;
					
				case 3:
					System.out.println("Thank you! Have a nice day!");
					break;
					
				default: 
					System.out.println("Invalid option. Please try again!");
					System.out.println("\n");	
					break;
				}
				
				
			}  while (o!=3);
			
			
	}
	
	
	
	
	private static void createAccount()
	{
		System.out.println("Insert First Name:");
		String firstName=scan.next();
		System.out.println("Insert Last Name:");
		String lastName=scan.next();
		System.out.println("Insert Password:");
		String password=scan.next();
		System.out.println("Confirm Password:");
		String password2=scan.next();
		
		if(password.equals(password2)== false)
		{
			System.out.println("Try Again");
		}
		else
		{
		int id=1000+lastID;
		lastID++;
		Account newAcc=new Account(firstName, lastName, id, password);
		System.out.println("-------------------------------------------------");
		System.out.println("Account successfully created! ");
		System.out.println("Your account ID: " + id );
		System.out.println("-------------------------------------------------" + "\n");
		accounts.add(newAcc);
		}
	}
	
	
	
	private static void login()
	{
		Account account= new Account();
		System.out.println("Insert Account ID:");
		int id=scan.nextInt();
		System.out.println("Insert Password: ");
		String pass=scan.next();

		boolean exists=false;
		
		for(Account acc : accounts)
		{
			if(acc.getaccID() == id && acc.getPassword().equals(pass))
			{
				exists=true;
				account=acc;
			}
		}
		
		if(exists)
		{
			playMenu(account);
		}
		else
		{
			System.out.println("Error! Account not found! Please try again! ");
			System.out.println("------------------------------------------------- \n");
		}
		
	}
	
	
	
	
	private static void playMenu(Account acc)
	{
		int option;
		float amount;
			System.out.println("Welcome " + acc.getFirstName() + " " + acc.getLastName() + "!\n");
			System.out.print("Choose an option: \n");	
			System.out.println("1. Deposit ");
			System.out.println("2. Withdraw ");
			System.out.println("3. Total Spent");
			System.out.println("4. Check Balance");
			System.out.println("5. Last Action");
			System.out.println("6. Transfer");
			System.out.println("7. Exit");
			
			do
			{
				System.out.println("-------------------------------------------------");
				System.out.print("Option: ");
				option = scan.nextInt();
				System.out.println("\n");	
				
				switch(option)
				{
				case 1:
					System.out.println("-------------------------------------------------");
					System.out.print("Amount: ");
					amount=scan.nextInt();
					acc.deposit(amount);
					System.out.println("Done! Your deposit of " + amount + " ended succesfuly!");
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
				
				case 2:
					System.out.println("-------------------------------------------------");
					System.out.print("Amount: ");
					amount=scan.nextInt();
					acc.withdraw(amount);
					System.out.println("Done! Your withdraw of " + amount + " ended succesfuly!");
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
					
				case 3:
					System.out.println("-------------------------------------------------");
					acc.getTotalSpent();
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
				
				case 4:
					System.out.println("-------------------------------------------------");
					acc.checkBalance();
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
					
				case 5:
					System.out.println("-------------------------------------------------");
					acc.getLastAction();
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
				
					
				case 7:
					System.out.println("Thank you! Have a nice day!");
					break;
					
					//------------------------------
					
				case 6:
					int destID;
					Account destacc= new Account();
					boolean ok=false;
					System.out.println("-------------------------------------------------");
					System.out.print("Amount: ");
					amount=scan.nextInt();
					
					if(amount>acc.getBalance())
					{
						System.out.print("Not enough money! \n");
					}
					
					else
					{
						System.out.print("Insert ID of dest account: ");
						destID=scan.nextInt();
						for(Account dest : accounts)
						{
							if(dest.getaccID() == destID )
							{
								ok=true;	
								destacc=dest;
							}
						}
						if(ok)
						{
							destacc.deposit(amount);
							acc.withdraw(amount);
							System.out.print("Your transfer of " + amount + " to " + destacc.getaccID() + "ended succesfuly! \n");
						}
						else
						{
							System.out.print("Dest account not found! Please try again! ");
						}
					}
					
					System.out.println("-------------------------------------------------");
					System.out.println("\n");	
					break;
					
					//------------------------------
					
				default: 
					System.out.println("Invalid option. Please try again!");
					System.out.println("\n");	
					break;
				}
				
			}	while (option!=7);
		
	}


}
