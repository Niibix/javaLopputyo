package com.Lopputyo.Javalol;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Kurssit {

    public Kurssit() {}


    public String getAllCourses() throws IOException {
        String contentToShow = Files.readString(Path.of("DataController"));
        if (contentToShow.equals("")) {
            return "There are no courses inserted in the system. You can add a course first to see if the application works.";
        } else {
            return "<h3> " + contentToShow.replaceAll("(\r\n|\r|\n|\n\r)", "<br>") + "</h3>";
        }

    }

    public String getCourseById(String kurssiID , File Yolofile) throws FileNotFoundException {
        Scanner reader = new Scanner(Yolofile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if (kurssiID.equals(tokens[0])) {
                System.out.println(line);
                reader.close();
                String Seppo =  "<form method='POST' action='http://localhost:8080/addstudenttocourse'><label>Course ID:</label><br><input type='text' name='kurssiID' value=" + tokens[0] + "><br><label>Student ID:</label><br><input type='text' name='opiskelijaID'><br><input type='submit' value='Submit' style='border-radius: 25px; background-color: blue; font-weight: bold; font-size: 20px';></form>";

                return line + Seppo;
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy kurssia.";
    }

    public String getCoursesByName(String coursename, File Yolofile) throws FileNotFoundException {
        Scanner reader = new Scanner(Yolofile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if (coursename.equals(tokens[1])) {
                System.out.println(line);
                reader.close();
                return "<h3>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi nimellä ei löydy kurssia.";
    }

    public String getCourseByTeacher( String opettaja, File Yolofile, File Trash) throws IOException {
        Scanner reader = new Scanner(Yolofile);
        PrintWriter dumpWriter = new PrintWriter(Trash);
        dumpWriter.print("");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            if (opettaja.equals(tokens[2] + " " + tokens[3])) {
                dumpWriter.print(line + System.lineSeparator());
                System.out.println(line);
            } else if (opettaja.equals(tokens[2])) {
                dumpWriter.print(line + System.lineSeparator());
                System.out.println(line);
            } else if (opettaja.equals(tokens[3])) {
                dumpWriter.print(line + System.lineSeparator());
                System.out.println(line);
            }


        }

        reader.close();
        dumpWriter.close();
        String Seppo = Files.readString(Path.of("roskis"));
        if (Seppo.equals("")) {
            return "Väärin meni senkin klovni";
        } else {
            return "<h3>" + Seppo.replaceAll("(\r\n|\r\n|\n\r)", "<br>") + "</h3>";
        }

    }
    public String addcourse(String coursename, String kurssiID, String opettaja, File Yolofile) throws IOException {
        FileWriter fw = new FileWriter(Yolofile, true);
        fw.write(kurssiID + " " + coursename + " " + opettaja + System.lineSeparator());
        fw.close();

        return "Kurssi lisatty";
    }
}
