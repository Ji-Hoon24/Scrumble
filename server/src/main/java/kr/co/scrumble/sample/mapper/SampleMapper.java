package kr.co.scrumble.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SampleMapper {
    List<String> SampleSelect();
}