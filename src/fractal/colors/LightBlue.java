package fractal.colors;

public class LightBlue implements ColorTheme {
    
    int ci, cmax, c;
    
    public String name() {
        return "Light blue";
    }

    public void setIteration(int its, int maxit) {
        ci = its;
        cmax = maxit;
        c = ci * 255 / maxit;
        c = 255 - c % 2 * 50;
    }

    public int red() {
        return c;
    }

    public int green() {
        return c;
    }

    public int blue() {
        return 255;
    }
}