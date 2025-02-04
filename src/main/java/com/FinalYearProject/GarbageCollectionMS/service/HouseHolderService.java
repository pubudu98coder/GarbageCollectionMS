package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.Repository.GarbageBinRepository;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.mapper.HouseHolderMapper;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationResponse;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.JwtService;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderDTO;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import com.FinalYearProject.GarbageCollectionMS.entity.users.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.Repository.HouseHolderRepository;
import com.FinalYearProject.GarbageCollectionMS.Repository.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role.HOUSEHOLDER;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseHolderService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final HouseHolderRepository houseHolderRepository;
    private final UserRepository userRepository;
    private final HouseHolderMapper houseHolderMapper;
    private final GarbageBinRepository garbageBinRepository;

    public List<HouseHolderResponseDTO> getAll() {
        return houseHolderRepository.findAll()
                .stream()
                .map(houseHolderMapper::toHouseHolderResponseDTO)
                .collect(Collectors.toList());
    }


    public AuthenticationResponse addHouseHolder(HouseHolderDTO houseHolderDTO){
        if(userRepository.existsByNicNo(houseHolderDTO.getNicNo())){
            System.out.println(houseHolderDTO.getNicNo());
            throw new DataIntegrityViolationException("Householder Already exists");
        }
        else{
            HouseHolder houseHolder = houseHolderMapper.toHouseHolder(houseHolderDTO);
            houseHolder.setPassword(passwordEncoder.encode(houseHolderDTO.getPassword()));
            houseHolder.setRole(HOUSEHOLDER);
            System.out.println("householder lane:" +houseHolderDTO.getLane());
            houseHolderRepository.save(houseHolder);

            var jwtToken = jwtService.generateToken(houseHolder);
            var refreshToken =  jwtService.generateRefreshToken(houseHolder);
            authenticationService.revokeAllUserTokens(houseHolder);
            authenticationService.saveUserToken(houseHolder,jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .role(HOUSEHOLDER)
                    .build();
        }
    }

    public HouseHolderResponseDTO getHouseHolderById(Integer id) {
        houseHolderRepository.findById(id);
        HouseHolder houseHolder =  houseHolderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("HouseHolder not exist by the provided ID")
        );
        return houseHolderMapper.toHouseHolderResponseDTO(houseHolder);
    }

    @Transactional
    public HouseHolderResponseDTO updateById(Integer id, HouseHolderDTO houseHolderDTO) {
        HouseHolder houseHolder = houseHolderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("HouseHolder not exist by the provided ID")
        );
        houseHolder.setFirstName(houseHolderDTO.getFirstName());
        houseHolder.setLastName(houseHolderDTO.getLastName());
        houseHolder.setAddress(houseHolderDTO.getAddress());
        houseHolder.setEmail(houseHolderDTO.getEmail());
        houseHolder.setMobileNo(houseHolder.getMobileNo());
        houseHolder.setHouseNo(houseHolderDTO.getHouseNo());
        houseHolder.setLane(houseHolderDTO.getLane());
        houseHolder.setLongitude(houseHolderDTO.getLongitude());
        houseHolder.setLatitude(houseHolderDTO.getLatitude());
        houseHolder.setApproved(houseHolderDTO.isApproved());

        Integer garbageBinId = houseHolderDTO.getGarbageBinId();
        if (garbageBinId != null) {
            GarbageBin  garbageBin = garbageBinRepository.findById(garbageBinId).orElseThrow(
                    () -> new EntityNotFoundException("Garbage Bin ID not exists")
            );
            houseHolder.setGarbageBin(garbageBin);
        }

        return houseHolderMapper.toHouseHolderResponseDTO(houseHolderRepository.save(houseHolder));

    }
}
