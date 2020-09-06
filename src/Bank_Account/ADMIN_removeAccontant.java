package Bank_Account;

import java.util.*;
import java.sql.*;

public class ADMIN_removeAccontant {

	Scanner s = new Scanner(System.in);

	public void removeAccountant() throws Exception {
		Connection con = ProvideConnection.connectionProvider();
		System.out.print("Enter id of accountant:");
		int id = s.nextInt();
		String qry = "Select id from accountant where id=" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		if (!rs.next()) {
			System.out.println("ID dont exists");
			System.out.println();
			return;
		}
		String query = "delete from accountant where id=" + id;
		st.executeUpdate(query);
		System.out.println("ACCOUNTANT REMOVED");
		System.out.println();
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
