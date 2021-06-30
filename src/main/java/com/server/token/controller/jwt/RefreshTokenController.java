package com.server.token.controller.jwt;

import com.server.token.service.jwt.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RefreshTokenController {
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/refreshtoken")
    public Map<String,String> refresh(HttpServletRequest request){ // accesstoken과 refreshToken 을 입력받음
        return refreshTokenService.refresh(request);
    }
}
