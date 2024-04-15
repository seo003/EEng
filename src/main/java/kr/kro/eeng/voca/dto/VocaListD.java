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
@Table(name = "VOCALIST")
@Getter @Setter @ToString
public class VocaListD implements Serializable {
    @Id
    @Column(name="VOCAID")
    private int vocaId;

    @Column(name="VOCA")
    private String voca;

    @Column(name="VOCAMEAN")
    private String vocaMean;

    @Column(name="VOCALV")
    private int vocaLv;
}