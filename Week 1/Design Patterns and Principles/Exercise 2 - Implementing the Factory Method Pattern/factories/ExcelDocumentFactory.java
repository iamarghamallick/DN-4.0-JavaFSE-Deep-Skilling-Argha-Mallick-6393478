package factories;

import documents.ExcelDocument;
import documents.Document;

public class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
