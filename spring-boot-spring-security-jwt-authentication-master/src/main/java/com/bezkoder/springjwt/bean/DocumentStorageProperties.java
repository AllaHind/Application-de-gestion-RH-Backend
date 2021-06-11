package com.bezkoder.springjwt.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;



@ConfigurationProperties(prefix = "file")
@Entity

@Table(name = "merchant_documents")

public class DocumentStorageProperties {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "document_id")

    private Long documentId;
    @Column(name = "user_id")

    private Long UserId;

    @Column(name = "file_name")

    private String fileName;

    @Column(name = "document_type")

    private String documentType;

    @Column(name = "document_format")

    private String documentFormat;

    @Column(name = "upload_dir")

    private String uploadDir;

// Getter and Setter


    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}