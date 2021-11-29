package ru.reuckiy.mediatek.rest.file;

import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reuckiy.mediatek.model.Product;
import ru.reuckiy.mediatek.repository.ProductRepository;
import ru.reuckiy.mediatek.service.PdfCreationService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class OfferPdfFileCreationController {

    private final ProductRepository productRepository;
    private final PdfCreationService pdfCreation;


    public OfferPdfFileCreationController(ProductRepository productRepository, PdfCreationService pdfCreation) {
        this.productRepository = productRepository;
        this.pdfCreation = pdfCreation;
    }

    @GetMapping("/cr")
    public ResponseEntity<?> createPdfOffer() throws IOException, JRException {
        List<Product> pr = productRepository.findAll();
        System.out.println(pr);
        pdfCreation.OfferCreation(pr);
        return new ResponseEntity<>("File create success", HttpStatus.OK);
    }
}
