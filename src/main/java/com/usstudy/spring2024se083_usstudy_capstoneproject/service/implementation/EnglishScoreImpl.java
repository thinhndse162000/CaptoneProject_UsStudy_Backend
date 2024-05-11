package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EnglishScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.EnglishScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.EnglishScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.EnglishScoreMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.EnglishScoreRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.EnglishScoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EnglishScoreImpl implements EnglishScoreService {
    private final EnglishScoreRepository englishScoreRepository;

    @Override
    public List<EnglishScoreDto> getAll() {
        return englishScoreRepository.findAll()
                .stream().map(EnglishScoreMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EnglishScoreDto getById(Integer id) {
        return EnglishScoreMapper.INSTANCE.toDto(
                englishScoreRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No English Score with id - "+id)));
    }

    @Override
    public EnglishScoreDto saveEnglishScore(EnglishScoreRequest englishScoreRequest, Integer id) {
        if (id!=null){
            EnglishScore englishScore=englishScoreRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("No English Score with id - "+id));
            MergeRequest.mergeIgnoreNullValue(englishScoreRequest,englishScore);
            englishScore.setUpdateDate(new Date(System.currentTimeMillis()));
            return EnglishScoreMapper.INSTANCE.toDto(
                    englishScoreRepository.save(englishScore)
            );
        }
        EnglishScore newEnglishScore=EnglishScoreMapper.INSTANCE.toEntity(englishScoreRequest);
        newEnglishScore.setCreateDate(new Date(System.currentTimeMillis()));
        return EnglishScoreMapper.INSTANCE.toDto(
                englishScoreRepository.save(newEnglishScore)
        );
    }
}
