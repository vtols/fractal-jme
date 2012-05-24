package fractal;

import fractal.colors.*;
import fractal.generator.*;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class FractalCanvas extends GameCanvas {
    
    double zoom = 2.0, x = 0.0, y = 0.0;
    int maxIt = 30;
    Thread th;
    int thnum = 0, ctheme = 0, cgen = 0;
    Vector themes = new Vector(),
           gens = new Vector();
    
    public FractalCanvas(boolean arg) {
        super(arg);
        
        themes.addElement(new Gray());
        themes.addElement(new BlackWhite());
        themes.addElement(new LightBlue());
        themes.addElement(new Abstract());
        
        gens.addElement(new SquareGenerator());
        gens.addElement(new CubicGenerator());
        
        setFullScreenMode(true);
        paintThread();
    }
    
    final public void paintThread() {
        if (th != null)
            th.interrupt();
        th = null;
        th = new Thread(new FractalTask(getGraphics()));
        th.start();
    }
    
    public ColorTheme currentTheme() {
        return (ColorTheme) themes.elementAt(ctheme);
    }
    
    public FractalGenerator currentGenerator() {
        return (FractalGenerator) gens.elementAt(cgen);
    }
    
    public void paintFractal(Graphics g, int prec, int n) {
        int h = getHeight(), w = getWidth();
        double delta = zoom * 2 / h;
        ColorTheme cth = currentTheme();
        FractalGenerator gen = currentGenerator();
        for (int i = 0; i < h; i += prec)
            for (int j = 0; j < w; j += prec) {
                double px = (j - w / 2) * delta + x,
                       py = (i - h / 2) * delta + y;
                gen.setXY(px, py);
                int k;
                for (k = 0; k < maxIt && gen.absLess2(); k++)
                    gen.next();
                if (n != thnum)
                    return;
                cth.setIteration(k, maxIt);
                g.setColor(cth.red(), cth.green(), cth.blue());
                g.fillRect(j, i, prec, prec);
                repaint();
            }
    }
    
    protected void keyPressed(int code) {
        int h = getHeight(), w = getWidth();
        switch (code) {
            case KEY_POUND:
                zoom *= 2.0;
                paintThread();
                return;
            case KEY_STAR:
                zoom /= 2.0;
                paintThread();
                return;
            case KEY_NUM1:
                maxIt += 10;
                return;
            case KEY_NUM2:
                if (maxIt > 10)
                    maxIt -= 10;
                else
                    maxIt = 1;
                return;
            case KEY_NUM4:
                maxIt++;
                return;
            case KEY_NUM5:
                if (maxIt > 1)
                    maxIt--;
                return;
            case KEY_NUM3:
                paintThread();
                return;
            case KEY_NUM7:
                ctheme = (ctheme + 1) % themes.size();
                return;
            case KEY_NUM8:
                cgen = (cgen + 1) % gens.size();
                paintThread();
                return;
        }
        code = this.getGameAction(code);
        switch (code) {
            case FIRE:
                zoom /= 2.0;
                paintThread();
                return;
            case LEFT:
                x -= zoom / 4.0;
                paintThread();
                return;
            case RIGHT:
                x += zoom / 4.0;
                paintThread();
                return;
            case UP:
                y -= zoom / 4.0;
                paintThread();
                return;
            case DOWN:
                y += zoom / 4.0;
                paintThread();
                return;
        }
    }
    
    class FractalTask implements Runnable {
        Graphics g;
        
        FractalTask(Graphics g) {
            this.g = g;
        }
        
        public void run() {
            int n = ++thnum;
            FractalCanvas.this.paintFractal(g, 5, n);
            FractalCanvas.this.paintFractal(g, 2, n);
            FractalCanvas.this.paintFractal(g, 1, n);
            g.setColor(255, 127, 0);
            String thname = currentTheme().name();
            g.drawString("" + maxIt + " " + zoom + " " 
                    + thname + " " + cgen, 0, 0, 0);
        }
    }
    
}
