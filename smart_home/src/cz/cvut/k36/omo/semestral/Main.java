package cz.cvut.k36.omo.semestral;

import cz.cvut.k36.omo.semestral.home.Home;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Smart Home configuration : 1 - small house , 2 - big house");
        int config = sc.nextInt();
        if (!(config == 1 || config == 2)){
            System.out.println("Invalid home configuration number");
            exit(1);
        }
        System.out.println("Write report file name: ");
        String filename = sc.next();

        Home home = Home.getInstance(config);
        Simulation simulation = new Simulation(365,home,filename);
        simulation.runSimulation();
        simulation.getReportAPI().addReportToFile();

    }
}
