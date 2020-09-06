package Bank_Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ACCOUNTANT_Delete_Account {
	public void delete_account() throws Exception {
		Scanner s = new Scanner(System.in);
		char in = 'A';
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
		int n = s.nextInt();
		System.out.print("Enter Your Pin:");
		String pin = s.next();
		String qry = "select Pin from accounts_in_bank where Ac_no=" + n;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		rs.next();
		String Pin = rs.getString(1);
		if (BCrypt.checkpw(pin, Pin)) {
			String query = "delete from accounts_in_bank where Ac_no=" + n;
			int store = st.executeUpdate(query);
			if (store == 1) {
				System.out.println();
				System.out.println("Account deleted.");
				System.out.println();
				return;
			}
		}
	}
}
