package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

public interface FileUploadService {

    FileDto storeFile(MultipartFile file);

    FileDto generateFileName(MultipartFile file);

    String getFileExtension(String fileName);
}
