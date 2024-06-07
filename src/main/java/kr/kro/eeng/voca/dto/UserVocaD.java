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
@Table(name = "USERVOCA")
@Getter
@Setter
@ToString
public class UserVocaD implements Serializable {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "VOCAID")
    private int vocaId;
}
