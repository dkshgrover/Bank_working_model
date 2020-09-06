package Bank_Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class ACCOUNTANT_Create_account {
	public void create_account() throws Exception {
		Scanner s=new Scanner(System.in);
		char in='A';
		Random rand = new Random();
		System.out.println("****** Press B to go Back && Press A to go ahead******");
		System.out.print("# Choice=");
		in = s.next().charAt(0);
		if (in == 'B' || in == 'b') {
			System.out.println();
			return;
		}
		System.out.println();
		System.out.print("Enter First Name:");
		String F_name = s.next();
		System.out.print("Enter Last Name(if not press .):");
		String L_name = s.next();
		String name = F_name + " " + L_name;
		System.out.print("Enter Age:");
		int age = s.nextInt();
		if (age < 18) {
			System.out.println("Account Can't be created.");
			System.exit(0);
		}
		int ac_no = rand.nextInt(999999999);
		System.out.println("Your Account Number is:" + ac_no);
		System.out.print("Enter Opening Balance:");
		int op_bal = s.nextInt();
		System.out.print("Set Your PIN Please:");
		String pin = s.next();
		PinCheck checkPin = new PinCheck();
		int res = checkPin.check_pin(pin);
		if (res == -1) {
			System.out.print("Set Your PIN again Please:");
			pin = s.next();
			pin=BCrypt.hashpw(pin, BCrypt.gensalt(12));
		}
		if (res == 0) {
			System.out.print("Set Your PIN again Please:");
			pin = s.next();
			pin=BCrypt.hashpw(pin, BCrypt.gensalt(12));
		}
		if(res==1)
		{
			pin=BCrypt.hashpw(pin, BCrypt.gensalt(12));
		}
		String query = "insert into accounts_in_bank values(?,?,?,?)";
		Connection con=ProvideConnection.connectionProvider();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, ac_no);
		st.setString(2, name);
		st.setInt(3, op_bal);
		st.setString(4, pin);
		int count = st.executeUpdate();
		if (count == 1) {
			System.out.println();
			System.out.println("Account Created :)");
			System.out.println();
			return;
		}
	}

}
