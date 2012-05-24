package fractal.colors;

public class Abstract implements ColorTheme {
    
    int ci, cmax, c;
    
    public String name() {
        return "Abstract";
    }

    public void setIteration(int its, int maxit) {
        ci = its;
        cmax = maxit;
        c = 255 - ci * 255 / maxit;
    }

    public int red() {
        return (c * 4) % 255;
    }

    public int green() {
        return (c * 6) % 255;
    }

    public int blue() {
        return (c * 8) % 255;
    }
}
