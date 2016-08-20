package com.bank.main;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.bank.dao.BankDAO;
import com.bank.exceptions.IncorrectInputException;
import com.bank.model.Bank;
import com.bank.model.BankUser;

public class MainClass {
	/*
	 * Please place breakpoints and step through the code using the debugger to help grasp the flow!
	 * It's the bug looking tool at the top
	 */

	private static Scanner scanner = new Scanner(System.in); // Scanner

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		// init();
		runBank();

	}

	/*
	 * Run bank
	 */
	private static void runBank() {

		Bank bank = new BankDAO().getBank();
		BankUser user = performLogin(bank);
		startUserSession(user, bank);

	}

	private static void startUserSession(BankUser user, Bank bank) {

		printHelp(user);

		boolean continueSession = true;
		while (continueSession) {

			try {
				int input = getInput();
				performCommand(input, user, bank);

			} catch (IncorrectInputException e) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Incorrect input. Press 3 for HELP");
				System.out.println("--------------------------------------------------------------------------------");
			}

		}

	}

	private static void performCommand(int input, BankUser user, Bank bank) {

		switch (input) {
		case 1: // Deposit
			performDeposit(user);
			break;
		case 2: // Withdraw
			performWithdraw(user);
			break;
		case 3: // HELP
			printHelp(user);
			break;
		case 4: // LOGOUT
			logout(user, bank);
			break;
		default:
			// My logic must be wrong

		}

	}

	private static void performDeposit(BankUser user) {
		boolean tryingToEnterAmount = true;
		while (tryingToEnterAmount) {
			System.out.print("Enter amount:");
			String amountStr = scanner.nextLine();

			try {
				double amount = Double.parseDouble(amountStr);
				if (amount > 0) {
					tryingToEnterAmount = false;
					user.setBalance(user.getBalance() + amount);
					System.out.printf("SUCCESS: Current Balance: $%.2f\n", user.getBalance());
					System.out.println("Enter another command or 3 for HELP.");
				} else {
					System.out.println(
							"--------------------------------------------------------------------------------");
					System.out.println("Incorrect amount. Please enter positive number.");
					System.out.println(
							"--------------------------------------------------------------------------------");
				}
			} catch (NumberFormatException e) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Incorrect amount. Please enter positive number.");
				System.out.println("--------------------------------------------------------------------------------");
			}

		}
	}

	private static void performWithdraw(BankUser user) {
		boolean tryingToEnterAmount = true;
		while (tryingToEnterAmount) {
			System.out.print("Enter amount:");
			String amountStr = scanner.nextLine();

			try {
				double amount = Double.parseDouble(amountStr);
				if ((amount > 0) && (amount <= user.getBalance())) {
					tryingToEnterAmount = false;
					user.setBalance(user.getBalance() - amount);
					System.out.printf("SUCCESS: Current Balance: $%.2f\n", user.getBalance());
					System.out.println("Enter another command or 3 for HELP.");
				} else {
					System.out.println(
							"--------------------------------------------------------------------------------");
					System.out
							.println("Incorrect amount. Please enter positive number that is less than your balance.");
					System.out.println(
							"--------------------------------------------------------------------------------");
				}
			} catch (NumberFormatException e) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Incorrect amount. Please enter positive number that is less than your balance.");
				System.out.println("--------------------------------------------------------------------------------");
			}

		}
	}

	private static void printHelp(BankUser user) {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Welcome, " + user.getUsername());
		System.out.printf("Current Balance: $%.2f\n", user.getBalance());
		System.out.println("Commands:");
		System.out.println("\t1 - Deposit");
		System.out.println("\t2 - Withdraw");
		System.out.println("\t3 - HELP");
		System.out.println("\t4 - LOGOUT");
		System.out.println("--------------------------------------------------------------------------------");
	}

	private static void logout(BankUser user, Bank bank) {
		List<BankUser> users = bank.getUsers();

		ListIterator<BankUser> listIterator = users.listIterator();

		while (listIterator.hasNext()) {
			BankUser currentUser = listIterator.next();
			if (currentUser.getUsername().equals(user.getUsername())) {
				listIterator.set(user); // Update user in list
				break;
			}
		}
		// ASSERT: user updated

		new BankDAO().saveBank(bank); // Persist.

		System.out.println("Bye!");
		System.exit(1);

	}

	private static int getInput() throws IncorrectInputException {

		String inputStr = scanner.nextLine();

		try {
			int input = Integer.parseInt(inputStr);
			if ((input < 1) || (input > 4)) { // use enum
				throw new IncorrectInputException("User input must be between 1 and 4. User entered: " + input);
			}
			// ASSERT: User input correct.
			return input;

		} catch (NumberFormatException e) {
			throw new IncorrectInputException(e);
		}

	}

	private static BankUser performLogin(Bank bank) {
		BankUser user = null;

		boolean tryLogin = true;

		while (tryLogin) {
			System.out.println(
					"--------------------------------------------------------------------------------\nDon't enter username and password to cancel login.\n--------------------------------------------------------------------------------");

			System.out.print("Enter Username: ");
			String username = scanner.nextLine();
			System.out.print("Enter Password: ");
			String password = scanner.nextLine();

			if (username.equals("") && password.equals("")) {
				System.out.println("Bye!");
				System.exit(1);
			}

			user = findUser(username, password, bank);
			// ASSERT: if successful login, then user is not null.
			if (user != null) {
				// ASSERT: Successful login.
				tryLogin = false;

			} else {
				// ASSERT: Failed login.
				System.out.println(
						"--------------------------------------------------------------------------------\nFAILED LOGIN. Please try again.\n--------------------------------------------------------------------------------");
			}
		}
		// ASSERT: user is not null
		return user;
	}

	private static BankUser findUser(String username, String password, Bank bank) {
		if (bank != null) { //NullCheck Try placing a 1 next to the bank tag in the XML find without this check
							//Then Remove/comment out this nullcheck and login again
			for (BankUser user : bank.getUsers()) {
				if (user.getUsername().equals(username)) {
					// ASSERT: Found username.
					if (user.getPassword().equals(password)) {
						// ASSERT: Successful login.
						return user;
					} else {
						/*
						 * ASSERT: Found unique username with incorrect
						 * password. No point in continuing search.
						 */
						return null;
					}
				}
			}
		}
		// ASSERT: Exhausted search of data. Must be failed login.
		return null;
	}

	/*
	 * Initialize data
	 */
	private static void init() {
		List<BankUser> users = new LinkedList<>();
		users.add(new BankUser("john", "123", 1200.00));
		users.add(new BankUser("amy", "456", 2.11));
		users.add(new BankUser("austin", "789", 10000.09));
		users.add(new BankUser("katie", "010", 100.01));
		users.add(new BankUser("courtney", "321", 99.99));

		Bank initBank = new Bank(users);
		new BankDAO().saveBank(initBank);
	}

}
