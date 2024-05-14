package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProfileScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProfileScoreMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProfileScoreRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProfileScoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileScoreServiceImpl implements ProfileScoreService {
    private final ProfileScoreRepository profileScoreRepository;
    @Override
    public List<ProfileScoreDto> getAll() {
        return profileScoreRepository.findAll()
                .stream().map(ProfileScoreMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileScoreDto getById(Integer id) {
        return ProfileScoreMapper.INSTANCE.toDto(
                profileScoreRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No Profile Score id - "+id))
        );
    }

    @Override
    public ProfileScoreDto saveProfileScore(ProfileScoreRequest profileScoreRequest,Integer id) {
        if (id!=null){
            ProfileScore profileScore=profileScoreRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException(""));
            MergeRequest.mergeIgnoreNullValue(profileScoreRequest,profileScore);
            return ProfileScoreMapper.INSTANCE.toDto(
                    profileScoreRepository.save(profileScore)
            );
        }
        return ProfileScoreMapper.INSTANCE.toDto(
                profileScoreRepository.save(ProfileScoreMapper.INSTANCE.toEntity(profileScoreRequest))
        );
    }

    @Override
    public void saveListProfileScore(List<ProfileScoreRequest> profileScoreRequests) {
        for (ProfileScoreRequest request:profileScoreRequests){
            profileScoreRepository.save(ProfileScoreMapper.INSTANCE.toEntity(request));
        }
    }
}
