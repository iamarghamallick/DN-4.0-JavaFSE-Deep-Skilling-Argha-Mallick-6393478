package factories;

import documents.PdfDocument;
import documents.Document;

public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
