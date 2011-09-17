package mod;



public class AlvyRay {

    private Ponto VRP; // VRP = posição do observador no mundo
    private Ponto P; //P = Ponto para onde a câmera está apontada
    private Ponto viewUP; //viewUP = vetor View-Up Usado para definir a direção vertical no plano de projeção
    private Ponto D; //D = Ponto no qual as coordenadas Dx = Xmax - Xmin, Dy = Ymax - Ymin e Dz = (f) - (n)
    //Coordenadas extremas da Viewport para onde o mundo será mapeado
    private double minX; // X minimo
    private double minY; // Y minimo
    private double maxX; // X maximo 
    private double maxY; // Y maximo
    // (cu, cv) = centro da window
    // su = 1/2 largura da window
    // sv = 1/2 altura da window
    private double cu;
    private double cv;
    private double su; // su = 1/2 largura da window
    private double sv; // sv = 1/2 altura da window
    //Distâncias entre o observador e os planos de recorte frontal e traseiro
    private double near;//(near) = Zmin;
    private double far; //(far) = Zmax
    private double zmin; //zmin = (n)/(f)
    private double distancia;// distancia = distância entre o observador e o plano de projeção
    private double[][] mtp; //Matriz mtp Faz o mapeamento em perspectiva das coordenadas do objeto de SRU para SRT
    private double[][] mto; //Matriz mto Faz o mapeamento ortográfico das coordenadas do objeto de SRU para SRT
    
    
    public AlvyRay(){
        // não fiz nada
    }
    
    /**
     * <h3> Contrutor Default da Classe Alvy Ray</h3> <p>
     * 
     * 
     * @param VRP = posição do observador no mundo
     * @param P = Ponto para onde a câmera está apontada
     * @param viewUP  = vetor View-Up Usado para definir a direção vertical no plano de projeção <br>
     * <i>Coordenadas extremas da Viewport para onde o mundo será mapeado</i> <p>
     * @param minX = X minimo
     * @param minY = Y minimo
     * @param maxX = X maximo
     * @param maxY = Y maximo <br>
     * <i>(cu, cv) = centro da window </i> <p>
     * @param cu
     * @param cv
     * @param su = 1/2 largura da window
     * @param sv = 1/2 altura da window <br>
     * <i>Distâncias entre o observador e os planos de recorte frontal e traseiro </i> <p>
     * @param near = Zmin
     * @param far = Zmax
     * @param distancia  = distância entre o observador e o plano de projeção
     */
    public AlvyRay(Ponto VRP, Ponto P, Ponto viewUP, double minX, double minY, double maxX, 
            double maxY, double cu, double cv, double su, double sv, double near, double far, double distancia) {
        
        this.VRP = VRP;
        this.P = P;
        this.viewUP = viewUP;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.cu = cu;
        this.cv = cv;
        this.su = su;
        this.sv = sv;
        this.near = near;
        this.far = far;
        this.distancia = distancia;
        this.zmin = near / far;
        this.D = new Ponto((double)(maxX - minX), (double)(maxY - minY), (double)(far - near));
    }

    public double getFar() {
        return far;
    }

    public void setNF(double near, double far) {
        this.near = near;
        this.far = far;
        this.zmin = -near / far;
    }

