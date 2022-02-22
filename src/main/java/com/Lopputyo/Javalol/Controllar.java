package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;



@RestController
public class Controllar {

    File f = new java.io.File("C:\\Users\\Niko Pc\\Desktop\\Javalol\\src\\main\\java\\com\\Lopputyo\\Javalol\\DataController");

    Scanner fileScanner = new Scanner(f);



    List<Oppilaat> oppilaat = new ArrayList<>();
    List<Kurssit> kurssit = new ArrayList<>();

    public Controllar() throws FileNotFoundException {
    }


    @PostMapping("addOppilaat")
    public String addOppilaat(@RequestParam String fname, @RequestParam String lname, @RequestParam String address, @RequestParam String opiskelijaID) throws IOException {
        Oppilaat o = new Oppilaat(fname,lname, address, opiskelijaID);

        FileWriter fw = new FileWriter(f,true);
        fw.write(fname + System.lineSeparator());
        fw.write(lname + System.lineSeparator());
        fw.write(address + System.lineSeparator());
        fw.write(opiskelijaID + System.lineSeparator());

        fw.close();

        oppilaat.add(o);
        return "Oppilas lisätty";
    }

    @GetMapping("allOppilaat")
    public List<Oppilaat> getOppilaat(){

        while(fileScanner.hasNext())
        {
            String row = fileScanner.nextLine();
            System.out.println(row);

        }

        return this.oppilaat;
    }

    @PostMapping("addKurssit")
    public String addKurssit(@RequestParam String coursename, @RequestParam String opettaja, @RequestParam String ajankohta, @RequestParam String kurssiID){
        Kurssit k = new Kurssit(coursename, opettaja,ajankohta,kurssiID);
        kurssit.add(k);
        return"Kurssi lisatty";
    }

    @GetMapping("allKurssit")
    public List<Kurssit>getKurssit(){ return this.kurssit;}
}

