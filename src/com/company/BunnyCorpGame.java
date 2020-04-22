package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BunnyCorpGame {

    Scanner in = new Scanner(System.in);
    private static final String fileName = "src\\Workshop\\sample.txt";
    Fighter[] myFighter = new Fighter[10];
    Fighter tempFighter = null;

    int menuItem;

    boolean quit = false;
    boolean success = false;
    boolean found = false;


    public BunnyCorpGame() throws IOException {

        Fighter f1 = new Fighter(1000, "Alec", "Blyth", "United Kingdom", "Fife", "Kickboxing",
                23, 60, 168, 95, 80, 75, 87, 70);
        Fighter f2 = new Fighter(1001, "Scott", "Fergerson", "United Kingdom", "Fife", "Submission",
                19, 60, 168, 75, 70, 75, 90, 90);


        myFighter[0] = f1;
        myFighter[1] = f2;
        startGame();
    }

    private int nextFighterID = 1002;
    int fightStrength = 35;
    int fightSpeed = 35;
    int fightEndurance = 35;
    int fightSubDef = 35;
    int fightSubOff = 35;

    String newline = System.getProperty("line.separator");
    
     private boolean gameMaths(double probabilityOfSuccess){ //Calcuates a random chance for fights based on input value.
        return Math.random() > probabilityOfSuccess;
    }

    private void startGame() throws IOException{

        do {
            System.out.println("|==========================================================|");
            System.out.println("|                                                       BunnyCorp MMA Game                                                   |");
            System.out.println("|==========================================================|");
            System.out.println("|     1. Add Fighters                                                                                                                   |");
            System.out.println("|     2. View Fighters                                                                                                                  |");
            System.out.println("|     3. Play Game                                                                                                                       |");
            System.out.println("|     0. Exit Game                                                                                                                        |");
            System.out.println("|==========================================================|");

            menuItem = in.nextInt();

            switch (menuItem) {

                case 1:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {

                        writer.write("1000|Alec|Blyth|United Kingdom|Kirkcaldy|Kickboxing|23|60|168|95|80|75|87|70|");
                        writer.write("1001|Scott|Fergerson|United Kingdom|Dunfermline|Submission|19|60|168|75|70|75|90|90|");

                        for (int i = 0; i < myFighter.length; i++) {
                            if (myFighter[i] == null) {
                                String FightID = Integer.toString(nextFighterID);
                                writer.write(FightID + "|");
                                System.out.println("Create a Fighter: Fighter " + i);
                                System.out.println("Select a fight style: ");
                                String fightStyle = in.next();
                                writer.write(fightStyle + "|");
                                System.out.println("Enter Fighter First Name:");
                                String firName = in.next();
                                writer.write(firName + "|");
                                System.out.println("Enter Fighter Second Name:");
                                String secName = in.next();
                                writer.write(secName + "|");
                                System.out.println("Enter Fighter Nationality:");
                                String Nation = in.next();
                                writer.write(Nation + "|");
                                System.out.println("Where is " + firName + " " + secName + " Fighting out of?: ");
                                String fightOut = in.next();
                                writer.write(fightOut + "|");
                                System.out.println("Enter their age: ");
                                int fightAge = in.nextInt();
                                writer.write(fightAge + "|");
                                System.out.println("Enter their weight: ");
                                int fightWeight = in.nextInt();
                                writer.write(fightWeight + "|");
                                System.out.println("Enter their height: ");
                                int fightHeight = in.nextInt();
                                writer.write(fightHeight + "|");
                                Fighter f = new Fighter(nextFighterID++, firName, secName, Nation, fightOut, fightStyle, fightAge, fightWeight, fightHeight, fightStrength, fightSpeed, fightEndurance, fightSubDef, fightSubOff);
                                myFighter[i] = f;
                                writer.newLine();
                                break;
                            }
                        }
                        if (!success) {
                            System.out.println("Fighter Created");
                            writer.close();
                        }
                        break;

                    } catch (IOException e){
                        System.out.println(e);
                    }
                case 2:
                    for (Fighter aMyFighter : myFighter) {
                        if (aMyFighter == null)
                            break;
                        System.out.println
                                ("|========================= Fighter ========================|" + newline +
                                        "Fighter Name: " + aMyFighter.getName() + newline +
                                        "From: " + aMyFighter.getNation() + newline +
                                        "Fighting out of " + aMyFighter.getFightingOut() + newline +
                                        "Fight Style: " + aMyFighter.getStyle() + newline +
                                        "Age: " + aMyFighter.getAge() + newline +
                                        "Weight: " + aMyFighter.getWeight() + newline +
                                        "Height: " + aMyFighter.getHeight() + newline +
                                        "Strength: " + aMyFighter.getStrength() + newline +
                                        "Speed: " + aMyFighter.getSpeed() + newline +
                                        "Endurance: " + aMyFighter.getEndurance() + newline +
                                        "Submission Defence: " + aMyFighter.getSubmissionDefence() + newline +
                                        "Submission Offence: " + aMyFighter.getSubmissionOffence() + newline +
                                        "Fighter ID: " + aMyFighter.getID());
                    }
                    break;
                case 3:
                    gameMenu();
                case 0:
                    quit = true;
            }
        }
        while (!quit);
    }

    private void gameMenu() throws IOException {
        int x = 0;
        do {
            System.out.println("|==========================================================|");
            System.out.println("|                    BunnyCorp MMA Game                    |");
            System.out.println("|==========================================================|");
            System.out.println("|     1. Pick Fighter                                      |");
            System.out.println("|     2. Train Fighter                                     |");
            System.out.println("|     3. Fight                                             |");
            System.out.println("|     4. Main Menu                                         |");
            System.out.println("|==========================================================|");
            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    System.out.println("        Pick your fighter        " + newline);
                    for (Fighter aMyFighter : myFighter) {
                        if (aMyFighter == null)
                            break;
                        x++;
                        System.out.println(x + " :" + aMyFighter.getName() + newline + " | Strength: " + aMyFighter.getStrength() + " | Speed: " + aMyFighter.getSpeed() + " | Endurance: " + aMyFighter.getEndurance() + " | Fighter ID: " + aMyFighter.getID() + newline);
                    }
                    int fighterID = in.nextInt();
                    for (Fighter aMyFighter : myFighter) {
                        if (aMyFighter != null) {
                            if (aMyFighter.getID() == fighterID) {
                                tempFighter = aMyFighter;
                                found = true;

                                System.out.println("You've Selected: " + aMyFighter.getName());

                                break;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("This fighter does not exist!");
                        x = 0; //fixed issue where counter continued to increment 
                    }
                    break;

                case 2:
                    if (!found) {
                        System.out.println("Pick a fighter");
                        break;
                    } else {
                        TrainFighter();
                        break;
                    }
                case 3:
                    System.out.println("Test Game");
                    break;
                case 4:
                    startGame();
                case 99: //EndGame for Developers
                    quit = true;
            }
        } while (!quit);
    }

private void TrainFighter() throws IOException {
        do {
            System.out.println("|==========================================================|");
            System.out.println("|                    BunnyCorp MMA Game                    |");
            System.out.println("|==========================================================|");
            System.out.println("         Fighter: " + tempFighter.getName());
            System.out.println("|     1. Strength                                          |");
            System.out.println("|     2. Speed                                             |");
            System.out.println("|     3. Endurance                                         |");
            System.out.println("|     4. Submission Offence                                |");
            System.out.println("|     5. Submission Defence                                |");
            System.out.println("|     6. View Fighter Stats                                |");
            System.out.println("|     7. Finish Training                                   |");
            System.out.println("|==========================================================|");
            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    int strength = tempFighter.getStrength();
                            if (tempFighter.getStrength() == 100) {
                                System.out.println("Your fighter has maximum Strength");
                            } else {
                                for (Fighter aMyFighter : myFighter) {
                                    if (aMyFighter == null) {
                                        tempFighter.setStrength(strength + 1);
                                        break;
                                    }
                                }
                    }
                    break;
                case 2:
                    int speed = tempFighter.getSpeed();
                    if (tempFighter.getSpeed() == 100) {
                        System.out.println("Your fighter has maximum Speed");
                    } else {
                        for (Fighter aMyFighter : myFighter) {
                            if (aMyFighter == null) {
                                tempFighter.setSpeed(speed + 1);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    int endurance = tempFighter.getEndurance();
                    if (tempFighter.getEndurance() == 100) {
                        System.out.println("Your fighter has maximum Endurance");
                    } else {
                        for (Fighter aMyFighter : myFighter) {
                            if (aMyFighter == null) {
                                tempFighter.setEndurance(endurance + 1);
                                break;
                            }
                        }
                    }
                    break;

                case 4:
                    int subOff = tempFighter.getSubmissionOffence();
                    if(tempFighter.getSubmissionOffence() == 100){
                        System.out.print("Your fighter has maximum Submission Offence");
                    } else {
                        for (Fighter aMyFighter : myFighter){
                            if(aMyFighter == null){
                                tempFighter.setSubmissionOffence(subOff + 1);
                            }
                        }
                    }
                    break;
                case 5:
                    int subDef = tempFighter.getSubmissionDefence();
                    if(tempFighter.getSubmissionDefence() == 100){
                        System.out.print("Your fighter has maximum Submission Offence");
                    } else {
                        for (Fighter aMyFighter : myFighter){
                            if(aMyFighter == null){
                                tempFighter.setSubmissionDefence(subDef + 1);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Fighter:   "+ tempFighter.getName());
                    System.out.println("Strength:  "+ tempFighter.getStrength());
                    System.out.println("Speed:     "+ tempFighter.getSpeed());
                    System.out.println("Endurance: "+ tempFighter.getEndurance());
                    System.out.println("Submission Offence: " + tempFighter.getSubmissionOffence());
                    System.out.println("Submission Defence: " + tempFighter.getSubmissionDefence());
                    break;
                case 7:
                    gameMenu();
                    break;
                case 99: //EndGame for Developers
                    quit = true;
            }
        } while (!quit);
    }

   private void fightMenu() {

        int x = 0;
        
        System.out.println("        Pick your opponent        " + newline);
        for (Fighter aMyFighter : myFighter) {
            if (aMyFighter == null)
                break;
            x++;
            System.out.println(x + " :" + aMyFighter.getName() + newline + " | Strength: " + aMyFighter.getStrength() + " | Speed: " + aMyFighter.getSpeed() + " | Endurance: " + aMyFighter.getEndurance() + " | Fighter ID: " + aMyFighter.getID() + newline);
        }
        int fighterID = in.nextInt();
        for (Fighter aMyFighter : myFighter) {
            if (aMyFighter != null) {
                if (aMyFighter.getID() == fighterID) {
                    if(fighterID == tempFighter.getID()){
                        System.out.println("You cannot select the same fighter!");
                        fightMenu();
                    } else {
                        secondFighter = aMyFighter;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("This fighter does not exist!");
            x = 0; //fixed issue where counter continued to increment
        }
    }
}
