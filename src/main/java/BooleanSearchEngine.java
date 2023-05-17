import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BooleanSearchEngine implements SearchEngine {
    private Map<String , List<PageEntry>> pageEntry = new HashMap<>();
    public BooleanSearchEngine(File pdfsDir) throws IOException {
        if(pdfsDir.exists() && pdfsDir.isDirectory()){
            File[] pdfs = pdfsDir.listFiles();
            if(pdfs != null) {
                for (File pdfFile : pdfs) {
                    var doc = new PdfDocument(new PdfReader(pdfFile));
                    for(int i = 0; i < doc.getNumberOfPages();i++){
                        PdfPage pdfPage = doc.getPage(i + 1);
                        String[] words = pdfPage.toString().split("\\p{L}+");

                        Map<String, Integer> freqs = new HashMap<>();
                        for (var word : words) {
                            if (word.isEmpty()) {
                                continue;
                            }
                            word = word.toLowerCase();
                            freqs.put(word, freqs.getOrDefault(word, 0) + 1);
                        }

                        for(String word : words){
                            word = word.toLowerCase();
                            PageEntry query = new PageEntry(pdfFile.getName(), i + 1, freqs.get(word));
                            List<PageEntry> pageEntries;
                            if(pageEntry.containsKey(word)){
                                pageEntries = pageEntry.get(word);
                            } else{
                                pageEntries = new ArrayList<>();
                            }
                            pageEntries.add(query);
                            pageEntry.put(word, pageEntries);
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<PageEntry> search(String word) {
        // тут реализуйте поиск по слову
        return Collections.emptyList();
    }
}
