package com.jh.scrumble.config.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jh.scrumble.user.domain.UserRepository;
import com.jh.scrumble.user.domain.entity.Role;
import com.jh.scrumble.user.domain.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";
    private static final String REFRESH_TOKEN_SUBJECT = "RefreshToken";
    private static final String USERNAME_CLAIM = "username";
    private static final String USERID_CLAIM = "userid";

    @Before
    public void init() {
        User user = User.builder().name("JH").email("ohjihoon24@gmail.com").picture("empty").role(Role.GUEST).refreshToken(null).build();
        userRepository.save(user);
    }

    @Test
    public void 토큰생성후_데이터추출까지() {
        Optional<User> user = userRepository.findByName("JH");
        String accessToken = jwtService.createAccessToken(user.get());
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(secret)).build().verify(accessToken);
        String subject = verify.getSubject();
        String findUsername = verify.getClaim(USERNAME_CLAIM).asString();
        Long findUserid = verify.getClaim(USERID_CLAIM).asLong();

        assertThat(findUsername).isEqualTo("JH");
        assertThat(findUserid).isEqualTo(user.get().getId());
        assertThat(subject).isEqualTo(ACCESS_TOKEN_SUBJECT);
    }

    @Test
    public void 리프레시토큰_발급() {
        //given
        String refreshToken = jwtService.createRefreshToken();
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(secret)).build().verify(refreshToken);
        String subject = verify.getSubject();
        String username = verify.getClaim(USERNAME_CLAIM).asString();
        assertThat(subject).isEqualTo(REFRESH_TOKEN_SUBJECT);
        assertThat(username).isNull();
    }
}
