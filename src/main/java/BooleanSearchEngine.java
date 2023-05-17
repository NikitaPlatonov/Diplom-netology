import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BooleanSearchEngine implements SearchEngine {
    private StringBuilder text = new StringBuilder();
    private String[] words;

    public BooleanSearchEngine(File pdfsDir) throws IOException {
        File directory = new File("pdfs");
        if(directory.exists() && directory.isDirectory()){
            File[] pdfs = directory.listFiles();
            if(pdfs != null) {
                for (File pdfFile : pdfs) {
                    var doc = new PdfDocument(new PdfReader(pdfFile));
                    for(int i = 0; i < doc.getNumberOfPages();i++){
                        var textFromPage = PdfTextExtractor.getTextFromPage(doc.getPage(i + 1));
                        text.append(textFromPage);
                    }
                }
                words = text.toString().split("\\P{L}+");
            }
        }
        Map<String, Integer> freqs = new HashMap<>();
        for (var word : words) {
            if (word.isEmpty()) {
                continue;
            }
            word = word.toLowerCase();
            freqs.put(word, freqs.getOrDefault(word, 0) + 1);
        }
    }

    @Override
    public List<PageEntry> search(String word) {
        // тут реализуйте поиск по слову
        return Collections.emptyList();
    }
}
