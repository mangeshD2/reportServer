package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.EligibilityDetails;
import in.ashokit.repo.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibilityDetails entity = new EligibilityDetails();
		entity.setEligId(1);
		entity.setName("Mangesh");
		entity.setMobile(9764333469l);
		entity.setGender('M');
		entity.setSsn(181818181818l);
		entity.setPlanName("SNAP");
		entity.setPlanStatus("Approved");

		repo.save(entity);

		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(2);
		entity1.setName("Sagar");
		entity1.setMobile(97643363469l);
		entity1.setGender('M');
		entity1.setSsn(1818185181818l);
		entity1.setPlanName("CCAP");
		entity1.setPlanStatus("Denied");

		repo.save(entity1);

	}

}
