package com.FinalYearProject.GarbageCollectionMS;

import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.auth.RegisterRequest;
import com.FinalYearProject.GarbageCollectionMS.dto.AboutUsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.NewsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.OccasionRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.entity.users.User;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseHolderRepository;
import com.FinalYearProject.GarbageCollectionMS.repo.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Role;
import com.FinalYearProject.GarbageCollectionMS.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

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
			AuthenticationService service, HouseHolderRepository houseHolderRepository, UserRepository userRepository,GarbageBinService garbageBinService, AboutUsPageService aboutUsPageService, HouseOwnerComplaintsService houseOwnerComplaintsService, NewsPageService newsPageService, OccasionRequestService occasionRequestService
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

			var driver = RegisterRequest.builder()
					.firstName("Ama")
					.lastName("Nirupadi")
					.email("ama@gmail.com")
					.password("12345")
					.nicNo("200059470838")
					.role(Role.DRIVER)
					.build();
			System.out.println("Driver token: " + service.register(driver).getAccessToken());

			var houseHolder = RegisterRequest.builder()
					.firstName("Lilanka")
					.lastName("Sawan")
					.email("lilanka@gmail.com")
					.password("5678")
					.nicNo("987474773V")
					.role(Role.HOUSEHOLDER)
					.build();
			System.out.println("HouseHolder token: " + service.register(houseHolder).getAccessToken());
//			HouseHolder houseHolder1=houseHolderRepository.findById(3).orElse(null);
//			houseHolder1.setHouseNo("h1");
//			houseHolderRepository.save(houseHolder1);
//			User adminG=userRepository.findById(1).orElse(null);
//			HouseHolder houseHolder2=houseHolderRepository.findByHouseNo("h1").orElse(null);
//			System.out.println(houseHolder2.getFirstName());
//			System.out.println(adminG.getFirstName());

			//added from ama
//			GarbageBinDTO garbageBinDTO=new GarbageBinDTO();
//			garbageBinDTO.setId("b1");
//			garbageBinDTO.setLocationType("fdfd");
//			garbageBinDTO.setLineAddress("3");
//			garbageBinDTO.setCity("3");
//			garbageBinDTO.setTypeOfWaste("solid");
//			garbageBinDTO.setNumOfHouses(2);
//			garbageBinService.addBinDetails(garbageBinDTO);

			AboutUsPageDTO aboutUsPageDTO = new AboutUsPageDTO();
			aboutUsPageDTO.setContents("tgrge");
			aboutUsPageDTO.setSelectedImage("f.jpg");
			aboutUsPageService.addAboutUsData(aboutUsPageDTO);

			NewsPageDTO newsPageDTO = new NewsPageDTO();
			newsPageDTO.setCategory("fvfvf");
			newsPageDTO.setNewsTitle("hhjj");
			newsPageDTO.setDetails("hhh");
			newsPageDTO.setSelectedImage("f.jpg");
			newsPageService.addNewsPageData(newsPageDTO);

			HouseOwnerComplaintsDTO houseOwnerComplaintsDTO = new HouseOwnerComplaintsDTO();
			houseOwnerComplaintsDTO.setComplaintType("ffgd");
			houseOwnerComplaintsDTO.setDescription("ggfgf");
			houseOwnerComplaintsDTO.setContactNo("0776026233");
			houseOwnerComplaintsService.addHouseOwnerComplaints(houseOwnerComplaintsDTO);

			OccasionRequestDTO occasionRequestDTO = new OccasionRequestDTO();
			occasionRequestDTO.setOccasionType("rrgr");
			occasionRequestDTO.setDate("2024-04-05");
			occasionRequestDTO.setContactNumber("0776026233");
			occasionRequestDTO.setDescription("ghuh");
			occasionRequestService.addOccasionRequest(occasionRequestDTO);

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

