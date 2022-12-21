package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.UserService;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public Long signUp(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/api/user/find/{id}")
    public UserDto findById(@PathVariable Long id)
    {
        return userService.findById(id);
    }

    @GetMapping("/api/user/update/{id}")

    public Long update(@PathVariable Long id, UserDto userDto) { return userService.update(id, userDto); }

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody UserDto userDto) {
        log.info("userId = {}, password = {}", userDto.toEntity().getUserId(), userDto.toEntity().getPassword());
        if(userService.login(userDto.toEntity().getUserId(), userDto.toEntity().getPassword()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
