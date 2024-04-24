package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.JwtService;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderDTO;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.Repository.HouseHolderRepository;
import com.FinalYearProject.GarbageCollectionMS.Repository.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role.HOUSEHOLDER;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseHolderService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    @Autowired
    private HouseHolderRepository housholderRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public String addHouseHolder(HouseHolderDTO houseHolderDTO){
        if(userRepository.existsByNicNo(houseHolderDTO.getNicNo())){
            System.out.println(houseHolderDTO.getNicNo());
            return VarList.RSP_DUPLICATED;
        }
        else{

            HouseHolder houseHolder=modelMapper.map(houseHolderDTO,HouseHolder.class);
            houseHolder.setPassword(passwordEncoder.encode(houseHolderDTO.getPassword()));
            houseHolder.setRole(HOUSEHOLDER);
            System.out.println(houseHolderDTO.getHouseNo());
            housholderRepo.save(houseHolder);
            //
            User user=houseHolder;
            var jwtToken=jwtService.generateToken(user);
            jwtService.generateRefreshToken(user);
            authenticationService.revokeAllUserTokens(user);
            authenticationService.saveUserToken(user,jwtToken);
            return VarList.RSP_SUCCESS;
        }
        //return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).role(user.getRole()).build();
    }


//    public AuthenticationResponse addHouseHolder(HouseHolderDTO houseHolderDTO){
//        HouseHolder houseHolder=modelMapper.map(houseHolderDTO,HouseHolder.class);
//        houseHolder.setPassword(passwordEncoder.encode(houseHolderDTO.getPassword()));
//        housholderRepo.save(houseHolder);
//        //
//        User user=(User) houseHolder;
//        var jwtToken=jwtService.generateToken(user);
//        var refreshToken=jwtService.generateRefreshToken(user);
//        authenticationService.revokeAllUserTokens(user);
//        authenticationService.saveUserToken(user,jwtToken);
//        return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).role(user.getRole()).build();
//
//    }
//        if(housholderRepo.existsById(houseHolderDTO.getId())){
//            return VarList.RSP_DUPLICATED;
//        }
//        else{
//            housholderRepo.save(modelMapper.map(houseHolderDTO, HouseHolder.class));
//            return VarList.RSP_SUCCESS;
//        }

}
