package kr.kro.eeng.levelTest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "LEVELTEST")
@Getter @Setter @ToString
public class LevelTestD implements Serializable {
    @Id
    @Column(name="NUM")
    private int num;

    @Column(name="QUESTION")
    private String question;

    @Column(name="ANSWER")
    private String answer;

    @Column(name="SENTENCE")
    private String sentence;

    @Column(name="LV")
    private Long lv;

    @Column(name="TYPE")
    private int type;
}