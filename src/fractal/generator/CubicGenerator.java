package fractal.generator;

public class CubicGenerator implements FractalGenerator {
    
    double px, py, zx, zy;
    
    public void setXY(double nx, double ny) {
        px = nx;
        py = ny;
        zx = zy = 0.0;
    }

    public void next() {
        double zxnext = zx * zx * zx - 3 * zx * zy * zy + px;
        zy = 3 * zx * zx * zy - zy * zy * zy + py;
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
