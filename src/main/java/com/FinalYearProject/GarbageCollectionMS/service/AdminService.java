package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.config.JwtService;
import com.FinalYearProject.GarbageCollectionMS.dto.AdminDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Role;
import com.FinalYearProject.GarbageCollectionMS.entity.users.User;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.Admin;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.repo.AdminRepository;
import com.FinalYearProject.GarbageCollectionMS.repo.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.FinalYearProject.GarbageCollectionMS.entity.users.Role.ADMIN;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdminRepository adminRepository;
    public String registerAdmin(AdminDTO adminDTO){
        if(userRepository.existsByNicNo(adminDTO.getNicNo())){
            return VarList.RSP_DUPLICATED;
        }
        else{
            Admin admin =modelMapper.map(adminDTO, Admin.class);
            admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
            admin.setRole(ADMIN);
            adminRepository.save(admin);
            //
            User user=admin;
            var jwtToken=jwtService.generateToken(user);
            jwtService.generateRefreshToken(user);
            authenticationService.revokeAllUserTokens(user);
            authenticationService.saveUserToken(user,jwtToken);
            return VarList.RSP_SUCCESS;
        }
    }
}
