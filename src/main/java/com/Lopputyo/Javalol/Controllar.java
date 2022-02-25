package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.*;
import java.util.Scanner;



@RestController
public class Controllar {

    File filu = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\DataController");
    File roskis = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\roskis");
    File oppilaat = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\Oppilaat");
    File Yolo   = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\Yolo");
//Opiskelija hommat

    @PostMapping("addstudent")
    public String addStudent(@RequestParam String opiskelijaID, @RequestParam String fname, @RequestParam String lname, @RequestParam String address) throws IOException {
        FileWriter fw = new FileWriter(oppilaat, true);
        fw.write(opiskelijaID + " " + fname + " " + lname + " " + address + System.lineSeparator());
        fw.close();
        return "Opiskelija lisätty";


    }

    @GetMapping("studentbyid")
    public String getStudentById(@RequestParam String opiskelijaID) throws FileNotFoundException {
        Scanner reader = new Scanner(oppilaat);
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


    //Kurssi hommat

    @PostMapping("addcourse")
    public String addcourse(@RequestParam String coursename, @RequestParam String kurssiID, @RequestParam String opettaja) throws IOException {
        FileWriter fw = new FileWriter(filu, true);
        fw.write(kurssiID + " " + coursename + " " + opettaja + System.lineSeparator());
        fw.close();

        return "Kurssi lisatty";
    }

    @GetMapping("coursesbyname")
    public String getCourseByName(@RequestParam String coursename) throws FileNotFoundException {
        Scanner reader = new Scanner(filu);
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

    @GetMapping("coursesbyid")
    public String getCourseById(@RequestParam String kurssiID) throws FileNotFoundException {
        Scanner reader = new Scanner(filu);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if (kurssiID.equals(tokens[0])) {
                System.out.println(line);
                reader.close();
                String Seppo = "<form method='POST' action = 'http://localhost:8080/lisaaOppilas'><label>Lisää itsesi kurssille:</label><br><input type='text' name='kurssiID'><br><input type = 'submit' value = 'Hae'></form>";
                return "<h3>" + line + "</h3>" + Seppo;
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy kurssia.";
    }

    @GetMapping("coursesbyteacher")
    public String getCourseByTeacher(@RequestParam String opettaja) throws IOException {
        Scanner reader = new Scanner(filu);
        PrintWriter dumpWriter = new PrintWriter(roskis);
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
        String Seppo = Files.readString(Path.of("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\roskis"));
        if (Seppo.equals("")) {
            return "Väärin meni senkin klovni";
        } else {
            return "<h3>" + Seppo.replaceAll("(\r\n|\r\n|\n\r)", "<br>") + "</h3>";
        }

    }
    @GetMapping("allcourses")
    public String getAllCourses() throws IOException {
        String contentToShow = Files.readString(Path.of("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\DataController"));
        if(contentToShow.equals("")){
            return "There are no courses inserted in the system. You can add a course first to see if the application works.";
        }else {
            return "<h3> " + contentToShow.replaceAll("(\r\n|\r|\n|\n\r)", "<br>") + "</h3>";
        }
    }
    @PostMapping("addstudenttocourse")
    public String addstudenttocourse(@RequestParam String opiskelijaID, @RequestParam String kurssiID) throws IOException {
        Scanner oppilas = new Scanner(oppilaat);
        Scanner kurssi = new Scanner (filu);
        while (oppilas.hasNextLine()) {
            String line = oppilas.nextLine();
            String bline = kurssi.nextLine();
            String[] tokens = line.split(" ");
            String[] btokens = line.split(" ");
             if (opiskelijaID.equals(tokens[0])) {
                System.out.println(line);
                if(kurssiID.equals(btokens[0])){
                    System.out.println(bline);
                }
                oppilas.close();
                kurssi.close();
                String Penus = line + bline;
                FileWriter fw = new FileWriter(Yolo, true);
                fw.write(line + " " + bline + System.lineSeparator());
                fw.close();
                return "<h3>" + line + " lisätty kurssille" + bline + "</h3>";
            }
        }
        oppilas.close();
        return "Lol.";
    }
}






