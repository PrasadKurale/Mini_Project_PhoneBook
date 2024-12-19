package in.ashokit.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.binding.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataInserter implements ApplicationRunner {

	@Autowired
	CitizenPlanRepository citizenPlanRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		CitizenPlan citizenPlan1 = new CitizenPlan();

		citizenPlan1.setCname("John");
		citizenPlan1.setGender("male");
		citizenPlan1.setCemail("xyz@gmail.com");
		citizenPlan1.setPhoneNumber(66555666l);
		citizenPlan1.setPlanName("SNAP");
		citizenPlan1.setPlanStatus("Approved");
		citizenPlan1.setSsn(85855555l);

		CitizenPlan citizenPlan2 = new CitizenPlan();

		citizenPlan2.setCname("charlee");
		citizenPlan2.setGender("male");
		citizenPlan2.setCemail("abc@gmail.com");
		citizenPlan2.setPhoneNumber(64664464l);
		citizenPlan2.setPlanName("SNAP");
		citizenPlan2.setPlanStatus("Denied");
		citizenPlan2.setSsn(85855555l);

		CitizenPlan citizenPlan3 = new CitizenPlan();

		citizenPlan3.setCname("Jioan");
		citizenPlan3.setGender("fe-male");
		citizenPlan3.setCemail("cde@gmail.com");
		citizenPlan3.setPhoneNumber(74744555l);
		citizenPlan3.setPlanName("CCAP");
		citizenPlan3.setPlanStatus("Approved");
		citizenPlan3.setSsn(9698555l);

		CitizenPlan citizenPlan4 = new CitizenPlan();

		citizenPlan4.setCname("Mangla");
		citizenPlan4.setGender("fe-male");
		citizenPlan4.setCemail("mang@gmail.com");
		citizenPlan4.setPhoneNumber(74744555l);
		citizenPlan4.setPlanName("CCAP");
		citizenPlan4.setPlanStatus("Denied");
		citizenPlan4.setSsn(9698555l);

		List<CitizenPlan> asList = Arrays.asList(citizenPlan1, citizenPlan2, citizenPlan3, citizenPlan4);
		citizenPlanRepository.saveAll(asList);
	}

}
