import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);


        while (true) {
            try {
                System.out.println("In your account " + account.getAmount() + "KGS");
                System.out.println("Enter the amount: ");
                Scanner scanner = new Scanner(System.in);
                account.withDraw(scanner.nextInt());
                System.out.println("Success. Your remaining account: " + account.getAmount() + "KGS");
            }catch (LimitException le) {
                System.out.println(le.getMessage());
                try {
                    account.withDraw((int) le.getRemainingAmount());
                }catch (LimitException le2){
                    throw new RuntimeException(le2);
                }
                System.out.println("In your account " + account.getAmount() + "KGS");
                break;
            }
        }

    }
}