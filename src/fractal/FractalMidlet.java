package fractal;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

public class FractalMidlet extends MIDlet {

    public void startApp() {
        Display disp = Display.getDisplay(this);
        disp.setCurrent(new FractalCanvas(false));
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
