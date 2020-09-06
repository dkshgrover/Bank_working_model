package Bank_Account;

import java.util.*;
import java.sql.*;

public class ADMIN_newAccountant {

	Scanner s = new Scanner(System.in);

	public void addAccountant() throws Exception {
		Connection con = ProvideConnection.connectionProvider();
		System.out.print("Enter ID:");
		int id = s.nextInt();
		String qry = "Select id from accountant where id=" + id;
		Statement st1 = con.createStatement();
		ResultSet rs = st1.executeQuery(qry);
		if (rs.next()) {
			System.out.println("ID already exists");
			System.out.println();
			return;
		}
		s.nextLine();
		System.out.print("Enter Name:");
		String name = s.nextLine();
		System.out.print("Enter Password:");
		String pass = s.next();
		BCrypt ob = new BCrypt();
		String encryptedPass = ob.hashpw(pass, ob.gensalt(12));
		String query = "insert into accountant values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(3, encryptedPass);
		st.setString(4, "Not Paid");
		st.executeUpdate();
		System.out.println("EMPLOYEE ADDED");
		System.out.println();
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
