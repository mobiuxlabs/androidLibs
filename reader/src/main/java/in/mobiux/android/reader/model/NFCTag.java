package in.mobiux.android.reader.model;

public class NFCTag {

    private String nfcTag;

    public String getNfcTag() {
        return nfcTag;
    }

    public void setNfcTag(String nfcTag) {
        this.nfcTag = nfcTag;
    }

    @Override
    public String toString() {
        return "" + nfcTag;
    }
}
