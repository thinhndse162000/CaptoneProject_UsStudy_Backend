package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StaffDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Staff;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StaffMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StaffRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StaffService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService, UserDetailsService {

    private final StaffRepository staffRepository;
    @Override
    public List<StaffDto> getAllStaff() {
        return staffRepository.findAll()
                .stream().map(StaffMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto getStaffById(Integer id) {
        return staffRepository.findById(id)
                .map(StaffMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NullPointerException("Staff not found - "+id));
    }

    @Override
    public Staff getStaffByEmail(String email) {
        return staffRepository.getStaffByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff=staffRepository.getStaffByEmail(username);
        if (staff==null){
            throw new UsernameNotFoundException(String.format("staff '%s' not found", staff));
        }
        else {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_STAFF"));
            return new Staff(staff.getEmail(),"ROLE_STAFF",authorities);
        }
    }
}
