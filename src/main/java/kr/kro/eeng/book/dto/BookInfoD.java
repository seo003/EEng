package kr.kro.eeng.book.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BOOKINFO")
@Getter @Setter @ToString
public class BookInfoD {
    @Id
    @Column(name="BOOKID")
    private int bookId;

    @Column(name="BOOKNAME")
    private String bookName;

    @Column(name="BOOKAUTHOR")
    private String bookAuthor;
}
