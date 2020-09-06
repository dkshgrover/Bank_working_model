package Bank_Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CUSTOMER_Transactions_with_account {
	public void do_transaction() throws Exception {
		Scanner s = new Scanner(System.in);
		char in='A';
		System.out.println("****** Press B to go Back && Press A to go ahead******");
		System.out.print("# Choice=");
		in = s.next().charAt(0);
		if (in == 'B' || in == 'b') {
			System.out.println();
			return;
		}
		System.out.println();
		Connection con = ProvideConnection.connectionProvider();
		System.out.print("Enter Account Number:");
		int ac_no = s.nextInt();
		String qu1 = "Select * from accounts_in_bank";
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery(qu1);
		int flag = 0;
		while (rs1.next()) {
			if (ac_no == rs1.getInt(1)) {
				flag = 1;
				break;
			} else {
				flag = 0;
			}
		}
		if (flag == 0) {
			System.out.println("Invalid Account Number");
			System.out.println();
			System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
			System.exit(0);
		}
		System.out.println();
		System.out.println("***** Hello " + rs1.getString(2) + " *****");
		System.out.print("Enter Your PIN:");
		String pin=s.next();
		System.out.println();
		String qu = "Select * from accounts_in_bank where ac_no=" + ac_no;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qu);
		rs.next();
		int bal = rs.getInt(3);
		String val = rs.getString(4);
		if (!BCrypt.checkpw(pin, val)) {
			System.out.println();
			System.out.print("WRONG PIN");
			System.exit(0);
		} else {
			char ch = 'y';
			while (ch != 'n') {
				System.out.println("-> Press 'w' to withdraw money.");
				System.out.println("-> Press 'd' to deposit money.");
				System.out.println("-> Press 'v' to view balance.");
				System.out.println("-> Press 'b' to go back.");
				System.out.println("-> Press 'n' to exit portal.");
				System.out.println();
				System.out.print("# Enter Choice Please:");
				ch = s.next().charAt(0);
				if (ch == 'n') {
					System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
					System.exit(0);
				}
				if (ch == 'w') {
					System.out.println("****** Press B to go Back && Press A to go ahead******");
					System.out.print("# Choice=");
					in = s.next().charAt(0);
					if (in == 'B' || in == 'b') {
						System.out.println();
						continue;
					}
					System.out.println();
					System.out.print("Enter Money To Be Withdrawl:");
					int wm = s.nextInt();
					int rb = bal - wm;
					if (rb < 0) {
						System.out.println("Insufficient Money In Account.");
						System.out.println();
						System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
						System.exit(0);
					}
					bal = rb;
					String query = "update accounts_in_bank set Balance=" + rb + " where ac_no=" + ac_no;
					int count = st.executeUpdate(query);
					if (count == 1) {
						System.out.println("Remaining Balance Is:" + bal);
						System.out.println();
					}
				} else if (ch == 'b' || ch == 'B') {
					System.out.println();
					break;
				} else if (ch == 'd') {
					System.out.println("****** Press B to go Back && Press A to go ahead******");
					System.out.print("# Choice=");
					in = s.next().charAt(0);
					if (in == 'B' || in == 'b') {
						System.out.println();
						continue;
					}
					System.out.println();
					System.out.print("Enter Money To Be Deposited:");
					int dm = s.nextInt();
					int rb = bal + dm;
					bal = rb;
					String query = "update accounts_in_bank set Balance=" + rb + " where ac_no=" + ac_no;
					int count = st.executeUpdate(query);
					if (count == 1) {
						System.out.println("New Balance Is:" + bal);
						System.out.println();
					}
				} else if (ch == 'v') {
					System.out.println("Balance:" + bal);
					System.out.println();
				} else {
					System.out.println("WRONG OPTION CHOSEN...");
					System.out.println();
				}
			}
		}
	}
}
