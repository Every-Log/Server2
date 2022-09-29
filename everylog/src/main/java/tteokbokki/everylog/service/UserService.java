package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }
}
