public class Guesser extends MovieSorter {

    private String hidedMovie;

    public Guesser(){
        hidedMovie = super.getMovie().replaceAll("\\S", "-");
    }

    String getHidedMovie(){
        return hidedMovie;
    }

    void revealMovie(char s) {

        for(int i = 0;i<super.getMovie().length();i++){
            int verif = 0;

            for(int j = 0;j<super.getMovie().length();j++) {
                if (super.getMovie().indexOf(s) != -1) {
                    verif++;
                }
            }
            if(verif == 0){
                System.out.println("Não existe ocorrencia da letra --"+s+"-- nesse filme!");
                break;
            }

            if(super.getMovie().charAt(i) == s){
                char [] guess = hidedMovie.toCharArray();
                guess[i] = s;
                hidedMovie = String.valueOf(guess);
            }
        }
        System.out.println("\n"+getHidedMovie());
    }

    public Boolean tryToGuess(String guessTry){
        boolean b = false;
        if(guessTry.equals(super.getMovie())) {
            b = true;
        }
        return b;
    }

}

