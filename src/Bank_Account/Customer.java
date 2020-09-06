package Bank_Account;

import java.util.*;

public class Customer {
	Scanner s = new Scanner(System.in);

	public void customer_Functions() throws Exception {
		int choice = 0;
		while (choice != 5) {
			System.out.println("* Press 1 to get details of account.");
			System.out.println("* Press 2 to do transactions from your account.");
			System.out.println("* Press 3 to exit.");
			System.out.println();
			System.out.print("# Enter Your Choice:");
			choice = s.nextInt();
			System.out.println();
			if (choice == 1) {
				Show_details details = new Show_details();
				details.show_details();
			} else if (choice == 2) {
				CUSTOMER_Transactions_with_account accountTransaction = new CUSTOMER_Transactions_with_account();
				accountTransaction.do_transaction();
			} else if (choice == 3) {
				System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
				System.exit(0);
			} else {
				System.out.println("Wrong option chosen");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {

	}

}
