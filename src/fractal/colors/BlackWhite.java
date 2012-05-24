package fractal.colors;

public class BlackWhite implements ColorTheme {
    
    int ci, cmax, c;
    
    public String name() {
        return "B&W";
    }

    public void setIteration(int its, int maxit) {
        ci = its;
        cmax = maxit;
        c = ci * 255 / maxit;
        c = (c + 1) % 2 * 255;
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
