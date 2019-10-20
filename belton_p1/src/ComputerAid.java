import java.util.Scanner;
import java.security.SecureRandom;

class Question {
    private int a;
    private int b;
    private final char op;
    private final int answer;

    public Question(int a, int b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;

        if (op == '+')
            answer = a + b;
        else if (op == '-')
            answer = a - b;
        else if (op == '*')
            answer = a * b;
        else if (op == '/')
            answer = a / b;
        else
        {
            answer = 0;
            System.err.println("Invalid operation!!!");
        }
    }

    public int testUser(Scanner sc) {
        int numWrong = 0;

        while (true)
        {
            System.out.print("How much is " + a + " " + op + " " + b + "?: ");
            int userAnswer = sc.nextInt();

            if (userAnswer == answer)
            {
                correctResponse();
                return numWrong;
            }
            else
            {
                incorrectResponse();
                numWrong++;
            }
        }
    }

    public static void incorrectResponse()
    {
        SecureRandom rand = new SecureRandom();
        String[] responses = new String[4];
        responses[0] = "No. Please try again.";
        responses[1] = "Wrong. Try once more.";
        responses[2] = "Don't give up!";
        responses[3] = "No. Keep trying";

        System.out.printf("%s\n", responses[rand.nextInt(4)]);
    }
    public static void correctResponse()
    {
        SecureRandom rand = new SecureRandom();
        String[] responses = new String[4];
        responses[0] = "Very good!";
        responses[1] = "Excellent!";
        responses[2] = "Nice Work!";
        responses[3] = "Keep up the good work";

        System.out.println(responses[rand.nextInt(4)]);
    }
}

public class ComputerAid {

    public static int difficulty(Scanner sc)
    {
        System.out.println("How difficult would you like the questions to be on a scale of 1 - 4?");
        int response = sc.nextInt();
        return (int)Math.pow(10, response);
    }

    public static int problemType(Scanner sc)
    {
        System.out.println("What type of problems would you like?");
        System.out.println("1. Addition(+)\t2. Multiplication(*)\t3. Subtraction(-)\t4. Division(/)\t5.) Random");

        return sc.nextInt() - 1;
    }

    public static void main (String[] args)
    {
        SecureRandom rand = new SecureRandom();
        Scanner sc = new Scanner(System.in);
        int op = rand.nextInt(4);
        boolean doRandomProblems = false;

        while (true)
        {
            op = problemType(sc);
            int diff = difficulty(sc);

            if (op == 4)
                doRandomProblems = true;


            int numWrong = 0;

            for (int i = 1; i <= 10; i++) {
                int num1 = rand.nextInt(diff);
                int num2 = rand.nextInt(diff);

                char temp;

                if (doRandomProblems)
                    op = rand.nextInt(4);

                if (op == 0)
                    temp = '+';
                else if (op == 1)
                    temp = '*';
                else if (op == 2)
                    temp = '-';
                else
                    temp = '/';

                Question q = new Question(num1, num2, temp);
                if (q.testUser(sc) > 0)
                    numWrong++;
            }

            if (((double)numWrong / 10) * 100.0 > 25.0)
                System.out.println("Please ask your teacher for extra help.");
            else
                System.out.println("Congratulations, you are ready to go to the next level!");

            System.out.print("Would you like to continue?(Y/N):");

            String buff = sc.next();
            char b = buff.charAt(0);
            b = Character.toLowerCase(b);

            if (b != 'y')
                break;
        }

        sc.close();
    }
}
