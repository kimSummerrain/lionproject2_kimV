package com.example.lionproject2backend.auth.controller;


import com.example.lionproject2backend.auth.service.AuthService;
import com.example.lionproject2backend.dto.user.PostAuthSignupRequest;
import com.example.lionproject2backend.dto.user.PostAuthSignupResponse;
import com.example.lionproject2backend.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse<PostAuthSignupResponse> signup(@RequestBody PostAuthSignupRequest req) {
        PostAuthSignupResponse signupResponse
                = authService.signup(req.getEmail(), req.getPassword(), req.getNickname(),req.getRole());

        return ApiResponse.success(signupResponse);
    }
}
