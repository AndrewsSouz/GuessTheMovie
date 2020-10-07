import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieSorter {

    private static int lines = 0;
    private static String movie;

    File file = new File("movies.txt");
    Scanner scanner;

    {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println(e.getMessage());
        }
    }

    public void countLines() {
            while (scanner.hasNextLine()) {
                lines++;
                scanner.nextLine();
            }
    }

    public int getLines(){
        return lines;
    }

    public void randomMovie() throws FileNotFoundException {

        scanner = new Scanner(file);
        int line = 0;
        int randomLine = (int)(Math.random() * getLines() );

        while(line != randomLine){
            line++;
            scanner.nextLine();
        }

        movie = scanner.nextLine() ;
    }

    public String getMovie() {
        return movie;
    }

}

