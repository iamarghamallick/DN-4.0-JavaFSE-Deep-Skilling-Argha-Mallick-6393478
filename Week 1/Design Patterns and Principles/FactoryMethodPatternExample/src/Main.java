import documents.Document;
import factories.DocumentFactory;
import factories.ExcelDocumentFactory;
import factories.PDFDocumentFactory;
import factories.WordDocumentFactory;

public class Main {
    public static void main(String[] args) {

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();

        DocumentFactory pdfFactory = new PDFDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
    }
}