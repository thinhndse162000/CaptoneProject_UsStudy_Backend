package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;


import com.google.firebase.messaging.FirebaseMessaging;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.NotificationCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.NotificationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.*;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.*;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.NotificationService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    //    private final FirebaseMessaging firebaseMessaging;
    private final CustomerRepository customerRepository;
    private final ConsultantRepository consultantRepository;
    private final RegistrationFormRepository registrationFormRepository;
    private final ProgramRepository programRepository;
    private final ApplyStageRepository applyStageRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, FirebaseMessaging firebaseMessaging, CustomerRepository customerRepository, ConsultantRepository consultantRepository, RegistrationFormRepository registrationFormRepository, ProgramRepository programRepository, ApplyStageRepository applyStageRepository) {
        this.notificationRepository = notificationRepository;
//        this.firebaseMessaging = firebaseMessaging;
        this.customerRepository = customerRepository;
        this.consultantRepository = consultantRepository;
        this.registrationFormRepository = registrationFormRepository;
        this.programRepository = programRepository;
        this.applyStageRepository = applyStageRepository;
    }


//    public String sendNotification(Notice note) throws FirebaseMessagingException {
//
//        Notification notification = Notification
//                .builder()
//                .setTitle(note.getSubject())
//                .setBody(note.getContent())
//                .build();
//
//        Message message = Message
//                .builder()
////                .setTopic("UserId : 1")
//                .setToken(note.getRegistrationTokens())
//                .setNotification(notification)
//                .putAllData(note.getData())
//                .build();
//
//        return firebaseMessaging.send(message);
//    }


    @Override
    public Notification createNotification(NotificationCreateRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NullPointerException("Customer not found - " + request.getCustomerId()));
        Notification notification = new Notification();
        if (request.getConsultantId() != null && request.getRegistrationFormId() != null) {
            Consultant consultant = consultantRepository.findById(request.getConsultantId())
                    .orElseThrow(() -> new NullPointerException("consultant not found - " + request.getConsultantId()));
            RegistrationForm registrationForm = registrationFormRepository.findById(request.getRegistrationFormId())
                    .orElseThrow(() -> new NullPointerException("registrationForm not found - " + request.getRegistrationFormId()));

            notification.setNotificationId(0);
            notification.setDate(new Date(System.currentTimeMillis()));
            notification.setCustomer(customer);
            notification.setTitle("Cập nhập trạng thái đơn tư vấn");
            if (registrationForm.getStatus() == 0) {
                notification.setContent("Tư vấn viên " + " đã cập nhập trạng thái đơn tư vấn thành " + "Chưa được tư vấn");
            } else if (registrationForm.getStatus() == 1) {
                notification.setContent("Tư vấn viên " + " đã cập nhập trạng thái đơn tư vấn thành " + "Đang được tư vấn " + "Xin hãy chờ tư vấn viên sẽ liên lạc cho bạn");
            } else if (registrationForm.getStatus() == 2) {
                notification.setContent("Tư vấn viên " + " đã cập nhập trạng thái đơn tư vấn thành " + "Đã được tư vấn");
            }
            notificationRepository.save(notification);
        } else if (request.getProgramId() != null && request.getApplyStageId() != null) {
            Program program = programRepository.findById(request.getProgramId())
                    .orElseThrow(() -> new NullPointerException("registrationForm not found - " + request.getProgramId()));
            ApplyStage applyStage = applyStageRepository.findById(request.getApplyStageId())
                    .orElseThrow(() -> new NullPointerException("applyStage not found - " + request.getApplyStageId()));

            notification.setNotificationId(0);
            notification.setDate(new Date(System.currentTimeMillis()));
            notification.setCustomer(customer);
            notification.setTitle("Cập nhập trạng thái hồ sơ tư vấn ");
            notification.setContent("Cập nhập trạng thái hồ sơ " + program.getNameProgram() + " Thành " + applyStage.getProgramStage().getStageName());
            notificationRepository.save(notification);
        } else if (request.getProgramId() != null) {
            Program program = programRepository.findById(request.getProgramId())
                    .orElseThrow(() -> new NullPointerException("registrationForm not found - " + request.getProgramId()));

            notification.setNotificationId(0);
            notification.setDate(new Date(System.currentTimeMillis()));
            notification.setCustomer(customer);
            notification.setTitle("Ứng Tuyển Hồ Sơ Thành Công");
            notification.setContent("Bạn vừa nộp hồ sơ vào " + program.getNameProgram() + " Thành công");
            notificationRepository.save(notification);
        }
        return notification;

    }

    @Override
    public List<NotificationDto> getNotificationByCustomerId(Integer id) {
        List<Notification> notifications = notificationRepository.getNotificationByCustomerId(id);
        return notifications.stream().map(NotificationDto::convert)
                .collect(Collectors.toList());
    }
}
