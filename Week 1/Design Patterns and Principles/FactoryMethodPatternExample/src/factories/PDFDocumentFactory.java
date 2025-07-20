package factories;

import documents.Document;
import documents.PDFDocument;

public class PDFDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}
