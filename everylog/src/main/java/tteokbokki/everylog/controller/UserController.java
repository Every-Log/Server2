package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/api/user")
    public String GetMappingTest (@RequestParam int id) {

        return "Get Mapping : " + id;
    }


    @PostMapping("/api/user")
    public Long save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
}
