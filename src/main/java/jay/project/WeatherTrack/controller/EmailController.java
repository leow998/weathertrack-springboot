package jay.project.WeatherTrack.controller;

import jay.project.WeatherTrack.entity.EmailDetails;
import jay.project.WeatherTrack.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService; 

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails details) {
        return emailService.sendMail(details);
    }
}