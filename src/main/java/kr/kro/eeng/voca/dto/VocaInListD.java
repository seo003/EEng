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
@Table(name = "VOCAINLIST")
@Getter @Setter @ToString
public class VocaInListD implements Serializable {
    @Id
    @Column(name="VOCAINLISTID")
    private int vcoaInListId;

    @Column(name="USERVOCALISTID")
    private String userVocaListId;

    @Column(name="VOCAID")
    private String vocaId;
}
