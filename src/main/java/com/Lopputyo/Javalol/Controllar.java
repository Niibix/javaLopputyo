package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.io.*;
import java.util.Scanner;



@RestController
public class Controllar {

    File filu = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\DataController");


    public Controllar() throws FileNotFoundException {
    }


    @PostMapping("addOppilaat")
    public String addOppilaat(@RequestParam String fname, @RequestParam String lname, @RequestParam String address, @RequestParam String opiskelijaID) throws IOException {
        Oppilaat o = new Oppilaat(fname,lname, address, opiskelijaID);
        Oppilaat.add(o);
        return "";


    }

    @GetMapping("allOppilaat")
    public List<Oppilaat> getOppilaat() {



        return null;
    }

    @PostMapping("addKurssit")
    public String addKurssit(@RequestParam String coursename,  @RequestParam String kurssiID) throws IOException {
        FileWriter fw = new FileWriter(filu, true);
        fw.write(kurssiID + " " + coursename + System.lineSeparator());
        fw.close();

        return"Kurssi lisatty";
    }

    @GetMapping("coursesbyname")
    public String getCourseByName(@RequestParam String coursename) throws FileNotFoundException {
        Scanner reader = new Scanner(filu);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if(coursename.equals(tokens[1])){
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
            if(kurssiID.equals(tokens[0])){
                System.out.println(line);
                reader.close();
                return "<h3>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy kurssia.";
    }

}

