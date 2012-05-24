package fractal.generator;

public interface FractalGenerator {
    
    void setXY(double nx, double ny);
    
    void next();
    
    double x();
    
    double y();
    
    boolean absLess2();
    
}
