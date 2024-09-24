package Java.Oving6_v2.Matriser;

public final class Matrise {
    private final double[][] m;

    Matrise(double[][] n) {
        m = n;
    }

    public Matrise fyllMatrise(double[][] n) {
        return new Matrise(n);
    }

    public double[][] getMatrise() {
        return m;
    }

    public Matrise addereMatriser(Matrise b) {
        try {
            int rader = getAntallRader();
            int kolonner = getAntallKolonner();
            double[][] n = new double[rader][kolonner];
            for (int i = 0; i < rader; i++) {
                for (int j = 0; j < kolonner; j++) {
                    n[i][j] = m[i][j] + b.getMatrise()[i][j];
                }
            }
            return new Matrise(n);
        } catch (Exception e) {
            System.out.println("Matrisene er ikke like store");
            return null;
        }
    }

    public Matrise multiplisereMatriser(Matrise b) {
        try {
            int mRader = getAntallRader();
            int mKolonner = getAntallKolonner();
            int bRader = b.getAntallRader();
            int bKolonner = b.getAntallKolonner();
            if (mKolonner == bRader) {
                double[][] n = new double[mRader][bKolonner];
                for (int i = 0; i < mRader; i++) {
                    for (int j = 0; j < bKolonner; j++) {
                        for (int k = 0; k < mKolonner; k++) {
                            n[i][j] += m[i][k] * b.getMatrise()[k][j];
                        }
                    }
                }
                return new Matrise(n);
            } else {
                System.out.println("Matrisene kan ikke multipliseres");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Matrisene kan ikke multipliseres");
            return null;
        }
    }

    public Matrise transponereMatrise() {
        try {
            int rader = getAntallRader();
            int kolonner = getAntallKolonner();
            double[][] n = new double[kolonner][rader];
            for (int i = 0; i < rader; i++) {
                for (int j = 0; j < kolonner; j++) {
                    n[j][i] = m[i][j];
                }
            }
            return new Matrise(n);
        } catch (Exception e) {
            System.out.println("Matrisen kan ikke transponeres");
            return null;
        }
    }

    public int getAntallRader() {
        int rader = m.length;
        return rader;
    }

    public int getAntallKolonner() {
        int kolonner = m[0].length;
        return kolonner;
    }
}
