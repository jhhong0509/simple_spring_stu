package com.example.emailsending.service;

import com.example.emailsending.exceptions.EmailSendException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Async
    @Override
    public void sendMail(String sendTo) {
        try {
            final MimeMessagePreparator preparator = mimeMessage -> {
                final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setFrom(sender); // 보낸 사람 설정
                helper.setTo(sendTo); // 받을 사람 설정
                helper.setSubject("공부용 알림"); // 메일 제목
                helper.setText("공부용 알림 내용"); // 알림 내용
            };
            javaMailSender.send(preparator);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            throw new EmailSendException();
        }
    }

}
