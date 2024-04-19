package com.usstudy.spring2024se083_usstudy_capstoneproject.schedule;

import org.springframework.scheduling.annotation.Scheduled;

public class UpdateStatusProgram {

    // end program out of semester
    @Scheduled(cron = "59 23 * * *")
    public void endProgramTask() {

    }

    // start program out of semester
    @Scheduled(cron = "59 23 * * *")
    public void startProgramTask() {

    }
}
