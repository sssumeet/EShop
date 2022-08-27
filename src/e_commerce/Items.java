package e_commerce;

public class Items {

    String n;
    int q;
    int p;
    int uq;
    public Items(String n, int q, int p,int uQty) {
        super();
        this.n = n;
        this.q = q;
        this.p = p;
        this.uq = uQty;
    }
    @Override
    public String toString() {
        return "Items [Item Name=" + n + ", Quantity=" + q + ", Item Price=" + p + "]";
    }

}
