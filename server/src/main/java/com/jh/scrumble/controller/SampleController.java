package com.jh.scrumble.controller;

import com.jh.scrumble.dto.SampleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public String sample() throws Exception {
        //System.out.println("SAMPLE");
        return "SAMPLE";
    }

    @GetMapping("/sample/dto")
    public SampleResponseDto sampleDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new SampleResponseDto(name, amount);
    }
}
