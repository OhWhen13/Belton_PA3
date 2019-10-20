public class SavingsAccount
{
    private double savingsBalance;
    public static double annualInterestRate;

    public SavingsAccount(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest()
    {
        double interestMonthly;
        interestMonthly = (this.savingsBalance*annualInterestRate/100/12);
        this.savingsBalance += interestMonthly;

        return 0.0;
    }

    public void printRate()
    {
        System.out.print(this.savingsBalance);
    }
    public static void setRate(double intRate)
    {
        annualInterestRate = intRate;
    }

    public static void main(String[] args)
    {
        SavingsAccount saver1, saver2;
        int i;
        saver1 = new SavingsAccount(2000.00);
        saver2 = new SavingsAccount(3000.00);

        SavingsAccount.annualInterestRate = 4.0;

        for(i = 1; i <= 12; ++i){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month %d:", i);
            saver1.printRate();
            System.out.print("\t");
            saver2.printRate();
            System.out.println();
        }
        System.out.println("Interest Rate: 5.0%");
        SavingsAccount.annualInterestRate = 5.0;
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.print("Month 13:");
        saver1.printRate();
        System.out.print("\t");
        saver2.printRate();


    }
}
