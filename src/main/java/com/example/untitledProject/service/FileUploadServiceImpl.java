package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements  FileUploadService{

    private final Path fileStorageLocation;

    public FileUploadServiceImpl() {
        // 파일을 저장할 경로 설정
        this.fileStorageLocation = Paths.get("/Users/parkyechan/Desktop/untitledProject/src/main/resources/static/file");
    }
    @Override
    public FileDto storeFile(MultipartFile file) {
        FileDto fileDto = this.generateFileName(file);

        String fileName = fileDto.getFileUuid() + fileDto.getFileExt();
        Path targetLocation = fileStorageLocation.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileDto;
        } catch (IOException e) {
            // 파일 저장 실패 처리 로직
            // 예: throw new FileStorageException("Failed to store file " + fileName, e);
            return null;
        }
    }
    @Override
    public FileDto generateFileName(MultipartFile file) {
        FileDto fileDto = new FileDto();

        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = getFileExtension(originalFileName);
        String uniqueFileName = UUID.randomUUID().toString();

        fileDto.setOrgFileName(originalFileName);
        fileDto.setFileUuid(uniqueFileName);
        fileDto.setFileExt(fileExtension);
        return fileDto;
    }
    @Override
    public String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        }
        return "";
    }
}