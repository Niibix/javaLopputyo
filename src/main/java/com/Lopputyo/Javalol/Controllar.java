package com.Lopputyo.Javalol;



import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllar {

    List<Oppilaat> oppilaat = new ArrayList<>();
    List<Kurssit> kurssit = new ArrayList<>();


    @PostMapping("addOppilaat")
    public String addOppilaat(@RequestParam String fname, @RequestParam String lname, @RequestParam String address) {
        Oppilaat o = new Oppilaat(fname,lname, address);
        oppilaat.add(o);
        return "Oppilas lisätty";
    }

    @GetMapping("allOppilaat")
    public List<Oppilaat> getOppilaat(){
        return this.oppilaat;
    }

}
