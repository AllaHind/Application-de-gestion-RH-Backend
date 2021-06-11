package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.bean.FileDB;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.FileDBRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;
    @Autowired
    private UserRepository userRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    LocalDateTime now = LocalDateTime.now();

    public FileDB store(MultipartFile file,String matricule) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      User user = userRepository.findByMatricule(matricule);
        FileDB fileDB = new FileDB();
        fileDB.setType(file.getContentType());
        fileDB.setName(fileName);
        fileDB.setData(file.getBytes());
       fileDB.setUser(user);
       fileDB.setDateEnvoie(now);
        return fileDBRepository.save(fileDB);


    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles(String  matricule) {
        return fileDBRepository.findAllByMat(matricule).stream();
    }
/*  public String getDocumentName(Long userId, String docType) {
    return fileDBRepository.getUploadDocumnetPath(userId, docType);
  }*/
}
