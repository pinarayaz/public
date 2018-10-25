package ch.epfl.sweng.exercises.exercise8_solutions;

public class Main {
    public static void main(String[] args) {
        DocumentPart plainText = new PlainText("some word");
        DocumentPart boldText = new BoldText("this part is bolded!");
        DocumentPart url = new HyperLink("this is a link", "http://google.com");

        Document document = new Document();
        document.add(plainText);
        document.add(boldText);
        document.add(url);

        LatexVisitor latexVisitor = new LatexVisitor();
        document.accept(latexVisitor);
        System.out.println(latexVisitor.getOutput());

        HTMLVisitor htmlVisitor = new HTMLVisitor();
        document.accept(htmlVisitor);
        System.out.println(htmlVisitor.getOutput());

        PlainTextVisitor plainTextVisitor = new PlainTextVisitor();
        document.accept(plainTextVisitor);
        System.out.println(plainTextVisitor.getOutput());
    }
}
