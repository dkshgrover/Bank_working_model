package Bank_Account;

public class PinCheck {
	public int check_pin(String pin) {
		if (pin.length() != 4) {
			System.out.println("Invalid PIN. Length Must Be Equal to 4 and First Chracter Must Not Be Zero.");
			return 0;
		}
		if (pin.charAt(0) == '0') {
			System.out.println("Invalid PIN. First Chracter Must Not Be Zero and Length Must Be Equal to 4.");
			return -1;
		}
		return 1;
	}
}
