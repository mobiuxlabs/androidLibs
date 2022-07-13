package in.mobiux.android.reader.model;

public class RFIDTag {

    private String epc;

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    @Override
    public String toString() {
        return "" + epc.replaceAll(" ", "");
    }
}
