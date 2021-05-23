package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.bean.Document;
import com.bezkoder.springjwt.repository.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentDao documentDao;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    LocalDateTime now = LocalDateTime.now();

    @Autowired
    private ExportDocument exportDocument;
    @Transactional
    public void deleteById(Long id) {
        documentDao.deleteById(id);
    }



    public int save(Document document) {

        document.setDateDemande(dtf.format(now));
        documentDao.save(document);
        return 1;
    }



    public List<Document> findAll() {
        return documentDao.findAll();
    }



    @Transactional
    public void deleteAll() {
        documentDao.deleteAll();
    }
    public int update(Document document)
    {
        documentDao.save(document);
        return 1;
    }

    public ResponseEntity<InputStreamResource> exportTermePdf()
    {
        List<Document> documents=(List<Document>)documentDao.findAll();
        ByteArrayInputStream bias=exportDocument.documentPDFreport(documents);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=documents.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bias));
    }


}
