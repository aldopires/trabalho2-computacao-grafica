/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author TyTu
 */
public class ZBuffer {
    ZBufferPixel[][] matriz;
    int x,y;

    public ZBuffer(int x, int y) {
        this.x=x;
        this.y=y;
        matriz=new ZBufferPixel[x][y];    
    }
    
    
    public ZBufferPixel[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(ZBufferPixel[][] matriz) {
        this.matriz = matriz;
    }
    
    public ZBufferPixel getMatriz(int x, int y) {
        return matriz[x][y];
    }

    public void setMatriz(ZBufferPixel p, int x, int y) {
        this.matriz[x][y] = p;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
}
