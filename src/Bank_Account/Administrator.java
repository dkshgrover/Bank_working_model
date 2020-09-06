package Bank_Account;

import java.util.*;
import java.sql.*;

public class Administrator {

	Scanner s = new Scanner(System.in);

	public void administrator_Functions() throws Exception {
		System.out.print("Enter Your ID: ");
		int id = s.nextInt();
		System.out.print("Enter Your Password: ");
		String pass = s.next();
		Connection con = ProvideConnection.connectionProvider();
		String query = "select * from administrator where id=" + id + " and password='" + pass + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			int choice = 0;
			System.out.println();
			System.out.println("********** WELCOME " + rs.getString(1) + " **********");
			System.out.println("* Press 1 to add a new Accountant.");
			System.out.println("* Press 2 to remove an Accountant.");
			System.out.println("* Press 3 to update salary status.");
			System.out.println("* Press 4 to Exit.");
			System.out.println();
			while (choice != 4) {
				System.out.print("# Enter Your Choice:");
				choice = s.nextInt();
				if (choice == 1) {
					ADMIN_newAccountant obj1 = new ADMIN_newAccountant();
					obj1.addAccountant();
				} else if (choice == 2) {
					ADMIN_removeAccontant obj2 = new ADMIN_removeAccontant();
					obj2.removeAccountant();
				} else if (choice == 3) {
					ADMIN_updateStatus obj3 = new ADMIN_updateStatus();
					obj3.updateStatus();
				}  else if (choice == 4) {
					System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
					System.exit(0);
				} else {
					System.out.println("\t\t\t\t\t       **********WRONG OPTION**********");
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
		// TODO Auto-generated method stub

	}

}
