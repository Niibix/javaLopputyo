package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;



import java.io.*;
import java.util.Scanner;



@RestController
public class Controllar {

    Kurssit K = new Kurssit();
    Oppilaat O = new Oppilaat();

    File kurssi = new File("DataController.txt");
    File roskis = new File("roskis.txt");
    File oppilaat = new File("Yolo.txt");
    File studentoncourse = new File ("studentoncourse.txt");
//Opiskelija hommat

    @PostMapping("addstudent")
    public String lisaaOppilas(@RequestParam String opiskelijaID, @RequestParam String fname, @RequestParam String lname, @RequestParam String address) throws IOException {
        return O.addStudent(opiskelijaID, fname, lname, address, oppilaat);
    }

    @GetMapping("studentbyid")
    public String oppilasIDlla(@RequestParam String opiskelijaID) throws FileNotFoundException {
        return O.getStudentById(opiskelijaID, oppilaat);
    }

    //Kurssi hommat

    @PostMapping("addcourse")
    public String lisaaKurssi (@RequestParam String coursename, String kurssiID, String opettaja) throws IOException {
        return K.addcourse(coursename, kurssiID, opettaja, kurssi);
    }


    @GetMapping("coursesbyname")
    public String kurssiNimella (@RequestParam String coursename) throws FileNotFoundException {
        return K.getCoursesByName(coursename, kurssi);
    }

    @GetMapping("coursesbyid")
    public String kurssiIdlla (@RequestParam String kurssiID) throws FileNotFoundException {
        return K.getCourseById(kurssiID, kurssi );
    }


    @GetMapping("coursesbyteacher")
    public String kurssiOpettajalla (@RequestParam String opettaja) throws IOException {
        return K.getCourseByTeacher(opettaja, kurssi, roskis);
    }

    @GetMapping("allcourses")
    public String kaikkiKurssit() throws IOException {
        return K.getAllCourses();
    }

    @PostMapping("addstudenttocourse")
    public String addstudenttocourse(@RequestParam String opiskelijaID, @RequestParam String kurssiID) throws IOException {
        Scanner oppilas = new Scanner(oppilaat);
        Scanner kurssit = new Scanner (kurssi);
        while (oppilas.hasNextLine()) {
            String line = oppilas.nextLine();
            String bline = kurssit.nextLine();
            String[] tokens = line.split(" ");
            String[] btokens = line.split(" ");
             if (opiskelijaID.equals(tokens[0])) {
                System.out.println(line);
                if(kurssiID.equals(btokens[0])){
                    System.out.println(bline);
                }
                oppilas.close();
                kurssit.close();
                String Penus = line + bline;
                FileWriter fw = new FileWriter(studentoncourse, true);
                fw.write(line + " " + bline + System.lineSeparator());
                fw.close();
                return "<h3>" + line+ "<br>" + " lisätty kurssille" + "<br>" + bline + "</h3>";
            }
        }
        oppilas.close();
        return "Lol.";
    }
}






