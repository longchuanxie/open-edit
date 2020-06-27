package com.xielc1.group.open.edit.dao.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("comment")
public class Comment {
    @Id
    private String id;
    private String commenterId;
    private String commentContext;
    private Comment lastComment;
    private Comment nextComment;
    private String createDate;

}
