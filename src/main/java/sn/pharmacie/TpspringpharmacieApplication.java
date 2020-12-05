package sn.pharmacie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.pharmacie.dao.Ipharmacie;
import sn.pharmacie.entities.Pharmacie;

@SpringBootApplication
public class TpspringpharmacieApplication implements CommandLineRunner {

	@Autowired
	private Ipharmacie pharmaciedao;
	public static void main(String[] args) {
		SpringApplication.run(TpspringpharmacieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// tester un pharmacie
		Pharmacie pharmacie = new Pharmacie();
		pharmacie.setNom("Kader DIOP");
		pharmacie.setQuartier("Ouagou Niayes");
		pharmacie.setVille("Dakar");
		pharmacie.setEtat(1);
		pharmaciedao.save(pharmacie);
		pharmaciedao.findAll().forEach(p -> System.out.println(p.getVille()));
		
	}

}
