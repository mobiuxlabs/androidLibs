package in.mobiux.android.reader.model;

public class Barcode {

    private String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "" + barcode;
    }
}
