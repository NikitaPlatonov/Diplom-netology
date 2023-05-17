import com.google.gson.Gson;

public class PageEntry implements Comparable<PageEntry> {
    private static final Gson gson = new Gson();
    private final String pdfName;
    private final int page;
    private final int count;

    public PageEntry(String pdfName, int page, int count) {
        this.pdfName = pdfName;
        this.page = page;
        this.count = count;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    @Override
    public int compareTo(PageEntry o) {
        return o.getCount() - this.getCount();
    }

    public int getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }

    public String getPdfName() {
        return pdfName;
    }
}
