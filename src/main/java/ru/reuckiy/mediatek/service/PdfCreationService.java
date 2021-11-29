package ru.reuckiy.mediatek.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.reuckiy.mediatek.model.Params;
import ru.reuckiy.mediatek.model.Product;
import ru.reuckiy.mediatek.repository.ParamsRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfCreationService {
    private final ParamsRepository paramsRepository;

    public PdfCreationService(ParamsRepository paramsRepository) {
        this.paramsRepository = paramsRepository;
    }

    public void OfferCreation(final List<Product> offerData) throws FileNotFoundException, JRException {
        final String path = "/home/b0om/test/";
        final Date date = new Date();
        final List<Params> paramList = paramsRepository.findAll();
        final File file = ResourceUtils.getFile("classpath:Offers.jrxml");
        final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(offerData);
        final JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(paramList);
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("ds", ds);
//        parameters.put(JRParameter.REPORT_LOCALE, new Locale("ru", "RU"));
        final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "Offer_" + ".pdf");
    }
}
