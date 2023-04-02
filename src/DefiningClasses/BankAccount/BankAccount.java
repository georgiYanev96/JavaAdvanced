package DefiningClasses.BankAccount;
//Create class BankAccount.
//The class should have private fields for:
//•	Id: int (Starts from 1 and increments for every new account)
//•	Balance: double
//•	Interest rate: double (Shared for all accounts. Default value: 0.02)
//The class should also have public methods for:
//•	setInterestRate(double interest): void (static)
//•	getInterest(int Years): double
//•	deposit(double amount): void
//Create a test client supporting the following commands:
//•	Create
//•	Deposit {Id} {Amount}
//•	SetInterest {Interest}
//•	GetInterest {ID} {Years}
//•	End
public class BankAccount  {
    private final  static  double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount(){
        this.id=bankAccountCount++;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount){
        this.balance += amount;
    }
    double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }
}
