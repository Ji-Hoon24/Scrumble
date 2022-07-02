package kr.co.scrumble.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.scrumble.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @ApiOperation(value="Sample 컨트롤러", notes="sample을 리턴")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @RequestMapping(value="/sample", method={RequestMethod.GET})
    public Map<String, Object> sample() {
        System.out.println("Sample Controller..");
        sampleService.SampleService();
        Map<String, Object> result = new HashMap<>();
        result.put("result", "Sample");
        System.out.println(result.toString());
        return result;
    }

}
