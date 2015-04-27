/**
 * Created by Andrew Kenyon on 4/25/2015.
 */
import java.text.*;
import static java.lang.Math.*;

public class Example
{
    public Example()
    {

    }

    public static void main(String[] args)
    {
        double[][]probprices = new double[11][2];
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(2);
        BinomParams bp = new BinomParams();
        bp.binomodel(0.0833,0.10,0.30,0.0);
        BinomPrice b = new BinomPrice(bp.getU(),bp.getD(),bp.getP());
        probprices=b.binodeVals(10,11,0,32.50);
        double summer = 0.0;
        System.out.println("PROBABILITY\t\tPRICE\tSUM of P");
        for(int i = 0; i < probprices.length-1; i++)
        {
            summer += (exp(probprices[i][0]));
            System.out.println(formatter.format(exp(probprices[i][0])) +
                    "\t\t\t" + formatter.format(exp(probprices[i][1])) +
                    "\t" + formatter.format(+summer));
        }

    }
}
