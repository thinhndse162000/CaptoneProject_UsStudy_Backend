package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EmailRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.EmailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomerRepository customerRepository;

    public String sendEmail(EmailRequest emailRequest) {
        try {
            if (emailRequest!=null)
            {
                Customer customer =customerRepository.getCustomerByEmail(emailRequest.getRecipient());
                if (customer!=null){
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setTo(emailRequest.getRecipient());
                    message.setSubject(emailRequest.getSubject());
                    message.setText(emailRequest.getMessageBody()+jwtTokenProvider.generateToken(customer)
                    +" \n Local link: http://localhost:3000/reset-password/"+jwtTokenProvider.generateToken(customer));

                    mailSender.send(message);
                    return "Email sent";
                }
            }
            return "No such email in Database";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
