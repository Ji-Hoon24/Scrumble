package kr.co.scrumble.controller;

import kr.co.scrumble.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/sample")
    public String sample() {
        System.out.println("Sample Controller..");
        sampleService.SampleService();
        return "sample";
    }

}
