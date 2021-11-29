package ru.reuckiy.mediatek.rest.file;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.reuckiy.mediatek.dto.FileResponseDTO;
import ru.reuckiy.mediatek.dto.ProductRequest;
import ru.reuckiy.mediatek.model.Categories;
import ru.reuckiy.mediatek.model.Images;
import ru.reuckiy.mediatek.repository.CategoriesRepository;
import ru.reuckiy.mediatek.repository.ImagesRepository;
import ru.reuckiy.mediatek.repository.ProductRepository;
import ru.reuckiy.mediatek.service.FileStorageService;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
public class LoadJsonToDatabaseRestController {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final ImagesRepository imagesRepository;
    private final CategoriesRepository categoriesRepository;

    @Value("${file.upload-dir}")
    String uploadPath;

    public LoadJsonToDatabaseRestController(ProductRepository productRepository, FileStorageService fileStorageService, ImagesRepository imagesRepository, CategoriesRepository categoriesRepository) {
        this.productRepository = productRepository;
        this.fileStorageService = fileStorageService;
        this.imagesRepository = imagesRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @PostMapping("/json")
    public List<Categories> insertJSONtoDB(@RequestBody ProductRequest request) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        categoriesRepository.saveAll(request.getCategories());
        loadImage();
        return request.getCategories();
    }

    @PostMapping("/json_file")
    public FileResponseDTO uploadJsonFile(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/")
                .path(fileName)
                .toUriString();

        Gson gson = new Gson();
        FileReader reader = new FileReader("C:\\mediatek\\src\\main\\resources\\uploads\\" + fileName);
        ProductRequest rp = gson.fromJson(reader, ProductRequest.class);
        productRepository.saveAll(rp.getProducts());
        return new FileResponseDTO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    public void loadImage() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(
                            X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            X509Certificate[] certs, String authType) {
                    }
                }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        List<Images> list = new ArrayList<>(imagesRepository.findAll());

        for (int i = 0; i < list.size(); i++) {
            String urlImg = list.get(i).getUrlImage();
            URLConnection openConnection = new URL(urlImg).openConnection();
            openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            BufferedImage image1 = ImageIO.read(openConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String uuidFile = UUID.randomUUID().toString();
            String fileName = uuidFile + "." + "jpg";
            File file = new File(uploadPath + fileName);
            ImageIO.write(image1, "jpg", file);
            System.out.println(image1);
        }


    }
}
