package com.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Parser inputParser = new Parser();
        System.out.println(args.length);
        switch(args.length) {
            case 0:
                for(;;) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferedReader.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                            inputParser.parseInput(inputString.trim());
                        }
                    } catch (IOException e) {
                        System.out.println("Inputan anda tidak benar");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                inputParser.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
