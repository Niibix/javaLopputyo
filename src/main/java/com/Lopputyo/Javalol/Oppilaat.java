package com.Lopputyo.Javalol;

import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Oppilaat {
    public String fname;
    public String lname;
    public String address;
    public String opiskelijaID;

    public Oppilaat() {


    }
    public String addStudent(String opiskelijaID, String fname, String lname, String address, File Mies) throws IOException {
        FileWriter fw = new FileWriter(Mies, true);
        fw.write(opiskelijaID + " " + fname + " " + lname + " " + address + System.lineSeparator());
        fw.close();
        return "Opiskelija lisätty";


    }
    public String getStudentById( String opiskelijaID, File Mies) throws FileNotFoundException {
        Scanner reader = new Scanner(Mies);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            if (opiskelijaID.equals(tokens[0])) {
                System.out.println(line);
                reader.close();
                return "<h3>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy opiskelijaa.";
    }

}


