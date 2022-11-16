package com.jh.scrumble.sample.controller;

import com.jh.scrumble.sample.dto.SampleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/sample")
    public String sample() throws Exception {
        log.info("SAMPLE");
        return "SAMPLE";
    }

    @GetMapping("/sample/dto")
    public SampleResponseDto sampleDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new SampleResponseDto(name, amount);
    }
}
