package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.service.HouseHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/houseHolder")
public class HouseHolderController_old {
    @Autowired
    private HouseHolderService houseHolderService;
    @Autowired
    private ResponseDTO responseDTO;
//    @PostMapping(value = "/add")
//    public ResponseEntity addHouseHolder(@RequestBody HouseHolderDTO houseHolderDTO){
//        try{
//            String res=houseHolderService.addHouseHolder(houseHolderDTO);
//            if(res.equals("00")){
//                responseDTO.setCode(VarList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(houseHolderDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//            } else if (res.equals("06")) {
//                responseDTO.setCode(VarList.RSP_DUPLICATED);
//                responseDTO.setMessage("Allready added");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//            else{
//                responseDTO.setCode(VarList.RSP_FAIL);
//                responseDTO.setMessage("Error");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//        }catch (Exception ex){
//            responseDTO.setCode(VarList.RSP_ERROR);
//            responseDTO.setMessage(ex.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
