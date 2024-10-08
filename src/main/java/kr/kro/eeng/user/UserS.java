
package kr.kro.eeng.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserS {

    @Autowired
    private final UserR userR;

    public UserD login(String userId, String userPw) {
        Optional<UserD> userEntity = userR.findByUserId(userId);
        if(userEntity.isPresent()) {
            UserD user = userEntity.get();
            System.out.println(user);
            if(user.getUserPw().equals(userPw)) {
                return user;  // 로그인 성공 시 UserD 객체 반환
            } else {
                System.out.println("비밀번호가 올바르지 않습니다.");
            }
        } else {
            System.out.println("존재하지 않는 ID입니다.");
        }
        return null;  // 로그인 실패 시 null 반환
    }

    public boolean doLevelTest(String userId) {
        Long userLv = userR.findUserLvByUserId(userId);
        if (userLv == 1) {
            return true;
        }else {
            return false;
        }
    }

    @Getter
    @Setter
    private int num;

    public void register(UserD userD) {
        userR.save(userD);
    }

    public int getUserLv(String userId) {
        Optional<UserD> userD =  userR.findByUserId(userId);
        UserD user = userD.get();
        return user.getUserLv();
    }
}
