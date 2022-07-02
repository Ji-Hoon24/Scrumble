package kr.co.scrumble.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SampleMapper {
    List<String> SampleSelect();
}
