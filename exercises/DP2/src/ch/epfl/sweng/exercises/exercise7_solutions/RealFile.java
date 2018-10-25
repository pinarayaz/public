package ch.epfl.sweng.exercises.exercise7_solutions;

public class RealFile implements File {

    @Override
    public String read(String fileName) {
        System.out.println("You're currently reading file with filename: " + fileName);
        return "some file data";
    }

    @Override
    public void write(String fileName, String data) {
        System.out.println("You're currently writing file with filename: " + fileName + " and data: " + data);
    }
}
