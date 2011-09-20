/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.objeto3d.Ponto3d;

/**
 *
 * @author Marcos
 */
public class AlvyRay {
        
        Ponto3d vrp ;
        
        
        //Camera camera = viewport.getCamera();
        
        double d;// = camera.getD();// distância entre o observador e o plano de projeção
        Ponto3d PontoParaOndeCameraAponta;
        
        
        double xmin , ymin , xmax , ymax ;// viewport
        double zmin , n , f ; // planos near e far(zmin, zmax)
        double dx = 0, dy = 0, dz = 0; // distancias
        double cu = 0, cv = 0, su , sv ;// parametros da window
        double Yx , Yy , Yz ;// view-up

        
        /**
         * 
         * @param vrp = posiçao do observador no mundo
         * @param d    = Ponto no qual as coordenadas Dx = Xmax - Xmin, Dy = Ymax - Ymin e Dz = (f) - (n)
         * @param PontoParaOndeCameraAponta
         * //Coordenadas extremas da Viewport para onde o mundo será mapeado
         * @param xmin
         * @param ymin
         * @param xmax
         * @param ymax
         * 
         * @param n = near
         * @param f = fear
         * 
         * @param su // su = 1/2 largura da window
         * @param sv // sv = 1/2 altura da window
         * //viewUP = vetor View-Up Usado para definir a direção vertical no plano de projeção
         * @param Yx
         * @param Yy
         * @param Yz 
         */
    public AlvyRay(Ponto3d vrp, 
            double d, 
            Ponto3d PontoParaOndeCameraAponta, 
            double xmin, 
            double ymin, 
            double xmax, 
            double ymax, 
            double n, 
            double f, 
            double su, 
            double sv, 
            double Yx, 
            double Yy, 
            double Yz) {
        
        this.vrp = vrp;
        this.d = d;
        this.PontoParaOndeCameraAponta = PontoParaOndeCameraAponta;
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
        this.n = n;
        this.f = f;
        this.su = su;
        this.sv = sv;
        this.Yx = Yx;
        this.Yy = Yy;
        this.Yz = Yz;
    }
        
        
        
    
    public Ponto3d alvyRay(Ponto3d vertex) {
        vertex=(Ponto3d) vertex.clone();
        double x = vertex.getX(), y = vertex.getY(), z = vertex.getZ();
        double px = PontoParaOndeCameraAponta.getX(), py = PontoParaOndeCameraAponta.getY(), pz = PontoParaOndeCameraAponta.getZ();// ponto para onde a cÃ¢mera está¡ apontando
        double vrpx = vrp.getX(), vrpy = vrp.getY(), vrpz = vrp.getZ();// posição do observador no mundo
        
        zmin = n / f;
        dx = xmax - xmin;
        dy = ymax - ymin;
        dz = f - n;

        // vetor N = P - VRP
        double nx = px - vrpx;
        double ny = py - vrpy;
        double nz = pz - vrpz;
        double nm = Math.sqrt(Math.pow(nx, 2) + Math.pow(ny, 2) + Math.pow(nz, 2));

        //Vetor n = N/|N|
        double nnx = nx / nm;
        double nny = ny / nm;
        double nnz = nz / nm;

        // Vetor V = Y - (Y.n).n
        double vx = Yx - (Yx * nnx + Yy * nny + Yz * nnz) * nnx;
        double vy = Yy - (Yx * nnx + Yy * nny + Yz * nnz) * nny;
        double vz = Yz - (Yx * nnx + Yy * nny + Yz * nnz) * nnz;
        double vm = Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2) + Math.pow(vz, 2));

        // Vetor v = V/|V|
        double vvx = vx / vm;
        double vvy = vy / vm;
        double vvz = vz / vm;

        // Vetor u = n x v
        double uux = nny * vvz - vvy * nnz;
        double uuy = nnz * vvx - nnx * vvz;
        double uuz = nnx * vvy - vvx * nny;

        // V
        double vvrpx = (uux * (-vrpx)) + (uuy * (-vrpy)) + (uuz * (-vrpz));
        double vvrpy = (vvx * (-vrpx)) + (vvy * (-vrpy)) + (vvz * (-vrpz));
        double vvrpz = (nnx * (-vrpx)) + (nny * (-vrpy)) + (nnz * (-vrpz));

        // C
        double E = d / (su * f);
        double F = d / (sv * f);
        double G = 1 / f;
        double H = (-cu / d) * (d / (su * f));
        double I = (-cv / d) * (d / (sv * f));

        // P
        double A = ((1 / (1 - zmin)) * (1 / zmin)) * zmin;
        double C = (((1 / (1 - zmin)) * (-zmin)) * (1 / zmin)) * zmin;
        double B = (((1 - zmin) / zmin) * (1 / (1 - zmin))) * zmin;
        double D = ((((1 - zmin) / zmin) * (1 / (1 - zmin)) * (-zmin)) + 1) * zmin;

        // S
        double J = 0.5 * dx;
        double K = 0.5 * dy;
        double L = (0.5 * dx) + xmin + 0.5;
        double M = (0.5 * dy) + ymin + 0.5;
        double N = n + 0.5;

        double w = (B * G * nnx) * x + (B * G * nny) * y + (B * G * nnz) * z + (B * G * vvrpz + D);
        double x1 = (((J * E * uux) + (J * H + L * B * G) * nnx) * x + ((J * E * uuy) + (J * H + L * B * G) * nny) * y + ((J * E * uuz) + (J * H + L * B * G) * nnz) * z + ((J * E * vvrpx) + (J * H + L * B * G) * vvrpz + (L * D))) / w;
        double y1 = (((K * F * vvx) + (K * I + M * B * G) * nnx) * x + ((K * F * vvy) + (K * I + M * B * G) * nny) * y + ((K * F * vvz) + (K * I + M * B * G) * nnz) * z + ((K * F * vvrpy) + (K * I + M * B * G) * vvrpz + (M * D))) / w;
        double z1 = (((dz * A + N * B) * G * nnx) * x + ((dz * A + N * B) * G * nny) * y + ((dz * A + N * B) * G * nnz) * z + (((dz * A + N * B) * G * vvrpz) + (dz * C + N * D))) / w;

        vertex.setX(x1);
        vertex.setY(y1);
        vertex.setZ(z1);
        
        return vertex;
    }

    public Ponto3d getPontoParaOndeCameraAponta() {
        return PontoParaOndeCameraAponta;
    }

    public double getYx() {
        return Yx;
    }

    public double getYy() {
        return Yy;
    }

    public double getYz() {
        return Yz;
    }

    public double getCu() {
        return cu;
    }

    public double getCv() {
        return cv;
    }

    public double getD() {
        return d;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getDz() {
        return dz;
    }

    public double getF() {
        return f;
    }

    public double getN() {
        return n;
    }

    public double getSu() {
        return su;
    }

    public double getSv() {
        return sv;
    }

    public Ponto3d getVrp() {
        return vrp;
    }

    public double getXmax() {
        return xmax;
    }

    public double getXmin() {
        return xmin;
    }

    public double getYmax() {
        return ymax;
    }

    public double getYmin() {
        return ymin;
    }

    public double getZmin() {
        return zmin;
    }
    
    
    
}
