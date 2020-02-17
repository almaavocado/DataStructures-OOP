import java.util.Scanner;
public class BladesofGloryLAb {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double sum = 0.0;
        double highest = 0.0;
        double lowest = 0.0;
        //Setting counter variables
        for (int judge = 1; judge <= 9; judge++)
        {
            System.out.println("Please enter judge # " + judge + " score: ");
            double score = scan.nextDouble();
            while (score < 0 || score > 10){
                System.out.println("Please enter judge # " + judge + " score: ");
                score = scan.nextDouble();}
            sum += score;
            if (score > highest){
                highest = score;
            }
            if (score < lowest){
                lowest = score;
            }
        }
        sum -= lowest;
        sum -= highest;
        sum /= 7;
        System.out.println("The final score is: " + String.format("%.1f", sum ));
    }
}

    // Evgenia Medvedeva
    // Salchows: is an edge figure skating jump.
    // Axels: jump with a forward take off.
    // Lutzes:  toepick-assisted jump with an entrance from a back outside edge and landing on the back outside edge of the opposite foot.
    // Brian Boitano