package com.usstudy.spring2024se083_usstudy_capstoneproject.schedule;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramRepository;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Date;
import java.util.List;

public class UpdateStatusProgram {
    private final ProgramRepository programRepository;

    public UpdateStatusProgram(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    // end program out of semester
    @Scheduled(cron = "59 23 * * *")
    public void endProgramTask() {
        Date date = new Date(System.currentTimeMillis());
        List<Program> programList = programRepository.getProgrambyEndDate(date);
        for (Program program : programList) {
            program.setStatus("Inactive");
            programRepository.save(program);
        }
    }

    // start program out of semester
    @Scheduled(cron = "59 23 * * *")
    public void startProgramTask() {
        Date date = new Date(System.currentTimeMillis());
        List<Program> programList = programRepository.getProgrambyStartDate(date);
        for (Program program : programList) {
            program.setStatus("Active");
            programRepository.save(program);
        }
    }
}
