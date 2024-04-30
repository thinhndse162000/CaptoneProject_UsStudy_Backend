package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplicationFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplicationFeeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplicationFee;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramFee;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ApplicationFeeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplicationFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplicationFeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationFeeServiceImpl implements ApplicationFeeService {
    private final ApplicationFeeRepository applicationFeeRepository;
    private final ProgramFeeRepository programFeeRepository;

    @Override
    public ApplicationFeeDto saveApplicationFee(ApplicationFeeRequest applicationFeeRequest,Integer programId) {
        if (programId!=null){
            List<ProgramFee> programFees=programFeeRepository.getByProgramId(programId);
            Integer total=0;
            for (ProgramFee programFee:programFees){
                total+=programFee.getAmount();
            }
            applicationFeeRequest.setTotal(total);
            return ApplicationFeeMapper.INSTANCE.toDto(
                    applicationFeeRepository.save(ApplicationFeeMapper.INSTANCE.toEntity(applicationFeeRequest))
            );
        }
        else {
            applicationFeeRequest.setTotal(null);
            return ApplicationFeeMapper.INSTANCE.toDto(
                    applicationFeeRepository.save(ApplicationFeeMapper.INSTANCE.toEntity(applicationFeeRequest))
            );
        }
    }

    @Override
    public ApplicationFeeDto updateApplicationFee(ApplicationFeeRequest applicationFeeRequest, Integer id) {
        ApplicationFee applicationFee=applicationFeeRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Application Fee id "+id));
        MergeRequest.mergeIgnoreNullValue(applicationFeeRequest,applicationFee);
        return ApplicationFeeMapper.INSTANCE.toDto(
                applicationFeeRepository.save(applicationFee)
        );
    }

    @Override
    public Optional findById(Integer id) {
        return applicationFeeRepository.findById(id)
                .map(ApplicationFeeMapper.INSTANCE::toDto);
    }

    @Override
    public List<ApplicationFeeDto> getAll() {
        return applicationFeeRepository.findAll()
                .stream().map(ApplicationFeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
