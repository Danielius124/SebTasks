package com.danielius;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        List<String> forChech = new ArrayList<String>(Arrays.asList("LT20",
                "AD24", "AE23", "AT20", "AZ28", "BA20", "BE16", "BG22", "BH22", "BR29",
                "CH21", "CR21", "CY28", "CZ24", "DE22", "DK18", "DO28", "EE20", "ES24",
                "FI18", "FO18", "FR27", "GB22", "GI23", "GL18", "GR27", "GT28", "HR21",
                "HU28", "IE22", "IL23", "IS26", "IT27", "JO30", "KW30", "KZ20", "LB28",
                "LI21", "LU20", "LV21", "MC27", "MD24", "ME22", "MK19", "MR27",
                "MT31", "MU30", "NL18", "NO15", "PK24", "PL28", "PS29", "PT25", "QA29",
                "RO24", "RS22", "SA24", "SE24", "SI19", "SK24", "SM27", "TN24", "TR26"));


        System.out.println("Sveiki! Pasirinkite!\n 1. Interaktyvus IBAN numerių tikrinimas. \n 2. IBAN numerių iš tekstinio failo tikrinimas.");
        Scanner keyboard = new Scanner(System.in);
        int choose = keyboard.nextInt();
        switch (choose){
            case 1:
                System.out.println("Įveskite sąskaitos IBAN numerį.");
                Scanner input = new Scanner(System.in);
                String iban = input.nextLine();
                String country = iban.substring(0, 2);
                int chechSum = Integer.parseInt(iban.substring(2,4));
                singleIbanCheck(forChech, iban, country, chechSum);
                break;
            case 2:
                System.out.println("Įveskite kelia iki failo bei failo pavadinima.");
                Scanner path = new Scanner(System.in);
                String pathToFile = path.nextLine();
                Scanner filena = new Scanner(System.in);
                String fileName = filena.nextLine();
                File file = new File(pathToFile + "//" +fileName + ".txt");
                Scanner sc = new Scanner(file);
                sc.useDelimiter("\\Z");
                List<String> listOfIbans = null;
                try(Stream<String> lines = Files.lines(Paths.get(pathToFile + "//" +fileName + ".txt"))) {
                   listOfIbans = lines.collect(Collectors.toList());
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean ats = false;

                for(int i = 0; i < listOfIbans.size(); i++){
                    int sumCheck = Integer.parseInt(listOfIbans.get(i).substring(2,4));
                    for(int j = 0; j < forChech.size(); j++){
                       if(listOfIbans.get(i).substring(0,2).equals(forChech.get(j).substring(0,2)) && sumCheck > 35
                       && listOfIbans.get(i).length() == Integer.parseInt(forChech.get(j).substring(2,4))) {
                           listOfIbans.set(i, listOfIbans.get(i) + ";" + "true");
                           ats = true;
                           break;
                       }else ats = false;
                    }
                    if(ats==false) listOfIbans.set(i, listOfIbans.get(i) + ";" + "false");
                }

                for(int i = 0; i < listOfIbans.size(); i++){
                    System.out.println(listOfIbans.get(i));
                }

                FileWriter writer = new FileWriter(fileName+".out.txt");
                for(String x : listOfIbans){
                    writer.write(x + System.lineSeparator());
                }
                writer.close();

                break;

            default: System.out.println("Neteisingai pasirinkta užduotis");
        }



    }

    private static void singleIbanCheck(List<String> forChech, String iban, String country, int chechSum) {
        boolean answer = false;
        for(int i = 0; i < forChech.size(); i++){
            if(country.equals(forChech.get(i).substring(0, 2)) && iban.length() == Integer.parseInt(forChech.get(i).substring(2,4)) && chechSum > 35){
                    answer=true;
            }else answer = false;
        }
        if(answer) System.out.println("Teisingas");
        else System.out.println("Neteisingas");

    }


}
