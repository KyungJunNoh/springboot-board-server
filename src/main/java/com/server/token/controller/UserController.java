package com.server.token.controller;

import com.server.token.domain.dto.UserDto;
import com.server.token.domain.entity.User;
import com.server.token.service.UserService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public String signup(@ApiParam("Signup User") @RequestBody UserDto userDto){
        return userService.signup(userDto);
    }

    @GetMapping("/read/{idx}")
    public User read(@PathVariable("idx") Long idx){
        User user = userService.read(idx);
        return user;
    }

    @PutMapping("/update/{idx}")
    public String update(@PathVariable("idx") Long idx, @RequestBody UserDto userDto){
        userService.update(idx,userDto);
        return idx + " Change Success";
    }

    @PutMapping("/delete/{idx}")
    public String delete(@PathVariable("idx") Long idx){
        User user = read(idx);
        userService.delete(idx);
        return user.getUserEmail() + " 삭제 완료";
    }
}
