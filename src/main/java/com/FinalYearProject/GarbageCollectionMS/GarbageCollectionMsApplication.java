package com.FinalYearProject.GarbageCollectionMS;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.RegisterRequest;
import com.FinalYearProject.GarbageCollectionMS.dto.AboutUsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.NewsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.Repository.HouseHolderRepository;
import com.FinalYearProject.GarbageCollectionMS.Repository.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role;
import com.FinalYearProject.GarbageCollectionMS.service.*;
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
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service, HouseHolderRepository houseHolderRepository, UserRepository userRepository,GarbageBinService garbageBinService, AboutUsPageService aboutUsPageService, HouseOwnerComplaintsService houseOwnerComplaintsService, NewsPageService newsPageService, OccasionRequestService occasionRequestService
//	) {
//		return args -> {
//			AboutUsPageDTO aboutUsPageDTO = new AboutUsPageDTO();
//			aboutUsPageDTO.setContents("tgrge");
//			aboutUsPageDTO.setSelectedImage("f.jpg");
//			aboutUsPageService.addAboutUsData(aboutUsPageDTO);
//
//			NewsPageDTO newsPageDTO = new NewsPageDTO();
//			newsPageDTO.setCategory("fvfvf");
//			newsPageDTO.setNewsTitle("hhjj");
//			newsPageDTO.setDetails("hhh");
//			newsPageDTO.setSelectedImage("f.jpg");
//			newsPageService.addNewsPageData(newsPageDTO);
//		};
//	}
}

