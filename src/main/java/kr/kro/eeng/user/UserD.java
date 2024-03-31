package kr.kro.eeng.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "USERS")
@Getter @Setter @ToString
public class UserD implements Serializable {
    @Id
    @Column(name="USERID")
    private String userId;

    @Column(name="USERNAME")
    private String userName;

    @Column(name="USERPW")
    private String userPw;

    @Column(name="USERBIRTH")
    private Date userBirth;

    @Column(name="USEREMAIL")
    private String userEmail;

    @Column(name="USERPHONE")
    private String userPhone;

    @Column(name="USERLV")
    private int userLv;

//    @Enumerated(EnumType.STRING) // Enum 값을 어떤 형태로 정할지 결정, default = int
//    @Column(nullable = false)
//    private Role role;
}
