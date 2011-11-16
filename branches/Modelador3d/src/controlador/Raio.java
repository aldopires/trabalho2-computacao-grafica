package controlador;

import java.io.Serializable;
import modelo.objeto3d.Ponto3d;

public class Raio implements Serializable{
  private Ponto3d origem;
  private Vetor direcao;

  public Raio(Ponto3d origem, Vetor direcao) {
    this.origem = origem;
    this.direcao = direcao;
    this.direcao.normalizar();
  }

  public Vetor getDirecao() {
    return direcao;
  }

  public Ponto3d getOrigem() {
    return origem;
  }

  public void setDirecao(Vetor direcao) {
    this.direcao = direcao;
  }

  public void setOrigem(Ponto3d origem) {
    this.origem = origem;
  }

  public String toString(){
    return "Raio: O = " + this.origem.toString() + ", D = " +this.direcao.toString();
  }
}