    public double getNear() {
        return near;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getMaxX() {
        return maxX;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public double getMinX() {
        return minX;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public double getMinY() {
        return minY;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setD() {
        this.D.setX(maxX - minX);
        this.D.setY(maxY - minY);
        this.D.setZ(far - near);
    }

    public Ponto getD() {
        return D;
    }

    public double getCu() {
        return cu;
    }

    public void setCu(double cu) {
        this.cu = cu;
    }

    public double getCv() {
        return cv;
    }

    public void setCv(double cv) {
        this.cv = cv;
    }

    public double getSu() {
        return su;
    }

    public void setSu(double su) {
        this.su = su;
    }

    public double getSv() {
        return sv;
    }

    public void setSv(double sv) {
        this.sv = sv;
    }

    public double[][] getMtp() {
        return mtp;
    }

    public double[][] getMto() {
        return mto;
    }

    public Ponto getP() {
        return P;
    }

    public void setP(Ponto P) {
        this.P.setX(P.getX());
        this.P.setY(P.getY());
        this.P.setZ(P.getZ());
    }

    public Ponto getVRP() {
        return VRP;
    }

    public void setVRP(Ponto VRP) {
        this.VRP.setX(VRP.getX());
        this.VRP.setY(VRP.getY());
        this.VRP.setZ(VRP.getZ());
    }

    public Ponto getViewUP() {
        return viewUP;
    }

    public void setViewUP(Ponto viewUP) {
        this.viewUP = viewUP;
    }
//TODO Aqui começam os calculos

    public Objeto transformMtp(Objeto obj) {

        if (this.getMtp() == null) {
            System.out.println("Erro AlvyRay transformMtp01: Matriz Mtp não esta pronta.");
            return null;
        }
        Objeto objo = obj;//Cópia do objeto parâmetro
        Objeto saida = new Objeto();//objeto de saida
        Objeto auxsaida = new Objeto();//auxiliar que prepara o objeto transformado para ser adicionado na lista saida de objeto
        Objeto aux2saida = new Objeto();//auxiliar que percorre a lista de objetos de saida para que o novo objeto tratado em auxsaida seja adicionado ao final da lista
        Face aux = new Face();
        Face f = new Face();
        Aresta A1 = new Aresta();
        Aresta A2 = new Aresta();
        Aresta are = new Aresta();
        Ponto P1 = new Ponto();
        Ponto P2 = new Ponto();
        //Copiei então a lista de objetos para o objo, criei as variaveis Face f e Aresta are para suporte nos calculos. 
        for(int n=0;n<objo.getFaces().size();n++) {
            f = objo.getFaces().get(n);
            for(int j=0;j<objo.getFaces().get(n).getArestas().size();j++) {
                
                double[][] pt = new double[4][f.size()];//f.getLen()
                are =f.getArestas().get(j);  // f.getArestas();
                //Aqui eu adiciono o ponto inicial da primeira aresta, que precisa entrar como primeiro ponto da matriz
                pt[0][0] = are.getV1().getX(); //are.getIni().getX();
                pt[1][0] = are.getV1().getY(); //are.getIni().getY();
                pt[2][0] = are.getV1().getZ(); //are.getIni().getZ();
                pt[3][0] = 1;
                for (int i = 1; i < f.size(); i++) {
                    if (are == null) {
                        System.out.println("Erro AlvyRay02: Aresta não encontrada");
                        return null;
                    }
                    pt[0][i] = are.getV2().getX(); //are.getFim().getX();
                    pt[1][i] = are.getV1().getY(); //are.getFim().getY();
                    pt[2][i] = are.getV1().getZ(); //are.getFim().getZ();
                    pt[3][i] = 1;
                    are = f.getArestas().get(i);//are.getProx();
                }
                //Agora temos a matriz pt com todos os pontos da face, fazemos então o produto com a matriz
                pt =mtpXpontos(pt, f.size());// mtpXpontos(pt, f.getLen());
                //Agora MANEZÃO, faltou dividir por w, farei isso agr
                //for (int i = 0; i < f.getLen(); i++) {
                for (int i = 0; i < f.size(); i++) {
                    pt[1][i] = pt[1][i]/pt[3][i];
                    pt[2][i] = pt[2][i]/pt[3][i];
                    pt[3][i] = pt[3][i]/pt[3][i];
                }
                //Pontos transformados, agora vamos montar novamente a face e adicioná-la ao objeto de saída
                //É necessario criar a primeira aresta, para servir de base para as outras
                aux = new Face();
                P1 = new Ponto(pt[0][0], pt[1][0], pt[2][0]);
                P2 = new Ponto(pt[0][1], pt[1][1], pt[2][1]);
                A1 = new Aresta(P1, P2);
                aux.add(A1);//aux.addAresta(A1);
                A2 = A1;
                //for (int i = 2; i < f.getLen(); i++) {
                for (int i = 2; i < f.size(); i++) {
                    P2 = new Ponto(pt[0][i], pt[1][i], pt[2][i]);
                    A1 = new Aresta(A2.getV2(), P2);
                    aux.add(A1);//aux.addAresta(A1);
                    A2 = A1;
                }
                //Adiciona a última face
                A1 = new Aresta(A2.getV2(), P1);
                aux.add(A1);//aux.addAresta(A1);
                //Teoricamente aqui a Face ja pronta, com o boolean pronto verdadeiro, transformada, pronta para ser adicionada ao novo objeto
                auxsaida.addface(aux);//auxsaida.addFace(aux);
                f = objo.getFaces().get(j);//f.getProximo();
            }
            if (saida.getFaces() == null) {
                saida = auxsaida;
            } 
            /*else {
                aux2saida = saida;
                while (aux2saida.getProximo() != null) {
                    aux2saida = aux2saida.getProximo();
                }
                aux2saida.setProximo(auxsaida);
            }
            //teoricamente aqui esta pronto um novo objeto, a instancia passa para o proximo objeto de mundo para conversão
            objo = objo.getProximo();*/
        }
        return saida;
    }

    private double[][] mtpXpontos(double[][] pontos, int size) {
        double[][] res = new double[4][size];
        double soma = 0;
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < size; coluna++) {
                for (int k = 0; k < 4; k++) {
                    soma += mtp[linha][k] * pontos[k][coluna];
                }
                res[linha][coluna] = soma;
                soma = 0;
            }
        }
        return res;
    }

    public void geraMtp() {
        double[][] v = mundoTela();
        double[][] c = recorte();
        double[][] p = perspectiva();
        double[][] s = dispositivo();
//        printMat(v, 4, 4); //OK
//        printMat(c, 4, 4); //OK
//        printMat(p, 4, 4); //OK
//        printMat(s, 4, 4); //OK
        mtp = mulMatriz(c, v);
        mtp = mulMatriz(p, mtp);
        mtp = mulMatriz(s, mtp);
//        printMat(mtp, 4, 4); //OK
    }

    public Objeto transformMto(Objeto obj) {

        if (getMto() == null) {
            System.out.println("Erro AlvyRay transformMto01: Matriz Mto não esta pronta.");
            return null;
        }
        Objeto objo = obj;//Cópia do objeto parâmetro
        Objeto saida = new Objeto();//objeto de saida
        Objeto auxsaida = new Objeto();//auxiliar que prepara o objeto transformado para ser adicionado na lista saida de objeto
        Objeto aux2saida = new Objeto();//auxiliar que percorre a lista de objetos de saida para que o novo objeto tratado em auxsaida seja adicionado ao final da lista
        Face aux = new Face();
        Face f = new Face();
        Aresta A1 = new Aresta();
        Aresta A2 = new Aresta();
        Aresta are = new Aresta();
        Ponto P1 = new Ponto();
        Ponto P2 = new Ponto();
        //Copiei então a lista de objetos para o objo, criei as variaveis Face f e Aresta are para suporte nos calculos. 
        for(int n=0;n<objo.getFaces().size();n++) {
            f = objo.getFaces().get(n);
            //while (f != null) {
            for(int j=0;j<f.size();j++) {    
                double[][] pt = new double[4][f.size()]; //double[4][f.getLen()];
                are = f.getArestas().get(j);//f.getArestas();
                //Aqui eu adiciono o ponto inicial da primeira aresta, que precisa entrar como primeiro ponto da matriz
                pt[0][0] = are.getV1().getX();//are.getIni().getX();
                pt[1][0] = are.getV1().getY();//are.getIni().getY();
                pt[2][0] = are.getV1().getZ();//are.getIni().getZ();
                pt[3][0] = 1;
                //for (int i = 1; i < f.getLen(); i++) {
                for (int i = 1; i < f.size(); i++) {
                    if (are == null) {
                        System.out.println("Erro AlvyRay02: Aresta não encontrada");
                        return null;
                    }
                    pt[0][i] = are.getV2().getX(); //are.getFim().getX();
                    pt[1][i] = are.getV2().getY();//are.getFim().getY();
                    pt[2][i] = are.getV2().getZ();//are.getFim().getZ();
                    pt[3][i] = 1;
                    are = f.getArestas().get(i);//are.getProx();
                }
                //Agora temos a matriz pt com todos os pontos da face, fazemos então o produto com a matriz
                pt = mtoXpontos(pt, f.size());//mtoXpontos(pt, f.getLen());
                //Pontos transformados, agora vamos montar novamente a face e adicioná-la ao objeto de saída
                //É necessario criar a primeira aresta, para servir de base para as outras
                aux = new Face();
                P1 = new Ponto(pt[0][0], pt[1][0], pt[2][0]);
                P2 = new Ponto(pt[0][1], pt[1][1], pt[2][1]);
                A1 = new Aresta(P1, P2);
                aux.add(A1);//addAresta(A1);
                A2 = A1;
                //for (int i = 2; i < f.getLen(); i++) {
                for (int i = 2; i < f.size(); i++) {
                    P2 = new Ponto(pt[0][i], pt[1][i], pt[2][i]);
                    A1 = new Aresta(A2.getV2(), P2);//Aresta(A2.getFim(), P2, null);
                    aux.add(A1);//aux.addAresta(A1);
                    A2 = A1;
                }
                //Adiciona a última face
                A1 = new Aresta(A2.getV2(), P1);//Aresta(A2.getFim(), P1, null);
                aux.add(A1);//aux.addAresta(A1);
                //Teoricamente aqui a Face ja pronta, com o boolean pronto verdadeiro, transformada, pronta para ser adicionada ao novo objeto
                auxsaida.addface(aux);
                f =objo.getFaces().get(j);// f.getProximo();
            }
            if (saida.getFaces() == null) {
                saida = auxsaida;
            } 
            /*else {
                aux2saida = saida;
                while (aux2saida.getProximo() != null) {
                    aux2saida = aux2saida.getProximo();
                }
                aux2saida.setProximo(auxsaida);
            }
            //teoricamente aqui esta pronto um novo objeto, a instancia passa para o proximo objeto de mundo para conversão
            objo = objo.getProximo();*/
        }
        return saida;

    }

    private double[][] mtoXpontos(double[][] pontos, int zise) {
        double[][] res = new double[4][zise];
        double soma = 0;
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < zise; coluna++) {
                for (int k = 0; k < 4; k++) {
                    soma += mto[linha][k] * pontos[k][coluna];
                }
                res[linha][coluna] = soma;
                soma = 0;
            }
        }
        return res;
    }

