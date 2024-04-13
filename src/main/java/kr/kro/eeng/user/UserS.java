package kr.kro.eeng.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserS {

    @Autowired
    private UserR userR;

    public boolean login(String userId, String userPw) {
        Optional<UserD> userEntity = userR.findByUserId(userId);
        if(userEntity.isPresent()) {
            UserD user = userEntity.get();
            System.out.println(user);
            if(user.getUserPw().equals(userPw)) {
                return true;
            }else {
                System.out.println("비밀번호가 올바르지 않습니다.");
            }
        }else{
            System.out.println("존재하지 않는 ID입니다.");
        }
        return false;
    }

    public int getUserLvFromUserId(String userId) {
        return userR.findUserLvByUserId(userId);
    }
}
