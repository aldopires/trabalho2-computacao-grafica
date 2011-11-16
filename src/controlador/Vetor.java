package controlador;

import java.io.Serializable;
import modelo.objeto3d.Ponto3d;

public class Vetor implements Serializable{
  private double x, y, z;

  public Vetor(double x, double y, double z) {
    this.setX(x);
    this.setY(y);
    this.setZ(z);
  }

  public Vetor(Ponto3d ponto1, Ponto3d ponto2) {
    Ponto3d ponto = ponto2.sub(ponto1);
    this.x = ponto.getX();
    this.y = ponto.getY();
    this.z = ponto.getZ();
    normalizar();
  }

  public Vetor() {
    this.x = this.y = this.z = 0;
  }

  public double getX() {
    return  this.x;
  }

  public double getY() {
    return  this.y;
  }

  public double getZ() {
    return  this.z;
  }

  public void setX(double x) {
    this.x =x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public static Ponto3d tranformarPonto(Vetor vetor){
    return new Ponto3d(vetor.getX(), vetor.getY(), vetor.getZ());
  }
  public Vetor copiar() {
    return new Vetor(this.getX(), this.getY(), this.getZ());
  }

  public double getNorma() {
    return  Math.sqrt(Math.pow(getX(), 2) +
                             Math.pow(getY(), 2) +
                             Math.pow(getZ(), 2));
  }

  public void escala(double e) {
    this.mult(new Vetor(e, e, e));
  }

  public void normalizar() {
    if (this.getNorma() != 0) {
      this.escala(1 / this.getNorma());
    }
  }

  public void soma(Vetor v) {
    this.setX(this.getX() + v.getX());
    this.setY(this.getY() + v.getY());
    this.setZ(this.getZ() + v.getZ());
  }

  public static Vetor soma(Vetor u, Vetor v) {
    Vetor r = u.copiar();
    r.soma(v);
    return r;
  }

  public void sub(Vetor v) {
    this.setX(this.getX() - v.getX());
    this.setY(this.getY() - v.getY());
    this.setZ(this.getZ() - v.getZ());
  }

  public static Vetor sub(Vetor u, Vetor v) {
    Vetor r = u.copiar();
    r.sub(v);
    return r;
  }

  public void mult(Vetor v) {
    this.setX(this.getX() * v.getX());
    this.setY(this.getY() * v.getY());
    this.setZ(this.getZ() * v.getZ());
  }

  public static Vetor mult(Vetor u, Vetor v) {
    Vetor r = u.copiar();
    r.mult(v);
    return r;
  }

  public void div(Vetor v) {
    this.setX(this.getX() / v.getX());
    this.setY(this.getY() / v.getY());
    this.setZ(this.getZ() / v.getZ());
  }

  public static Vetor div(Vetor u, Vetor v) {
    Vetor r = u.copiar();
    r.mult(v);
    return r;
  }

  public static Vetor produtoVetorial(Vetor u, Vetor v) {
    double a = (u.getY() * v.getZ()) - (u.getZ() * v.getY());
    double b = (u.getZ() * v.getX()) - (u.getX() * v.getZ());
    double c = (u.getX() * v.getY()) - (u.getY() * v.getX());
    return new Vetor(a, b, c);
  }

  public static Vetor modulo(Vetor vetor){
    Vetor temp = vetor.copiar();
    temp.setX(Math.abs(temp.getX()));
    temp.setY(Math.abs(temp.getY()));
    temp.setZ(Math.abs(temp.getZ()));
    return temp;
  }


  public double produtoInterno(Vetor v) {
    return this.getX() * v.getX() +
        this.getY() * v.getY() +
        this.getZ() * v.getZ();
  }

  public static double produtoInterno(Vetor u, Vetor v) {
    Vetor r = u.copiar();
    return r.produtoInterno(v);
  }

  public void mult(double constante) {
      this.x = this.x * constante;
      this.y = this.y * constante;
      this.z = this.z * constante;
  }

  public static Vetor mult(double constante, Vetor vetor) {
    Vetor r = vetor.copiar();
    r.mult(constante);
    return r;
  }

    @Override
  public String toString() {
    return "(" + x + ", " + y + ", " + z + ")";
  }

}
