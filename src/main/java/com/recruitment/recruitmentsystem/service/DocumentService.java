package com.recruitment.recruitmentsystem.service;


import com.recruitment.recruitmentsystem.mapper.DocumentMapper;
import com.recruitment.recruitmentsystem.model.Document;
import com.recruitment.recruitmentsystem.model.dto.DocumentDto;
import com.recruitment.recruitmentsystem.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private DocumentRepository documentRepository;
    private DocumentMapper documentMapper;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, DocumentMapper documentMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }


    public Document getById(Long documentId) {
        Optional<Document> optionalDocument = documentRepository.findById(documentId);

        if (optionalDocument.isPresent()) {
            return optionalDocument.get();
        }
        throw new EntityNotFoundException("document, id:" + documentId);
    }

    public Long save(DocumentDto dto) {
        Document document = documentMapper.createDocumentFromDto(dto);

        return documentRepository.save(document).getId();
    }

    public void update(DocumentDto documentDto) {

        Optional<Document> optionalDocument = documentRepository.findById(documentDto.getId());
        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();

            if (document.getDocumentType() != null) {
                document.setDocumentType(documentDto.getDocumentType());
            }

            documentRepository.save(document);
            return;
        }
        throw new EntityNotFoundException("document, id:" + documentDto.getId());
    }

    public void delete(Long id) {
        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("document, id:" + id);
    }
}
