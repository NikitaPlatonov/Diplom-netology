import com.google.gson.Gson;

public class PageEntry implements Comparable<PageEntry> {
    private final String pdfName;
    private final int page;
    private final int count;

    private static Gson gson = new Gson();

    public PageEntry(String pdfName, int page, int count){
        this.pdfName = pdfName;
        this.page = page;
        this.count = count;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
