import java.util.Scanner;

class ATM {
    private double balance;
    private String pin;
    public ATM(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean verifyPin(String Pin) {
        return this.pin.equals(Pin);
    }

    public void checkBalance() {
        System.out.println("Your current balance: ₹" + this.balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
            checkBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM myATM = new ATM("1234", 5000.0); 

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (myATM.verifyPin(enteredPin)) {
            System.out.println("PIN Verified!");

            while (true) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        myATM.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        myATM.deposit(dep);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double wit = sc.nextDouble();
                        myATM.withdraw(wit);
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN! Access denied.");
        }
    }
}
