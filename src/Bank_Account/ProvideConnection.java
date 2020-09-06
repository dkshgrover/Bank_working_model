package Bank_Account;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProvideConnection {
		public static Connection connectionProvider() throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank_account"; // URL OF DATABASE
		String user = "root"; // USERNAME OF MYSQL (BY DEFAULT : ROOT)
		String pass = "DakshGrover6497"; // PASSWORD OF DATABASE
		Class.forName("com.mysql.jdbc.Driver"); // LOAD AND REGISTERING THE DRIVER
		Connection con = DriverManager.getConnection(url, user, pass); // ESTABLISHING CONNECTION
		return con;
	}
}
