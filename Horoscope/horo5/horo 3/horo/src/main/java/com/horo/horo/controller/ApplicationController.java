package com.horo.horo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.horo.horo.service.HoroscopeService;
import com.horo.horo.model.Horoscope;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/horo_aggregator/api/")
public class ApplicationController {

    private final HoroscopeService service;


    @Autowired
    public ApplicationController(HoroscopeService service) {
        this.service = service;

    }

    @GetMapping("/horo")
    public ResponseEntity<Horoscope> horo(@RequestHeader(name = "user") String user,
                                          @RequestParam(name = "sign") String sign,
                                          @RequestParam(name = "date") String date

                                          )

    {
        Horoscope horo = service.getHoroscope(sign, date);



        return new ResponseEntity<>(horo, HttpStatus.OK);
    }



}