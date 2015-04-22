/**
 *
 * http://www.academia.edu/8433988/Cox-Ross-Rubinstein_Model_Java_
 *
 */
import java.util.Scanner;

public class CoxRossRubinstein
{
    // returns the risk neutral probability of an up movement
    public static double RiskNeutralProbability(double down, double up, double r)
    {
        double q = (r - down) / (up - down);
        return q;
    }

    //
    public static double StockEvolution(double S_0, double down, double up, int totalsteps, int upsteps)
    {
        // check validity of inputs
        while(upsteps < 0 || upsteps > totalsteps)
        {
            System.out.println("Invalid parameter values, try again.");
            Scanner temp = new Scanner(System.in);
            upsteps = temp.nextInt();
        }
        // Compute the stock evolution
        double S_t = S_0*(Math.pow(up, upsteps))*(Math.pow(down, totalsteps - upsteps));
        // return stock value at n-th step
        return S_t;
    }

    // return payoff of vanilla call option
    public static double CallPayoff(double S, double K)
    {
        return Math.max(S - K, 0.0);
    }

    // return payoff of vanilla put option
    public static double PutPayoff(double S, double K)
    {
        return Math.max(K - S, 0.0);
    }

    // American only; European not implemented
    public static double BinomialPricer(double S_0, double down, double up, double r, int steps, double K)
    {
        Scanner temp = new Scanner(System.in);

        // check validity of inputs
        if(S_0 <= 0.0 || up <= -1.0 || down <= -1.0 || r <= -1.0 || up <= down)
        {
            System.out.println("Wrong Inputs, exiting program.");
            System.exit(1);
        }
        // no arbitrage
        if(r < down || r > up)
        {
            System.out.println("Wrong Inputs, exiting program.");
            System.exit(1);
        }
        // stores all the values of the option
        double[] prices = new double[steps + 1];
        double q = RiskNeutralProbability(down, up, r);

        System.out.println("\n" + "Select one of the following options: " +
                "\n" + "1 - Vanilla Call" + "\n" + "2 - Vanilla Put" + "\n");

        int selection = temp.nextInt();

        if(selection == 1)
        {
            for(int i = 0; i <= steps; i++)
            {
                prices[i] = CallPayoff(StockEvolution(S_0, down, up, steps, i), K);
            }
        }
        else if (selection == 2)
        {
            for(int i = 0; i <= steps; i++)
            {
                prices[i] = PutPayoff(StockEvolution(S_0, down, up, steps, i), K);
            }
        }
        else
        {
            System.out.println("That was not a valid selection, exiting program.");
            System.exit(1);
        }

        for(int n = steps - 1; n >= 0; n--)
        {
            for(int i = 0; i <= n; i++)
            {
                prices[i] = (1 / r) * (prices[i + 1] * q + (1 - q) * prices[i]);

                if(selection == 1 && (StockEvolution(S_0, down, up, n, i) - K) > prices[i])
                {
                    prices[i] = StockEvolution(S_0, down, up, n, i) - K;
                }
                if(selection == 2 && (StockEvolution(S_0, down, up, n, i)) > prices[i])
                {
                    prices[i] = K - StockEvolution(S_0, down, up, n, i);
                }
            }
        }
        // return the price at time zero of the option
        return prices[0];
    }






























}
