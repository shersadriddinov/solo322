import java.util.Locale;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        boolean flag = true;
        while (flag){
            int choose;
            System.out.println("1. To add new account");
            System.out.println("2. To add new transaction");
            System.out.println("3. To add new bet");
            System.out.println("4. Exit");
            choose = input.nextInt();
            switch (choose){
                case 1:
                    Login_Name();
                    break;
                case 2:
                    addTransaction();
                    break;
                case 3:
                    addBet();
                    break;
                case 4:
                    System.exit(0);
                    default:
                        System.out.println("Enter appropriate integer to choose");
                        break;
            }
        }
    }

    // Add Login_Name to account
    public static void Login_Name(){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();

        System.out.println("Enter login name to create account: ");
        String login;
        login = input.nextLine();
        data.insertToAccount(login);
    }

    // Add Transactions to account
    public static void addTransaction(){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();

        // Enter Login
        System.out.println("Enter login: ");
        String login = input.nextLine();

        // Enter Transaction type_bet
        System.out.println("Bet(1) or Bank transaction(0)?: ");
        int type_bet = input.nextInt();

        // Enter Transaction type_with
        System.out.println("Withdrawal(1) or deposit(0)?: ");
        int type_with = input.nextInt();

        // Sum
        System.out.println("Enter sum: ");
        float sum = input.nextFloat();

        data.insertToTransactions(login, type_bet, type_with, sum);
    }

    // Add bet to bet_history
    public static void addBet(){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();
        input.useLocale(Locale.US);

        // Enter Login
        System.out.println("Enter login: ");
        String login = input.nextLine();

        // Enter Bet
        System.out.println("Enter bet: ");
        String bet = input.nextLine();

        // Enter Sum
        System.out.println("Enter total strake: ");
        double total_strake = input.nextDouble();

        // Enter odd
        System.out.println("Enter odd: ");
        double odd = input.nextDouble();

        // Enter status
        System.out.println("Result: YES (1) or NO (0)");
        int status = input.nextInt();

        data.insertToBetting_history(login, bet, total_strake, odd, status);
    }
}