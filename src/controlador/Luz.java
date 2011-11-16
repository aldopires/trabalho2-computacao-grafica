package controlador;

import java.awt.Color;
import java.io.Serializable;
import modelo.objeto3d.Ponto3d;

public class Luz implements Serializable{
  private Ponto3d posicaoLuz;
  private Color Ie;

  public Luz(Ponto3d posicaoLuz, Color Ie){
    this.posicaoLuz = posicaoLuz;
    this.Ie = Ie;
  }

  public void setPosicaoLuz(Ponto3d posicaoLuz) {
    this.posicaoLuz = posicaoLuz;
  }

  public void setIe(Color Ie) {
    this.Ie = Ie;
  }

  public Ponto3d getPosicaoLuz() {
    return this.posicaoLuz;
  }

  public Color getIe() {
    return this.Ie;
  }
}
