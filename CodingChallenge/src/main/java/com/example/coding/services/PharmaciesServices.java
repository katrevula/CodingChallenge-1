package com.example.coding.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.coding.model.NearestPharmacy;
import com.example.coding.repositories.PharamaciesRepo;

@Service
public class PharmaciesServices {
	
	@Autowired
	private PharamaciesRepo pharmaciesrepo;
	
	public NearestPharmacy getPharmacies(double latitude, double longitude) {
		NearestPharmacy np= new NearestPharmacy();
		String s= this.pharmaciesrepo.getPharmacy(latitude, longitude).get(0);
		String[] sarray=s.split(",");
		String name=sarray[0].trim();
		String address=sarray[1].trim();
		double distance=Double.parseDouble(String.format("%.2f", Double.parseDouble(sarray[2])));
		np.setName(name);
		np.setAddress(address);
		np.setDistance(distance);
		return np;
	}
}
