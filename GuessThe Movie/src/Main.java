import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        MovieSorter a = new MovieSorter();
        Guesser b;

        a.countLines();
        a.randomMovie();
        //System.out.println(a.getMovie());

        System.out.println("Voce tem doze tentativas para revelar todas as letras do filme!");

        b = new Guesser();
        System.out.println(b.getHidedMovie());

        int i;
        for( i = 12;i > 0;i--) {
            System.out.println("Voce tem "+i+" tentativas!");
            System.out.println("Digite uma letra");
            b.revealMovie(scanner.next().charAt(0));
            System.out.println("Deseja tentar adivinhar? s/n");
            b.tryToGuess(scanner.nextLine());

            if(scanner.nextLine().charAt(0) == 's') {
                System.out.println("Faça sua tentativa");
                if (b.tryToGuess(scanner.nextLine())) {
                    System.out.println("Parabéns, você adivinhou! O nome do filme é " + a.getMovie());
                    break;
                }
            }

            if(b.getHidedMovie().equals(a.getMovie())) {
                System.out.println("Parabéns você adivinhou todas as letras!");
                break;
            }
        }

        if(i == 0){
            System.out.println("Voce não adivinhou todas as letras =S\nmais sorte da proxima vez!");
            System.out.println("O filme era "+a.getMovie());
        }
    }
}
