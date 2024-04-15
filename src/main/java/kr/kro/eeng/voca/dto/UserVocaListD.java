package kr.kro.eeng.voca.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "USERVOCALIST")
@Getter  @Setter @ToString
public class UserVocaListD implements Serializable {
    @Id
    @Column(name="USERVOCALISTID")
    private int userVocaListId;

    @Column(name="USERID")
    private String userId;

    @Column(name="LISTNAME")
    private String listName;
}
