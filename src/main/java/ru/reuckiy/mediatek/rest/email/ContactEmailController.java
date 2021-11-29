package ru.reuckiy.mediatek.rest.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reuckiy.mediatek.service.MailSenderService;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class ContactEmailController {
    private static final Logger LOG = LoggerFactory.getLogger(ContactEmailController.class);

    private final MailSenderService mailSenderService;

    public ContactEmailController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }


    @GetMapping("/offer")
    public ResponseEntity<?> sendOfferEmail() throws MessagingException, FileNotFoundException {
        try {

            EmailContext con = new EmailContext();
            con.setTo("b0om@mail.ru");
            con.setFrom("java.test@email.com");
            con.setSubject("КП");
            con.setAttachment("test.pdf");

            Map<String, Object> model = new HashMap<>();
            model.put("name", "Developer");
            con.setContext(model);

            mailSenderService.sendOfferEmailAttachment(con);
        } catch (MailException | IOException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    // PostMapping
    @GetMapping("/contact")
    public ResponseEntity<?> sendContactEmail() throws MessagingException {
        try {

            EmailContext con = new EmailContext();
            con.setTo("b0om@mail.ru");
            con.setFrom("java.test@email.com");
            con.setSubject("Вопрос с сайта");


            Map<String, Object> model = new HashMap<>();
            model.put("name", "Developer");
            con.setContext(model);

            mailSenderService.sendSimpleContactEmail(con);
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    //PostMapping
    @GetMapping("/call")
    public ResponseEntity<?> sendRequestCall() throws MessagingException {
        try {

            EmailContext con = new EmailContext();
            con.setTo("b0om@mail.ru");
            con.setFrom("java.test@email.com");
            con.setSubject("Заказ звонка с сайта");


            Map<String, Object> model = new HashMap<>();
            model.put("name", "Developer");
            con.setContext(model);

            mailSenderService.sendPhoneCallEmail(con);
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }
}
