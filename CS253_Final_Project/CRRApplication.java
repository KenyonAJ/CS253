/**
 * http://www.academia.edu/8433988/Cox-Ross-Rubinstein_Model_Java_
 */
public class CRRApplication
{
    public static void main(String[] args)
    {
        double S_0 = 100.0; // initial value for the stock
        double K = 100.0; // Strike
        double d = 0.6; // Down
        double r = 1.05; // 1 + interest rate
        double u = 1.5; // Up
        int n = 2; // steps

        CoxRossRubinstein pricer = new CoxRossRubinstein();

        System.out.println("\n" + "The option price is: $" +
                Math.round(pricer.BinomialPricer(S_0, d, u, r, n, K)*1000.0)/1000.0);
    }
}
