package factories;

import documents.WordDocument;
import documents.Document;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
