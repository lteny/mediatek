package ru.reuckiy.mediatek.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.reuckiy.mediatek.rest.email.EmailContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class MailSenderService {

    private static final String EMAIL_SIMPLE_CONTACT_TEMPLATE_NAME = "mail/html/email-simple";
    private static final String EMAIL_OFFER_TEMPLATE_NAME = "mail/html/email-offer";
    private static final String EMAIL_REQUEST_CALL_TEMPLATE_NAME = "mail/html/email-request-call";

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;


    public MailSenderService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }


    public void sendSimpleContactEmail(EmailContext email) throws MessagingException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                mimeMessage,
                StandardCharsets.UTF_8.name());
        final Context ctx = new Context();
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariables(email.getContext());
        email.setTemplateLocation(EMAIL_SIMPLE_CONTACT_TEMPLATE_NAME);
        final String emailContent = templateEngine.process(email.getTemplateLocation(), ctx);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendOfferEmailAttachment(final EmailContext email) throws MessagingException, FileNotFoundException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        final Context ctx = new Context();
        ctx.setVariables(email.getContext());
        email.setTemplateLocation(EMAIL_OFFER_TEMPLATE_NAME);
        ctx.setVariable("subscriptionDate", new Date());
        final String emailContent = templateEngine.process(email.getTemplateLocation(), ctx);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.addAttachment(email.getAttachment(), new ClassPathResource("uploads/"));
        mimeMessageHelper.setText(emailContent, true);

        javaMailSender.send(mimeMessage);
    }

    public void sendPhoneCallEmail(final EmailContext email) throws MessagingException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                StandardCharsets.UTF_8.name());

        final Context ctx = new Context();
        ctx.setVariables(email.getContext());
        ctx.setVariable("subscriptionDate", new Date());
        email.setTemplateLocation(EMAIL_REQUEST_CALL_TEMPLATE_NAME);
        final String emailContent = templateEngine.process(email.getTemplateLocation(), ctx);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setText(emailContent, true);

        javaMailSender.send(mimeMessage);
    }
}
