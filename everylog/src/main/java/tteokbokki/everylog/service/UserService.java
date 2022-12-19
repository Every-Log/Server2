package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getId();

    }

    //조회
    public UserDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("이이런 사용자는 없습니다. id=" + id));

        return new UserDto(entity);
    }

    //수정
    @Transactional
    public Long update(Long id, UserDto userDto)
    {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다. id = " + id));

        user.update(userDto.getName(), userDto.getImage());
        return id;
    }

    /**
     * 로그인
     * 1. Repository에서 해당 회원 번호로 DB에 저장된 데이터를 가지고 옴
     * 2. 해당 데이터가 없으면(NULL) "false"를 리턴
     * 3. 해당 데이터와 사용자가 입력한 password가 같지 않다면, "false"를 리턴
     */

    @Transactional
    public String login(String userId, String password) {
        LocalDate localDate = LocalDate.now();

        Optional<User> user = userRepository.findByUserId(userId);

        User you = user.get();

        if (you.getLateDate().getMonth() != localDate.getMonth())
            you.sendAchive();

        log.info("db password = {}, input password = {}", user.get().getPassword(), password);
        if(user.get().getPassword().equals(password)) {
            return "Success";
        }

        return "Failed";
    }
}
