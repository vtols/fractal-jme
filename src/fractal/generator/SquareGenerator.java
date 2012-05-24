package fractal.generator;

public class SquareGenerator implements FractalGenerator {
    
    double px, py, zx, zy;
    
    public void setXY(double nx, double ny) {
        px = nx;
        py = ny;
        zx = zy = 0.0;
    }

    public void next() {
        double zxnext = zx * zx - zy * zy + px;
        zy = 2 * zx * zy + py;
        zx = zxnext;
    }

    public double x() {
        return zx;
    }

    public double y() {
        return zy;
    }

    public boolean absLess2() {
        return zx * zx + zy * zy < 4;
    }
    
}
