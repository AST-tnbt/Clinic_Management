package clinicmanagement.util;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class DocumentUtil {
    public DocumentUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getText(Document document) {
        try {
            return document.getText(0, document.getLength());
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeText(Document document) {
        try {
            document.remove(0, document.getLength());

        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }
}
