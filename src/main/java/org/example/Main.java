package org.example;

import org.example.model.Destination;
import org.example.model.GMan;
import org.example.service.GManService;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    static GMan gMan = null;
    static Destination destination = null;
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            GManService gManService = new GManService();
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] cmd = input.split(" ");
                switch (cmd[0]) {
                        case "SOURCE":
                            gManService.createGManWithSource(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), cmd[3]);
                            break;
                        case "DESTINATION":
                            gManService.setDestinationInGame(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                            break;
                        case "PRINT_POWER":
                            System.out.println("POWER " + gManService.getRemainingPower());
                            break;
                }
            }
            sc.close();
        } catch (Exception e) {
        }
    }
}