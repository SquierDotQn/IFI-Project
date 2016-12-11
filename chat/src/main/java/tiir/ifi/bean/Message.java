package tiir.ifi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGES")
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDMSG")
    private Integer id;
    private String author;
    private String content;
    private Integer unixstamp;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String pAuthor) {
        author = pAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String pContent) {
        content = pContent;
    }

    public Integer getUnixstamp() {
        return unixstamp;
    }

    public void setUnixstamp(final Integer pUnixstamp) {
        unixstamp = pUnixstamp;
    }
}