/**
 * Created by Andrew Kenyon on 4/25/2015.
 */
public class BinomParams
{
    public BinomParams() {
    }

    private double p;
    private double u;
    private double d;
    private double g;
    private void setU(double uval) {
        u=uval;
    }
    private void setD(double dval) {
        d=dval;
    }
    private void setP(double pval) {
        p=pval;
    }
    private void setG(double gval) {
        g=gval;
    }
    public double getU() {
        return u;
    }
    public double getD() {
        return d;
    }
    public double getP() {
        return p;
    }
    public double getG() {
        return g;
    }
    public void binomodel(double time,double rate, double sigma,
                          double yield)//time is as fraction of the rate period
    {
        setG(Math.exp((rate-yield)*time));
        setU(Math.exp(sigma*Math.sqrt(time)));
        setD(floorvalue(Math.exp(-sigma*Math.sqrt(time))));
        setP(floorvalue((getG()-getD())/(getU()-getD())));
    }
    private double floorvalue(double x) {
        return Math.abs(x)<Csmallnumber.getSmallnumber()?Csmallnumber.getSmallnumber():x;
    }

}
