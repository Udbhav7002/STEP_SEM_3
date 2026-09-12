public class P3_FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1).toLowerCase();

        if (extension.equals("pdf") || extension.equals("docx") || extension.equals("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
        System.out.println(validateFileExtension("document.docx"));
        System.out.println(validateFileExtension("archive.zip"));
        System.out.println(validateFileExtension("image.png"));
    }
}