package com.company;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException,EmptyFileException, TooManyAttemptsException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the path to the file that you would like to load:");
        String filename;
        int cnt=1;
        while (true) {
            filename = scan.nextLine();
            if (filename.endsWith(".txt")) {
                break;
            }
            if(cnt==3){
                throw new TooManyAttemptsException();
            }
            System.out.print("The file must end of .txt! Please enter a valid format:\n");
            cnt++;
        }

        File file = new File(filename);
        if(file.exists()==false){
            throw new FileNotFoundException("Error.File with this name/path does not exist.");
        }
        if(file.length()==0){
            throw new EmptyFileException();
        }
        ArrayList<String> lines = new ArrayList<>();
        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }

        menu(scan, lines, filename);

    }



    public static void menu(Scanner scan, ArrayList<String> lines, String filename) throws IOException, InputMismatchException {
        try {
            while (true) {
                System.out.println("\n               MENU                ");
                System.out.println("1.Print the text from the file;");
                System.out.println("2.Swap two lines(by index);");
                System.out.println("3.Swap two words(by index);");
                System.out.println("4.Exit.");
                System.out.println("\nChoose an option(1-4):");

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        Print.printLines(lines);
                        break;
                    case 2:
                        Swap.swapTwoLines(scan, lines, filename);
                        break;
                    case 3:
                        Swap.swapWords(scan, lines, filename);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("This option does not exist. Please enter one of the existing!");

                }
                File file = new File(filename);
                lines = new ArrayList<>();
                Scanner in = new Scanner(file);
                while (in.hasNextLine()) {
                    lines.add(in.nextLine());
                }
            }
        }catch (TooManyAttemptsException tooManyAttemptsException) {
            System.out.println(tooManyAttemptsException.getMessage());
        }catch (InputMismatchException inputMismatchException) {
            System.out.println("Error. Expected value must contain only numbers.");
        }
    }

}
