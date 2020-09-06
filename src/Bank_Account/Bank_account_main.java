package Bank_Account;

import java.util.*;
import java.sql.*;

public class Bank_account_main {
	Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t **********WELCOME USER**********");
		System.out.println();
		int choice = 0;
		System.out.println("PLEASE CHOOSE YOUR FIELD: ");
		System.out.println(" 1-> ADMINISTRATOR");
		System.out.println(" 2-> ACCOUNTANT");
		System.out.println(" 3-> CUSTOMER");
		System.out.println();
		System.out.print("# Enter Your Choice:");
		choice = s.nextInt();
		System.out.println();
		if (choice == 1) {
			Administrator objAdmin = new Administrator();
			objAdmin.administrator_Functions();
		} else if (choice == 2) {
			Accountant objAccountant = new Accountant();
			objAccountant.Accountant_Functions();
		} else if (choice == 3) {
			Customer objCustomer = new Customer();
			objCustomer.customer_Functions();
		} else {
			System.out.println("Wrong option chosen");
			System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
			System.exit(0);
		}
	}
}
