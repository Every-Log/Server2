package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.repository.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    /**
     * 로그인
     * 1. Repository에서 해당 회원 번호로 DB에 저장된 데이터를 가지고 옴
     * 2. 해당 데이터가 없으면(NULL) "false"를 리턴
     * 3. 해당 데이터와 사용자가 입력한 password가 같지 않다면, "false"를 리턴
     */
    @Transactional
    public boolean login(UserDto userDto) {
//        Optional<User> findMember = userRepository.findById(userDto.toEntity().getId());
//
//        if(findMember == null) {
//            return false;
//        }
//
//        if(!findMember.getPassword().equals(userDto.getPassword())) {
//            return false;
//        }

        return true;
    }
}