    public void geraMto() {
        double[][] v = mundoTela();
        double[][] o = ortogonal();
        double[][] s = dispositivo();
        mto = mulMatriz(o, v);
        mto = mulMatriz(s, mto);
    }
    //Esse metodo loco multiplica uma matriz 4x4 por uma matriz 4xsize

    private double[][] MulM(double[][] v, double[][] pontos, int size) {
        double[][] res = new double[4][size];
        double soma = 0;
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < size; coluna++) {
                for (int k = 0; k < 4; k++) {
                    soma += v[linha][k] * pontos[k][coluna];
                }
                res[linha][coluna] = soma;
                soma = 0;
            }
        }
        return res;
    }

    private double[][] mundoTela() {

        //vetor N = p - VRP
        double NX = this.getP().getX() - this.getVRP().getX();
        double NY = this.getP().getY() - this.getVRP().getY();
        double NZ = this.getP().getZ() - this.getVRP().getZ();

        double normalN = (double)Math.sqrt(Math.pow(NX, 2) + Math.pow(NY, 2) + Math.pow(NZ, 2));

        /* 
        matriz R
        |ux uy uz 0|	vetor U = N X V
        |vx vy vz 0|	vetor V/|V|
        |nx ny nz 0|	vetor N/|N|		
        |0  0  0  1| 
         */
        double[][] R = new double[4][4];
        R[3][0] = 0;
        R[3][1] = 0;
        R[3][2] = 0;
        R[3][3] = 1;
        if (normalN != 0) {
            R[2][0] = NX / normalN;
            R[2][1] = NY / normalN;
            R[2][2] = NZ / normalN;
        } else {
            R[2][0] = NX;
            R[2][1] = NY;
            R[2][2] = NZ;
            //TODO sao esses valores msm?
        }
        R[2][3] = 0;

        double VX = this.getViewUP().getX() - (this.getViewUP().getX() * R[2][0] + this.getViewUP().getY() * R[2][1] + this.getViewUP().getZ() * R[2][2]) * R[2][0];
        double VY = this.getViewUP().getY() - (this.getViewUP().getX() * R[2][0] + this.getViewUP().getY() * R[2][1] + this.getViewUP().getZ() * R[2][2]) * R[2][1];
        double VZ = this.getViewUP().getZ() - (this.getViewUP().getX() * R[2][0] + this.getViewUP().getY() * R[2][1] + this.getViewUP().getZ() * R[2][2]) * R[2][2];
        //|V|
        double normalV = (double)Math.sqrt(Math.pow(VX, 2) + Math.pow(VY, 2) + Math.pow(VZ, 2));

        if (normalV != 0) {
            R[1][0] = VX / normalV;
            R[1][1] = VY / normalV;
            R[1][2] = VZ / normalV;
        } else {
            R[1][0] = VX;
            R[1][1] = VY;
            R[1][2] = VZ;
            //TODO sao esses valores msm? [2]
        }
        R[1][3] = 0;
        R[0][0] = R[2][1] * R[1][2] - R[1][1] * R[2][2];
        R[0][1] = R[2][2] * R[1][0] - R[1][2] * R[2][0];
        R[0][2] = R[2][0] * R[1][1] - R[1][0] * R[2][1];
        R[0][3] = 0;

        /* matriz T
        |1  0  0  -VRPX|
        |0  1  0  -VRPY|
        |0  0  1  -VRPZ|
        |0  0  0  1    | 
         */
        double[][] T = new double[4][4];
        T[0][0] = 1;
        T[0][1] = 0;
        T[0][2] = 0;
        T[0][3] = -this.getVRP().getX();
        T[1][0] = 0;
        T[1][1] = 1;
        T[1][2] = 0;
        T[1][3] = -this.getVRP().getY();
        T[2][0] = 0;
        T[2][1] = 0;
        T[2][2] = 1;
        T[2][3] = -this.getVRP().getZ();
        T[3][0] = 0;
        T[3][1] = 0;
        T[3][2] = 0;
        T[3][3] = 1;

        double[][] V = new double[4][4];
        V = mulMatriz(R, T);

        return V;
    }

    public double[][] recorte() {
        double[][] MD = new double[4][4];
        MD[0][0] = 1;
        MD[0][1] = 0;
        MD[0][2] = -cu / distancia;
        MD[0][3] = 0;
        MD[1][0] = 0;
        MD[1][1] = 1;
        MD[1][2] = -cv / distancia;
        MD[1][3] = 0;
        MD[2][0] = 0;
        MD[2][1] = 0;
        MD[2][2] = 1;
        MD[2][3] = 0;
        MD[3][0] = 0;
        MD[3][1] = 0;
        MD[3][2] = 0;
        MD[3][3] = 1;

        double[][] E = new double[4][4];
        E[0][0] = distancia / (su * far);
        E[0][1] = 0;
        E[0][2] = 0;
        E[0][3] = 0;
        E[1][0] = 0;
        E[1][1] = distancia / (sv * far);
        E[1][2] = 0;
        E[1][3] = 0;
        E[2][0] = 0;
        E[2][1] = 0;
        E[2][2] = 1 / far;
        E[2][3] = 0;
        E[3][0] = 0;
        E[3][1] = 0;
        E[3][2] = 0;
        E[3][3] = 1;

        double[][] C = mulMatriz(E, MD);
        return C;
    }

    public double[][] perspectiva() {

        double[][] F = new double[4][4];
        F[0][0] = 1;
        F[0][1] = 0;
        F[0][2] = 0;
        F[0][3] = 0;
        F[1][0] = 0;
        F[1][1] = 1;
        F[1][2] = 0;
        F[1][3] = 0;
        F[2][0] = 0;
        F[2][1] = 0;
        F[2][2] = 1;
        F[2][3] = -zmin;
        F[3][0] = 0;
        F[3][1] = 0;
        F[3][2] = 0;
        F[3][3] = 1;

        double[][] G = new double[4][4];
        G[0][0] = 1;
        G[0][1] = 0;
        G[0][2] = 0;
        G[0][3] = 0;
        G[1][0] = 0;
        G[1][1] = 1;
        G[1][2] = 0;
        G[1][3] = 0;
        G[2][0] = 0;
        G[2][1] = 0;
        G[2][2] = 1 / (1 - zmin);
        G[2][3] = 0;
        G[3][0] = 0;
        G[3][1] = 0;
        G[3][2] = 0;
        G[3][3] = 1;

        double[][] H = new double[4][4];
        H[0][0] = 1;
        H[0][1] = 0;
        H[0][2] = 0;
        H[0][3] = 0;
        H[1][0] = 0;
        H[1][1] = 1;
        H[1][2] = 0;
        H[1][3] = 0;
        H[2][0] = 0;
        H[2][1] = 0;
        H[2][2] = 1;
        H[2][3] = 0;
        H[3][0] = 0;
        H[3][1] = 0;
        H[3][2] = (1 - zmin) / zmin;
        H[3][3] = 1;

        double[][] I = mulMatriz(G, F);
        I = mulMatriz(H, I); //I

        double[][] J = new double[4][4];
        J[0][0] = 1 / zmin * I[0][0];
        J[0][1] = 1 / zmin * I[0][1];
        J[0][2] = 1 / zmin * I[0][2];
        J[0][3] = 1 / zmin * I[0][3];
        J[1][0] = 1 / zmin * I[1][0];
        J[1][1] = 1 / zmin * I[1][1];
        J[1][2] = 1 / zmin * I[1][2];
        J[1][3] = 1 / zmin * I[1][3];
        J[2][0] = 1 / zmin * I[2][0];
        J[2][1] = 1 / zmin * I[2][1];
        J[2][2] = 1 / zmin * I[2][2];
        J[2][3] = 1 / zmin * I[2][3];
        J[3][0] = I[3][0];
        J[3][1] = I[3][1];
        J[3][2] = I[3][2];
        J[3][3] = I[3][3];

        double[][] mP = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mP[i][j] = J[i][j] * zmin;	//J
            }
        }
        return mP;
    }

    public double[][] ortogonal() {

        double[][] Fo = new double[4][4];
        Fo[0][0] = 1;
        Fo[0][1] = 0;
        Fo[0][2] = 0;
        Fo[0][3] = 0;
        Fo[1][0] = 0;
        Fo[1][1] = 1;
        Fo[1][2] = 0;
        Fo[1][3] = 0;
        Fo[2][0] = 0;
        Fo[2][1] = 0;
        Fo[2][2] = 1;
        Fo[2][3] = -near;
        Fo[3][0] = 0;
        Fo[3][1] = 0;
        Fo[3][2] = 0;
        Fo[3][3] = 1;

        double[][] Go = new double[4][4];
        Go[0][0] = 1 / su;
        Go[0][1] = 0;
        Go[0][2] = 0;
        Go[0][3] = 0;
        Go[1][0] = 0;
        Go[1][1] = 1 / sv;
        Go[1][2] = 0;
        Go[1][3] = 0;
        Go[2][0] = 0;
        Go[2][1] = 0;
        Go[2][2] = 1 / (far - near);
        Go[2][3] = 0;
        Go[3][0] = 0;
        Go[3][1] = 0;
        Go[3][2] = 0;
        Go[3][3] = 1;

        double[][] O = mulMatriz(Go, Fo);
        return O;
    }

    public double[][] dispositivo() {
        double[][] K = new double[4][4];
        K[0][0] = (double)0.5;
        K[0][1] = 0;
        K[0][2] = 0;
        K[0][3] = (double)0.5;
        K[1][0] = 0;
        K[1][1] = (double)0.5;
        K[1][2] = 0;
        K[1][3] = (double)0.5;
        K[2][0] = 0;
        K[2][1] = 0;
        K[2][2] = 1;
        K[2][3] = 0;
        K[3][0] = 0;
        K[3][1] = 0;
        K[3][2] = 0;
        K[3][3] = 1;

        double[][] L = new double[4][4];
        L[0][0] = D.getX();
        L[0][1] = 0;
        L[0][2] = 0;
        L[0][3] = minX;
        L[1][0] = 0;
        L[1][1] = D.getY();
        L[1][2] = 0;
        L[1][3] = minY;
        L[2][0] = 0;
        L[2][1] = 0;
        L[2][2] = D.getZ();
        L[2][3] = near;
        L[3][0] = 0;
        L[3][1] = 0;
        L[3][2] = 0;
        L[3][3] = 1;

        double[][] M = new double[4][4];
        M[0][0] = 1;
        M[0][1] = 0;
        M[0][2] = 0;
        M[0][3] = (double)0.5;
        M[1][0] = 0;
        M[1][1] = 1;
        M[1][2] = 0;
        M[1][3] = (double)0.5;
        M[2][0] = 0;
        M[2][1] = 0;
        M[2][2] = 1;
        M[2][3] = (double)0.5;
        M[3][0] = 0;
        M[3][1] = 0;
        M[3][2] = 0;
        M[3][3] = 1;

        double[][] S = mulMatriz(L, K);
        S = mulMatriz(M, S);
        return S;
    }
//@Este Método multiplica duas matrizes de tamanho 4x4

    private static double[][] mulMatriz(double[][] m1, double[][] m2) {
        double[][] res = new double[4][4];
        double soma = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    soma += m1[i][k] * m2[k][j];
                }
                res[i][j] = soma;
                soma = 0;
            }
        }
        return res;
    }

    public void printMat(double[][] m, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(m[i][j] + " |\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
