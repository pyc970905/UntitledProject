package com.example.untitledProject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileDto extends CommDto{
    private String orgFileName;
    private String fileExt;
    private String fileUuid;
    private String fileUrl;
    private String fileDivCd;
}
