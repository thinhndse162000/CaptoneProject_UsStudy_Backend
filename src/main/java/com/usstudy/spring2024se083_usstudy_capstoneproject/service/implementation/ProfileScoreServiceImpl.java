package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProfileScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProfileScoreMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProfileScoreRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.SchoolProfileRepository;
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
    private final SchoolProfileRepository schoolProfileRepository;
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
                    .orElseThrow(() -> new NullPointerException("No Profile Score id - "+id));
            MergeRequest.mergeIgnoreNullValue(profileScoreRequest,profileScore);
            ProfileScore result=profileScoreRepository.save(profileScore);
            //get total score and count where == SchoolProfileId
            float sumScore=profileScoreRepository.getSumScoreBySchoolProfileId(profileScoreRequest.getSchoolProfileId());
            Integer profileScoreCount= profileScoreRepository.countProfileScoreBySchoolProfileId(profileScoreRequest.getSchoolProfileId());
            //get school profile where == SchoolProfileId and set gpa
            SchoolProfile schoolProfile=schoolProfileRepository.findById(profileScoreRequest.getSchoolProfileId())
                    .orElseThrow(() -> new NullPointerException("No School Profile id - "+id));
            schoolProfile.setGpa(sumScore/profileScoreCount);
            //update school profile to database
            schoolProfileRepository.save(schoolProfile);

            return ProfileScoreMapper.INSTANCE.toDto(
                    result
            );
        }
        ProfileScore result=profileScoreRepository.save(ProfileScoreMapper.INSTANCE.toEntity(profileScoreRequest));
        //get total score and count where == SchoolProfileId
        float sumScore=profileScoreRepository.getSumScoreBySchoolProfileId(profileScoreRequest.getSchoolProfileId());
        Integer profileScoreCount= profileScoreRepository.countProfileScoreBySchoolProfileId(profileScoreRequest.getSchoolProfileId());
        //get school profile where == SchoolProfileId and set gpa
        SchoolProfile schoolProfile=schoolProfileRepository.findById(profileScoreRequest.getSchoolProfileId())
                .orElseThrow(() -> new NullPointerException("No School Profile id - "+id));
        schoolProfile.setGpa(sumScore/profileScoreCount);
        //update school profile to database
        schoolProfileRepository.save(schoolProfile);

        return ProfileScoreMapper.INSTANCE.toDto(
                result
        );
    }

    @Override
    public void saveListProfileScore(List<ProfileScoreRequest> profileScoreRequests) {
        for (ProfileScoreRequest request:profileScoreRequests){
            profileScoreRepository.save(ProfileScoreMapper.INSTANCE.toEntity(request));
        }
    }
}
