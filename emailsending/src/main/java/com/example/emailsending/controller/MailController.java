package com.example.emailsending.controller;

import com.example.emailsending.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/email")
    public void sendEmail(@RequestParam String sendTo) {
        System.out.println("컨트롤러 성공");
        mailService.sendMail(sendTo);
    }
}
