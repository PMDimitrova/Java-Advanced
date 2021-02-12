import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<BankAccount> listOfAccounts = new LinkedList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Create")) {
                BankAccount account = new BankAccount();
                listOfAccounts.add(account);
                System.out.printf("Account ID%d created%n", account.getId());

            } else if (tokens[0].equals("Deposit")) {
                int accountIndex = Integer.parseInt(tokens[1]) - 1;
                double sumToDeposit = Double.parseDouble(tokens[2]);
                if (accountIsAlreadyCreated(accountIndex, listOfAccounts)) {
                    BankAccount currentAcc = listOfAccounts.get(accountIndex);
                    currentAcc.deposit(sumToDeposit);
                    System.out.printf("Deposited %.0f to ID%d%n",
                            sumToDeposit, (accountIndex+1));       //може да изгърми в закръглянето
                } else {
                    System.out.println("Account does not exist");
                }

            } else if (tokens[0].equals("SetInterest")) {
                double intRateNew = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(intRateNew);

            } else if (tokens[0].equals("GetInterest")) {
                int accountIndex = Integer.parseInt(tokens[1]) - 1;
                int years = Integer.parseInt(tokens[2]);
                if (accountIsAlreadyCreated(accountIndex, listOfAccounts)){
                BankAccount currentAcc = listOfAccounts.get(accountIndex);
                double interest = currentAcc.getInterest(years);
                System.out.printf("%.2f%n", interest);}else{
                    System.out.println("Account does not exist");
                }
            }
            input = scan.nextLine();
        }

        System.out.println();
    }

    private static boolean accountIsAlreadyCreated(int index, List<BankAccount> list) {
        if (index < list.size()) {
            return true;
        } else {
            return false;
        }
    }
}
