package Bank_Account;

import java.sql.*;
import java.util.*;

public class ADMIN_updateStatus {
	Scanner s = new Scanner(System.in);

	public void updateStatus() throws Exception {
		Connection con = ProvideConnection.connectionProvider();
		System.out.print("Enter Id:");
		int id = s.nextInt();
		String qry = "Select id from accountant where id=" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		if (!rs.next()) {
			System.out.println("ID dont exists");
			System.out.println();
			return;
		}
		String query = "update accountant set salaryStatus='Paid' where id=" + id;
		st.executeUpdate(query);
		System.out.println("SALARY STATUS UPDATED");
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
