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
@Table(name = "LEVELTESTCHOICE")
@Getter @Setter @ToString
public class LevelTestChoiceD implements Serializable {
    @Id
    @Column(name="IDX")
    private Long idx;

    @Column(name="NUM")
    private Long num;

    @Column(name="CHOICE")
    private String choice;
}
