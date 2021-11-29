package ru.reuckiy.mediatek.rest.email;

import lombok.Data;

import java.util.Map;

@Data
public class EmailContext {

    private String from;
    private String to;
    private String subject;
    private String attachment;
    private String templateLocation;
    private String imageResourceName;
    private String imageContentType;
    private byte[] imageBytes;
    private Map<String, Object> context;

}
