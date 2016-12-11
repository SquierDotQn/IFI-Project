package tiir.ifi.controller;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.hsqldb.types.TimestampData;

public class CreationForm {

    @NotEmpty
    private String author;
    @NotEmpty
    private String content;
    @NotEmpty
    private int unixstamp;

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

    public int getUnixstamp() {
    	Timestamp t = new Timestamp(0);
    	return 0;
    }

}