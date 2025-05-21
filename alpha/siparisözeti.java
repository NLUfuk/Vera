public class Siparis {
    private String urunAdi;
    private int adet;
    private double fiyat;

    public Siparis(String urunAdi, int adet, double fiyat) {
        this.urunAdi = urunAdi;
        this.adet = adet;
        this.fiyat = fiyat;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public int getAdet() {
        return adet;
    }

    public double getFiyat() {
        return fiyat;
    }

    public double getToplamFiyat() {
        return adet * fiyat;
    }

    @Override
    public String toString() {
        return urunAdi + " x" + adet + " = " + getToplamFiyat() + " TL";
    }
}
