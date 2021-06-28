package com.example.anketguncel.controller;

import com.example.anketguncel.dto.AnketDto;
import com.example.anketguncel.response.ResponseItem;
import com.example.anketguncel.service.AnketService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/anket")
public class AnketController {

    @Autowired
    AnketService anketService;

    @GetMapping(value = "/anasayfa")
    public ModelAndView show(Model model){
        ModelAndView modelAndView = new ModelAndView("Secim");

        return modelAndView;
    }

    @GetMapping(value = "/kaydet")
    public String  show(Model model, @RequestParam int secim){
        if (secim == 1) {
            return "AnketKayit.html";
        }else {
            return "AnketMutluKayit.html";
        }
    }

    @GetMapping(value = "/liste")
    public ModelAndView showTable(Model model, @RequestParam int secim){
        if (secim == 1) {
            ModelAndView modelAndView = new ModelAndView("AnketTablo");
            List<AnketDto> takim = anketService.listele(secim);

            model.addAttribute("takim", takim);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("AnketMutluTablo");
            List<AnketDto> mutlu = anketService.listele(secim);

            model.addAttribute("mutlu", mutlu);
            return modelAndView;
        }
    }

    @GetMapping(value = "/guncelle")
    public String takimGuncelle(Model model, @RequestParam int id, @RequestParam int secim){
        if (secim == 1) {
            model.addAttribute("takim", anketService.findById(id, secim));
            return "AnketGuncelle.html";
        }else {
            model.addAttribute("mutlu", anketService.findById(id, secim));
            return "AnketMutluGuncelle.html";
        }
    }

    @PostMapping(value = "/kayit")
    public ResponseEntity<ResponseItem> create(@RequestBody AnketDto anketDto){

        ResponseItem responseItem = anketService.create(anketDto);

        return ResponseEntity.ok(responseItem);
    }

    @PostMapping(value = "/listele")
    public String listele (){
        List<AnketDto> anketDtoList = anketService.listele(1);
        String jsonData = new Gson().toJson(anketDtoList);
        return jsonData;
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<ResponseItem> update(@RequestBody AnketDto anketDto){
        return ResponseEntity.ok(anketService.update(anketDto));
    }

    @GetMapping(value = "/sil")
    public Object delete(@RequestParam int id, @RequestParam int secim, Model model ){
        ResponseItem responseItem = anketService.delete(id,secim);

        if (responseItem.result == true) {
            return showTable(model, secim);
        } else {
            takimGuncelle(model, id, secim);
            return takimGuncelle(model, id,secim);
        }

    }

}

