package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Service.DocumentService;
import com.bezkoder.springjwt.bean.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Document-Provided")
public class DocumentProvided {
    @Autowired
    private DocumentService documentService;
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        documentService.deleteById(id);
    }
    @GetMapping("/")
    public List<Document> findAll() {
        return documentService.findAll();
    }
    @PutMapping("/")
    public int update(@RequestBody Document document) {
        return documentService.update(document);
    }
    @PostMapping("/")
    public int save(@RequestBody Document document) {
        return documentService.save(document);
    }
    @GetMapping("/export/pdf")
    public ResponseEntity<InputStreamResource> exportTermePdf() {
        return documentService.exportTermePdf();
    }

}

