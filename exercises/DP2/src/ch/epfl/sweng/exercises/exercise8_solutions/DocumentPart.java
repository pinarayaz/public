package ch.epfl.sweng.exercises.exercise8_solutions;

public abstract class DocumentPart {

    private String text;

    public DocumentPart(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public abstract void accept(Visitor visitor);

}
