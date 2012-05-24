package fractal.colors;

public interface ColorTheme {
    //public void setShift(); //TODO
    
    public String name();
    
    public void setIteration(int its, int maxit);
    
    public int red();
    
    public int green();
    
    public int blue();
    
}
