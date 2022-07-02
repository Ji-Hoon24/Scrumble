package kr.co.scrumble.sample.service;

import kr.co.scrumble.sample.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {

    @Autowired
    SampleMapper sampleMapper;

    @Transactional
    public void SampleService() {
        System.out.println("Sample Service..");
        System.out.println(sampleMapper.SampleSelect().get(0));
    }
}