package Java.Oving5;

public class BrokRegne {
    private double teller, nevner;
    private double resTeller, resNever;
    private String resOutput, resTotal;

    public BrokRegne(double teller, double nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være 0");
        } else {
            this.teller = teller;
            this.nevner = nevner;
        }
    }

    public BrokRegne(double teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public void addere(BrokRegne a, BrokRegne b) {
        // resultat = (a.teller / a.nevner) + (b.teller / b.nevner);
        // resTeller = (a.teller * b.nevner + b.teller * a.nevner);
        // resNever = (a.nevner * b.nevner);

        if (a.nevner == b.nevner) {
            resTeller = a.teller + b.teller;
            resNever = a.nevner;
        } else {
            resTeller = (a.teller * b.nevner) + (b.teller * a.nevner);
            resNever = a.nevner * b.nevner;
        }

        String resTotal = resTeller + "/" + resNever;
        this.resTotal = resTotal;
        this.resOutput = "(" + a.teller + "/" + a.nevner + ") + (" + b.teller + "/" + b.nevner + ")";
    }

    public void subtrahere(BrokRegne a, BrokRegne b) {
        // resultat = (a.teller / a.nevner) - (b.teller / b.nevner);
        // resTeller = (a.teller * b.nevner - b.teller * a.nevner);
        // resNever = (a.nevner * b.nevner);
        if (a.nevner == b.nevner) {
            resTeller = a.teller - b.teller;
            resNever = a.nevner;
        } else {
            resTeller = (a.teller * b.nevner) - (b.teller * a.nevner);
            resNever = a.nevner * b.nevner;
        }
        String resTotal = resTeller + "/" + resNever;
        this.resTotal = resTotal;
        this.resOutput = "(" + a.teller + "/" + a.nevner + ") - (" + b.teller + "/" + b.nevner + ")";
    }

    public void multiplisere(BrokRegne a, BrokRegne b) {
        // resultat = (a.teller / a.nevner) * (b.teller / b.nevner);
        resTeller = (a.teller * b.teller);
        resNever = (a.nevner * b.nevner);

        if (resTeller == resNever) {
            resTeller = 1;
            resNever = 1;
        }

        String resTotal = resTeller + "/" + resNever;
        this.resTotal = resTotal;
        this.resOutput = "(" + a.teller + "/" + a.nevner + ") * (" + b.teller + "/" + b.nevner + ")";
    }

    public void dividere(BrokRegne a, BrokRegne b) {
        // resultat = (a.teller / a.nevner) / (b.teller / b.nevner);
        resTeller = (a.teller * b.nevner);
        resNever = (a.nevner * b.teller);
        if (resTeller == resNever) {
            resTeller = 1;
            resNever = 1;
        }
        String resTotal = resTeller + "/" + resNever;
        this.resTotal = resTotal;
        this.resOutput = "(" + a.teller + "/" + a.nevner + ") / (" + b.teller + "/" + b.nevner + ")";
    }

    public String getResultat() {
        String resultat = this.resOutput + " = " + this.resTotal;
        return resultat;
    }

    public static void main(String[] args) {
        // BrokRegne a = new BrokRegne(1, 0);
        // BrokRegne b = new BrokRegne(1, 3);

        BrokRegne a, b;

        try {
            a = new BrokRegne(9, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            a = new BrokRegne(1);
        }
        try {
            b = new BrokRegne(9, 4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            b = new BrokRegne(1);
        }

        a.addere(a, b);
        System.out.println(a.getResultat());
        a.subtrahere(a, b);
        System.out.println(a.getResultat());
        a.multiplisere(a, b);
        System.out.println(a.getResultat());
        a.dividere(a, b);
        System.out.println(a.getResultat());
    }
}
