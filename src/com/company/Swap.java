package com.company;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Swap {
    public static void swapTwoLines(Scanner scan, ArrayList<String> lines, String filename) throws IOException, TooManyAttemptsException {

        System.out.println("\nEnter the index of the first line you want to swap: ");
        int firstLineToSwap;
        int cnt=0;
        while(true){
            firstLineToSwap = scan.nextInt() - 1;
            if(firstLineToSwap>=0 && firstLineToSwap<lines.size()){
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            cnt++;
            System.out.print("You have not entered an index of existing line.Please, try again:\n");
        }
        System.out.println("Enter the index of the second line to swap:");
        int secondLineToSwap;
        while(true) {
            secondLineToSwap = scan.nextInt() - 1;
            if(secondLineToSwap>=0 && secondLineToSwap<lines.size()){
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            System.out.println("\nYou have not entered an index of existing line.Please, try again:");
        }
        System.out.println("\nText before swapping lines:");
        Print.printLines(lines);
        Collections.swap(lines, firstLineToSwap, secondLineToSwap);
        Save.saveTheUpdatedFile(filename, lines);
        System.out.println("\nText after swapping lines:");
        for (String temp : lines) {
            System.out.println(temp);
        }
    }


    public static void swapWords (Scanner scan, ArrayList < String > lines, String filename) throws IOException, TooManyAttemptsException {

        String[][] array2D = new String[lines.size()][];
        for (int i = 0; i < array2D.length; i++) {
            String str = lines.get(i);
            String[] row = str.split(" ");
            array2D[i] = row;
        }
        int firstWordLine,secondWordLine,firstWordPosition,secondWordPosition;
        System.out.println("\nEnter the index of the line where the first word you want to swap is:");
        int cnt=0;
        while(true) {
            firstWordLine = scan.nextInt()-1;
            if(firstWordLine>=0 && firstWordLine<lines.size()){
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            cnt++;
            System.out.println("\nThere is no an existing line with this index.Please, try again:");
        }
        System.out.println("Enter the position of the first word:");
        while(true) {
            firstWordPosition = scan.nextInt()-1;
            if(firstWordPosition>=0 && firstWordPosition<array2D[firstWordLine].length){
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            cnt++;
            System.out.println("\nThere is no an existing word there.Please, try again:");
        }
        System.out.println("Enter the index of the line where the second word you want to swap is:");
        while(true) {
            secondWordLine = scan.nextInt()-1;
            if(secondWordLine>=0 && secondWordLine<lines.size()){
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            cnt++;
            System.out.println("\nThere is no an existing line with this index.Please, try again:");
        }
        System.out.println("Enter the position of the second word:");
        while(true){
            secondWordPosition = scan.nextInt()-1;
            if (secondWordPosition >= 0 && secondWordPosition < array2D[secondWordLine].length) {
                break;
            }
            if (cnt == 3) {
                throw new TooManyAttemptsException();
            }
            cnt++;
            System.out.println("\nThere is no an existing word there.Please, try again:");
        }

        System.out.println("\nText before swapping words:");
        Print.print2dArray(array2D);

        String temp = array2D[firstWordLine][firstWordPosition];
        array2D[firstWordLine][firstWordPosition] = array2D[secondWordLine][secondWordPosition];
        array2D[secondWordLine][secondWordPosition] = temp;

        Save.saveTheUpdatedFile2DArray(filename, array2D);

        System.out.println("\nText after swapping words:");
        Print.print2dArray(array2D);


    }

}

