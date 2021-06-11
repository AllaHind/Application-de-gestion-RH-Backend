/*package com.bezkoder.springjwt.Service;


18
private final Path fileStorageLocation;
        19

        20
@Autowired
21
        DocumentStoragePropertiesRepo docStorageRepo;
        22
        23
@Autowired
24
public DocumentStorageService(DocumnentStorageProperties fileStorageProperties) {
        25
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
        26
        .toAbsolutePath().normalize();
        27
        28
        try {
        29
        Files.createDirectories(this.fileStorageLocation);
        30
        } catch (Exception ex) {
        31
        throw new DocumentStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        32
        }
        33
        }
        34
        35
public String storeFile(MultipartFile file, Integer userId, String docType) {
        36
        // Normalize file name
        37
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        38
        String fileName = "";
        39
        40
        try {
        41
        // Check if the file's name contains invalid characters
        42
        if(originalFileName.contains("..")) {
        43
        throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + originalFileName);
        44
        }
        45
        46
        String fileExtension = "";
        47
        try {
        48
        fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        49
        } catch(Exception e) {
        50
        fileExtension = "";
        51
        }
        52
        fileName = userId + "_" + docType + fileExtension;
        53
        // Copy file to the target location (Replacing existing file with the same name)
        54
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        55
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        56

        57
        DocumnentStorageProperties doc = docStorageRepo.checkDocumentByUserId(userId, docType);
        58
        if(doc != null) {
        59
        doc.setDocumentFormat(file.getContentType());

        doc.setFileName(fileName);

        docStorageRepo.save(doc);


        } else {

        DocumnentStorageProperties newDoc = new DocumnentStorageProperties();

        newDoc.setUserId(userId);

        newDoc.setDocumentFormat(file.getContentType());

        newDoc.setFileName(fileName);

        newDoc.setDocumentType(docType);

        docStorageRepo.save(newDoc);

        }

        return fileName;

        } catch (IOException ex) {

        throw new DocumentStorageException("Could not store file " + fileName + ". Please try again!", ex);

        }

        }

public Resource loadFileAsResource(String fileName) throws Exception {

        try {

        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();

        Resource resource = new UrlResource(filePath.toUri());

        if(resource.exists()) {

        return resource;

        } else {

        throw new FileNotFoundException("File not found " + fileName);

        }

        } catch (MalformedURLException ex) {

        throw new FileNotFoundException("File not found " + fileName);

        }

        }

public String getDocumentName(Integer userId, String docType) {

        return docStorageRepo.getUploadDocumnetPath(userId, docType);

        }

        }
        */