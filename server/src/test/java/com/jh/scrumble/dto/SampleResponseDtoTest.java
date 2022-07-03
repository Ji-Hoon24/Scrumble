package com.jh.scrumble.dto;

import com.jh.scrumble.sample.dto.SampleResponseDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleResponseDtoTest {

    @Test
    public void lombok_test() {

        String name = "test";
        int amount = 1000;

        SampleResponseDto dto = new SampleResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
