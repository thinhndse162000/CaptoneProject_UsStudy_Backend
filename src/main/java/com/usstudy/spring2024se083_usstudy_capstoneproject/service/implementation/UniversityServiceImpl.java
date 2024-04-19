package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.UniversityMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.UniversityRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityServiceImpl implements IUniversityService {
    private final UniversityRepository universityRepository;
    //private final UniversityMapper universityMapper;

    @Override
    public List<UniversityDto> getAllUniversity() {
        return universityRepository.findAll()
                .stream().map(UniversityMapper.INSTANCE::universityToUniversityDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional getUniversityById(int id) {
        return universityRepository.findById(id)
                .map(UniversityMapper.INSTANCE::universityToUniversityDto);
    }

    @Override
    public UniversityDto saveUniversity(UniversityRequest universityRequest,Integer id) {
        if (id!=null){
            University university=universityRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("University not found - "+id));
            MergeRequest.mergeIgnoreNullValue(universityRequest,university);
            return UniversityMapper.INSTANCE.universityToUniversityDto(universityRepository.save(university));
        }
        return UniversityMapper.INSTANCE.universityToUniversityDto(
                universityRepository.save(UniversityMapper.INSTANCE.universityDtoToUniversity(universityRequest)));
    }

    @Override
    public List<UniversityDto> getUniversityByTypeId(Integer typeid) {
        return universityRepository.getUniversityByUniversityTypeId(typeid)
                .stream().map(UniversityMapper.INSTANCE::universityToUniversityDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UniversityDto> getUniversityByStateId(Integer stateId) {
        return universityRepository.getUniversityByStateId(stateId)
                .stream().map(UniversityMapper.INSTANCE::universityToUniversityDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UniversityDto> getUniversityByRequest(UniversityFilterRequest request) {
        List<University> universities = universityRepository.getUniversityByRequest(request);
        return universities
                .stream()
                .map(UniversityDto::convert).collect(Collectors.toList());
    }
}
