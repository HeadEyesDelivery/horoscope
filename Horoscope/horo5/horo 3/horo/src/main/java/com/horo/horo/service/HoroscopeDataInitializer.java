package com.horo.horo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class HoroscopeDataInitializer implements CommandLineRunner {

    private final HoroscopeService horoscopeService;

    @Autowired
    public HoroscopeDataInitializer(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> signs = Arrays.asList("aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces");
        horoscopeService.fetchAndSaveHoroscopes(signs, "daily", "today");
    }
}