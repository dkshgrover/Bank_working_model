package Bank_Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Show_details {
	public void show_details() throws Exception {
		Scanner s=new Scanner(System.in);
		System.out.println("****** Press B to go Back && Press A to go ahead******");
		System.out.print("# Choice=");
		char in='A';
		in = s.next().charAt(0);
		if (in == 'B' || in == 'b') {
			System.out.println();
			return;
		}
		System.out.println();
		Connection con=ProvideConnection.connectionProvider();
		System.out.print("Enter Account Number To View Details:");
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
			System.exit(0);
		}
		System.out.println();
		System.out.println("***** Hello " + rs1.getString(2) + " *****");
		System.out.print("Enter Your PIN:");
		String pin = s.next();
		String qu = "Select * from accounts_in_bank where ac_no=" + ac_no;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qu);
		rs.next();
		String val = rs.getString(4);
		if (!BCrypt.checkpw(pin, val)) {
			System.out.println();
			System.out.println("WRONG PIN");
			System.out.println("\t\t\t\t\t\t **********BYE BYE**********");
			System.exit(0);
		} else {
			System.out.println();
			System.out.println("Account Number:" + rs.getInt(1));
			System.out.println("Account Holder's Name:" + rs.getString(2));
			System.out.println("Current Balance:" + rs.getInt(3));
			System.out.println();
			return;
		}
	}
}
