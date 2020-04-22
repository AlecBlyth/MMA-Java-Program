package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class BunnyCorpGame {

    private Scanner in = new Scanner(System.in);
    private static final String fileName = "src\\Workshop\\sample.txt";
    private Fighter[] myFighter = new Fighter[10];
    private Fighter tempFighter = null;
    private Fighter secondFighter = null;

    private int menuItem;

    private boolean quit = false;
    private boolean found = false;


    BunnyCorpGame() throws IOException {

        Fighter f1 = new Fighter(1000, "Alec", "Blyth", "United Kingdom", "Kirkcaldy", "Kickboxing",
                23, 60, 168, 95, 80, 75, 87, 70);
        Fighter f2 = new Fighter(1001, "Scott", "Fergerson", "United Kingdom", "Dunfermline", "Submission",
                19, 60, 168, 75, 70, 75, 90, 90);


        myFighter[0] = f1;
        myFighter[1] = f2;
        startGame();
    }

    private int nextFighterID = 1002;
    private String newline = System.getProperty("line.separator");

    private boolean gameMaths(double probabilityOfSuccess) { //Calculates a random chance for fights based on input value.
        return new Random().nextDouble() <= probabilityOfSuccess;
    }

    private void startGame() throws IOException {

        do {
            System.out.println("|==========================================================|");
            System.out.println("|                   BunnyCorp MMA Game                     |");
            System.out.println("|==========================================================|");
            System.out.println("|     1. Add Fighters                                      |");
            System.out.println("|     2. View Fighters                                     |");
            System.out.println("|     3. Play Game                                         |");
            System.out.println("|     0. Exit Game                                         |");
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
                                int fightStrength = 35;
                                int fightSpeed = 35;
                                int fightEndurance = 35;
                                int fightSubDef = 35;
                                int fightSubOff = 35;
                                Fighter f = new Fighter(nextFighterID++, firName, secName, Nation, fightOut, fightStyle, fightAge, fightWeight, fightHeight, fightStrength, fightSpeed, fightEndurance, fightSubDef, fightSubOff);
                                myFighter[i] = f;
                                writer.newLine();
                                break;
                            }
                        }
                        boolean success = false;
                        if (!success) {
                            System.out.println("Fighter Created");
                            writer.close();
                        }
                        break;

                    } catch (IOException e) {
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
                    fightMenu();
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
                    if (tempFighter.getSubmissionOffence() == 100) {
                        System.out.print("Your fighter has maximum Submission Offence");
                    } else {
                        for (Fighter aMyFighter : myFighter) {
                            if (aMyFighter == null) {
                                tempFighter.setSubmissionOffence(subOff + 1);
                            }
                        }
                    }
                    break;
                case 5:
                    int subDef = tempFighter.getSubmissionDefence();
                    if (tempFighter.getSubmissionDefence() == 100) {
                        System.out.print("Your fighter has maximum Submission Offence");
                    } else {
                        for (Fighter aMyFighter : myFighter) {
                            if (aMyFighter == null) {
                                tempFighter.setSubmissionDefence(subDef + 1);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Fighter:   " + tempFighter.getName());
                    System.out.println("Strength:  " + tempFighter.getStrength());
                    System.out.println("Speed:     " + tempFighter.getSpeed());
                    System.out.println("Endurance: " + tempFighter.getEndurance());
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

    private void fightMenu() throws IOException {

        int x = 0;

        if (tempFighter == null) {
            System.out.println("Select a fighter!");
            gameMenu();
        }

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
                    if (fighterID == tempFighter.getID()) {
                        System.out.println("You cannot select the same fighter!");
                        fightMenu();
                    } else {
                        secondFighter = aMyFighter;
                        fightMethod();
                    }
                }
            }
        }
        if (!found) {
            System.out.println("This fighter does not exist!");
            x = 0; //fixed issue where counter continued to increment
        }

    }

    private void fightMethod() throws IOException {

        int wins_1 = tempFighter.getWins();
        int wins_2 = secondFighter.getWins();

        int losses_1 = tempFighter.getLose();
        int losses_2 = secondFighter.getLose();

        int str_1 = tempFighter.getStrength();
        int str_2 = secondFighter.getStrength();

        int end_1 = tempFighter.getEndurance();
        int end_2 = secondFighter.getEndurance();

        int sub_O1 = tempFighter.getSubmissionOffence();
        int sub_O2 = secondFighter.getSubmissionOffence();

        int sub_Def1 = tempFighter.getSubmissionDefence();
        int sub_Def2 = secondFighter.getSubmissionDefence();

        int hp_1 = 100 + end_1;
        int hp_2 = 100 + end_2;

        int ap_1 = str_1 + 100 / 10;
        int ap_2 = str_2 + 100 / 10;

        boolean fightOver = false;
        int fightCount = 5;


        while (fightCount != 0 && hp_1 > 0 && hp_2 > 0 && !fightOver) {

            if (gameMaths(0.10)) {
                if (sub_O1 > sub_Def2) {
                    if (gameMaths(0.25)) {
                        System.out.println(tempFighter.getName() + " takes down " + secondFighter.getName());
                        hp_2 = hp_2 - sub_O1;
                    }
                } else {
                    if (gameMaths(0.10)) {
                        System.out.println(tempFighter.getName() + " takes down " + secondFighter.getName());
                        hp_2 = hp_2 - sub_O1;
                    }
                }
                if (hp_2 <= 0) {
                    System.out.println(secondFighter.getName() + " taps out!");
                    tempFighter.setWinRate(wins_1 + 1);
                    secondFighter.setLoseRate(losses_2 + 2);
                    fightOver = true;
                    gameMenu();
                }
            } else if (!gameMaths(0.10)) {
                if (sub_O2 > sub_Def1) {
                    if (gameMaths(0.25)) {
                        System.out.println(tempFighter.getName() + " takes down " + secondFighter.getName());
                        hp_1 -= sub_O2;
                    }
                } else {
                    if (gameMaths(0.10)) {
                        System.out.println(tempFighter.getName() + " takes down " + secondFighter.getName());
                        hp_1 -= sub_O2;
                    }
                }
                if (hp_1 <= 0) {
                    System.out.println(secondFighter.getName() + " taps out!");
                    tempFighter.setWinRate(losses_1 + 1);
                    secondFighter.setLoseRate(wins_2 + 2);
                    fightOver = true;
                    gameMenu();
                }
            }

            while (!(!gameMaths(0.25) || fightOver)) {
                System.out.println(tempFighter.getName() + " hits " + secondFighter.getName());
                hp_2 -= ap_1;
                System.out.println(hp_2);

                if (hp_2 <= 0 && !fightOver) {
                    System.out.println(tempFighter.getName() + " KO/TKOs " + secondFighter.getName());
                    tempFighter.setWinRate(wins_1 + 1);
                    secondFighter.setLoseRate(losses_2 + 1);
                    fightOver = true;
                    gameMenu();
                } else if (hp_1 <= 0 && !fightOver) {
                    System.out.println(secondFighter.getName() + " KO/TKOs " + tempFighter.getName());
                    secondFighter.setWinRate(wins_2 + 1);
                    tempFighter.setLoseRate(losses_1 + 1);
                    fightOver = true;
                    gameMenu();
                }
            }
            if (!gameMaths(0.25)) {
                if (gameMaths(0.25)) {
                    System.out.println(secondFighter.getName() + " hits " + tempFighter.getName());
                    hp_1 -= ap_2;
                    System.out.println(hp_1);
                    if (hp_2 <= 0 && !fightOver) {
                        System.out.println(tempFighter.getName() + " KO/TKOs " + secondFighter.getName());
                        tempFighter.setWinRate(wins_1 + 1);
                        secondFighter.setLoseRate(losses_2 + 1);
                        fightOver = true;
                        gameMenu();
                    } else if (hp_1 <= 0 && !fightOver) {
                        System.out.println(secondFighter.getName() + " KO/TKOs " + tempFighter.getName());
                        secondFighter.setWinRate(wins_2 + 1);
                        tempFighter.setLoseRate(losses_1 + 1);
                        fightOver = true;
                        gameMenu();
                    }
                } else {
                    System.out.println("Both fighters missed");
                }
            }
            fightCount--;

            if (fightCount == 0 && !fightOver) {
                if ((hp_2 - end_2) < (hp_1 - end_1)) {
                    System.out.println(tempFighter.getName() + " wins by decision! ");
                    tempFighter.setWinRate(wins_1 + 1);
                    secondFighter.setLoseRate(losses_2 + 1);
                    fightOver = true;
                    gameMenu();
                } else if ((hp_1 - end_1) < (hp_2 - end_2)) {
                    System.out.println(secondFighter.getName() + " wins by decision! ");
                    secondFighter.setWinRate(wins_2 + 1);
                    tempFighter.setLoseRate(losses_1 + 1);
                    fightOver = true;
                    gameMenu();
                } else if (hp_1 - end_1 == hp_2 - end_2) {
                    System.out.println("No Contest");
                    fightOver = true;
                    gameMenu();
                }
            }
        }
    }
}
