package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllar {

    List<Oppilaat> oppilaat = new ArrayList<>();
    List<Kurssit> kurssit = new ArrayList<>();


    @PostMapping("addOppilaat")
    public String addOppilaat(@RequestParam String fname, @RequestParam String lname, @RequestParam String address, @RequestParam String opiskelijaID) {
        Oppilaat o = new Oppilaat(fname,lname, address, opiskelijaID);
        oppilaat.add(o);
        return "Oppilas lisätty";
    }

    @GetMapping("allOppilaat")
    public List<Oppilaat> getOppilaat(){
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
