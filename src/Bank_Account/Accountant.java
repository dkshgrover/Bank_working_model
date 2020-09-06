package Bank_Account;

import java.util.*;
import java.sql.*;

public class Accountant {
	Scanner s = new Scanner(System.in);

	public void Accountant_Functions() throws Exception {
		System.out.print("Enter Your ID: ");
		int id = s.nextInt();
		System.out.print("Enter Your Password: ");
		String pass = s.next();
		BCrypt obj = new BCrypt();
		Connection con = ProvideConnection.connectionProvider();
		String query = "select * from accountant where id=" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		if (obj.checkpw(pass, rs.getString(3))) {
			int choice = 0;
			System.out.println();
			System.out.println("********** WELCOME " + rs.getString(2) + " **********");
			System.out.println("* Press 1 to open a new Account.");
			System.out.println("* Press 2 to delete an Account.");
			System.out.println("* Press 3 to check details of an account.");
			System.out.println("* Press 4 to check salary status.");
			System.out.println("* Press 5 to Exit.");
			System.out.println();
			while (choice != 5) {
				System.out.print("# Enter Your Choice:");
				choice = s.nextInt();
				if (choice == 1) {
					ACCOUNTANT_Create_account obj1 = new ACCOUNTANT_Create_account();
					obj1.create_account();
				} else if (choice == 2) {
					ACCOUNTANT_Delete_Account obj2 = new ACCOUNTANT_Delete_Account();
					obj2.delete_account();
				} else if (choice == 3) {
					Show_details obj3 = new Show_details();
					obj3.show_details();

				} else if (choice == 4) {
					System.out.println("Status : " + rs.getString(4));
					System.out.println();
				} else {
					System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
					System.exit(0);
				}
			}
		} else {
			System.out.println("WRONG PASSWORD");
			System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
			System.exit(0);
		}
	}

	public static void main(String[] args) {

	}

}
