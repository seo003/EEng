package kr.kro.eeng.user;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserD {
    private String userId;
    private String userName;
    private String userPw;
    private Date userBirth;
    private String userEmail;
    private String userPhone;
}
