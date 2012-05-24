package fractal.colors;

public class Gray implements ColorTheme {
    
    int ci, cmax, c;
    
    public String name() {
        return "Gray";
    }

    public void setIteration(int its, int maxit) {
        ci = its;
        cmax = maxit;
        c = 255 - ci * 255 / maxit;
    }

    public int red() {
        return c;
    }

    public int green() {
        return c;
    }

    public int blue() {
        return c;
    }
}
