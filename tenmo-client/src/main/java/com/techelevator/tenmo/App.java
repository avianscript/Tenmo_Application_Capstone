package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.TenmoService;

import java.math.BigDecimal;
import java.util.Arrays;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private TenmoService tenmoService = new TenmoService(API_BASE_URL);
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
//                viewCurrentBalance();
                viewCurrentBalance(currentUser.getUser().getId());
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();

            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance(Long id) {
		// TODO Auto-generated method stub
        BigDecimal currentBalance = tenmoService.getCurrentBalance(id);
        // currentUser.getUser().getId()
        System.out.println(currentBalance);
	}

	private void viewTransferHistory() {
		// TODO Auto-generated method stub
		
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() {
		// TODO Auto-generated method stub
        //have to put in param of how much we're sending
        //return list of users
        User[] allUsers = tenmoService.displayListOfUsers();

        if (allUsers != null) {
            System.out.println("*********************");
            System.out.println("Users");
            System.out.println("ID         Name");
            System.out.println("*********************");
            for (User user : allUsers) {
                System.out.print(user.getId() + "       ");
                System.out.println(user.getUsername());
            }
            System.out.println("");

            String enterUserId = "Enter ID of user you are sending to (0 to cancel): ";
            int chosenUserId;
            do {
                chosenUserId = consoleService.promptForInt(enterUserId);
                    } while (chosenUserId == currentUser.getUser().getId());


            // TRANSFER AMOUNT VARIABLE = TRANSFER AMOUNT
            String enterTransferAmount = "Enter Amount: ";
            BigDecimal transferAmount = consoleService.promptForBigDecimal(enterTransferAmount);
            System.out.println(chosenUserId + " " + transferAmount);

            /*
            * PAUSED FRIDAY
            * */
//            Transfer transfer = tenmoService.createTransfer(transferAmount, currentUser.getUser().getId(), chosenUserId);
        }

        // Transfer includes User IDs of the from and to users and the amount of TE Bucks
        // BigDecimal transferAmount;
        // int chosenUser = userId of the accountTo
            // JOIN user table on userId WHERE userId = accountId



	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}

}
