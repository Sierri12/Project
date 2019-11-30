package Wojaro;

public class RootSolver {

    public static double bisekcja(double xl, double xu,double eaMax,int iMax, ScalarFunction f) {
        int y = 1;
        double xrOld = 0;
        double xr;
        while (true) {
            xr = (xl + xu) / 2;
            double fxr = f.function(xr);
            double fxl = f.function(xl);


            if (fxr * fxl < 0) {
                xu = xr;

            } else if (fxl * fxr > 0) {
                xl = xr;


            } else if (fxl * fxr == 0) {
                xl = xr;
                xu = xr;

            }
            double ea = Math.abs(((xr - xrOld) / xr) * 100);
            if (ea > eaMax && y<iMax) {
                xrOld = xr;
                y++;
            } else {
                break;
            }

        }
        return xr;
    }



}
