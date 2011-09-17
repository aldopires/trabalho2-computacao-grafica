/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.awt.Color;

/**
 *
 * @author TyTu
 */
public class ZBufferPixel {
    boolean enabled=true;
    Color cor= Color.BLUE;

    public ZBufferPixel(Color cor) {
        this.cor = cor;
        enabled=false;
    }
    
    

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
}
