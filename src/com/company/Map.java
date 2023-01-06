package com.company;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int row = 0;
    int column = 0;
    int[][] fields = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    };

    public void showMap(){
        for (int[] field : fields) {
            System.out.println(Arrays.toString(field));

        }
    }

    public void spawn(){
        row = randomNumber(1, 8);
        column = randomNumber(1, 8);
        fields[row][column] = 1;
        showMap();
    }

    private int randomNumber(int min, int max){
        return rand.nextInt((max - min) + 1) + min;
    }
    private void playerOption() throws WringDirection {
        String playerChoice = scanner.nextLine();
    switch (playerChoice){
        case "LEFT" -> moveManager("LEFT");
        case "RIGHT" -> moveManager("RIGHT");
        case "UP" -> moveManager("UP");
        case "DOWN" -> moveManager("DOWN");
        default -> System.out.println("default");
    }

    }
    public void showOptions() throws WringDirection {
        System.out.println("Options: ");
        System.out.println(Parties.LEFT);
        System.out.println(Parties.RIGHT);
        System.out.println(Parties.UP);
        System.out.println(Parties.DOWN);
            playerOption();

        }


    private void moveManager(String dir) throws WringDirection {
        fields[row][column] = 2;
        if (dir.equals("UP")){
            row--;
        }
        if (dir.equals("DOWN")){
            row++;
        }if (dir.equals("LEFT")){
            column--;
        }if (dir.equals("RIGHT")){
            column++;
        }
        if (fields[row][column] == 2){
            throw new WringDirection();
        }
        fields[row][column] = 1;
        showMap();

    }
    public void loop() throws WringDirection {
        while(true){
            showOptions();
        }
    }
}
