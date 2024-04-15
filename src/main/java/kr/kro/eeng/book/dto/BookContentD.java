package kr.kro.eeng.book.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BOOKCONTENT")
@Getter @Setter @ToString
public class BookContentD {
    @Id
    @Column(name="BOOKCONTID")
    private int bookContId;

    @Column(name="BOOKID")
    private int bookId;

    @Column(name="SENTNO")
    private int sentNo;

    @Column(name="SENT")
    private String sent;

    @Column(name="SENTTRANS")
    private String sentTrans;

    @Column(name="TRANSTF")
    private int transTF;
}
