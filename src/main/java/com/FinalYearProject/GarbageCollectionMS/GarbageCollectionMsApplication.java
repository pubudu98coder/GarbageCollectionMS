package com.FinalYearProject.GarbageCollectionMS;

import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.auth.RegisterRequest;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.entity.users.User;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseHolderRepository;
import com.FinalYearProject.GarbageCollectionMS.repo.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Role;
import com.FinalYearProject.GarbageCollectionMS.service.AboutUsPageService;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageBinService;
import com.FinalYearProject.GarbageCollectionMS.service.HouseOwnerComplaintsService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GarbageCollectionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageCollectionMsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service, HouseHolderRepository houseHolderRepository, UserRepository userRepository,GarbageBinService garbageBinService, AboutUsPageService aboutUsPageService, HouseOwnerComplaintsService houseOwnerComplaintsService
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstName("Pubudu")
					.lastName("Tharaka")
					.email("pubudu@gmail.com")
					.password("1234")
					.nicNo("981582942V")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var houseHolder = RegisterRequest.builder()
					.firstName("Lilanka")
					.lastName("Sawan")
					.email("lilanka@gmail.com")
					.password("5678")
					.nicNo("987474773V")
					.role(Role.HOUSEHOLDER)
					.build();
			System.out.println("HouseHolder token: " + service.register(houseHolder).getAccessToken());
			HouseHolder houseHolder1=houseHolderRepository.findById(2).orElse(null);
			houseHolder1.setHouseNo("h1");
			houseHolderRepository.save(houseHolder1);
			User adminG=userRepository.findById(1).orElse(null);
			HouseHolder houseHolder2=houseHolderRepository.findByHouseNo("h1").orElse(null);
			System.out.println(houseHolder2.getFirstName());
			System.out.println(adminG.getFirstName());

			//added from ama
			GarbageBinDTO garbageBinDTO=new GarbageBinDTO();
			garbageBinDTO.setId("b1");
			garbageBinDTO.setBaseArea("fdfd");
			garbageBinDTO.setNumOfTargetHouses(3);
			garbageBinDTO.setHeight(3);
			garbageBinService.addBinDetails(garbageBinDTO);

			//added from ama
//			AboutUsPageDTO aboutUsPageDTO=new AboutUsPageDTO();
//			aboutUsPageDTO.setContent("dffjdfjdnjhj");
//			aboutUsPageService.addAboutUsData(aboutUsPageDTO);

//			HouseOwnerComplaintsDTO houseOwnerComplaintsDTO=new HouseOwnerComplaintsDTO();
//			houseOwnerComplaintsDTO.setContactNo("077-6025233");
//			houseOwnerComplaintsDTO.setDescription("dfffggghhjjj");
//			houseOwnerComplaintsService.addHouseOwnerComplaints(houseOwnerComplaintsDTO);
		};
	}
}

//    @Bean
//    public CommandLineRunner commandLineRunner(
//            GarbageBinService garbageBinService
//            ){
//        return args -> {
//            GarbageBinDTO garbageBinDTO=new GarbageBinDTO();
//            garbageBinDTO.setBaseArea("fdfd");
//            garbageBinDTO.setNumOfTargetHouses(3);
//            garbageBinDTO.setHeight(3);
//
//            garbageBinService.addBinDetails(garbageBinDTO);
//        };
//    }

