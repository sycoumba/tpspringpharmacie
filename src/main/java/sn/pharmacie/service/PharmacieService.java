package sn.pharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.pharmacie.dao.Ipharmacie;
import sn.pharmacie.entities.Pharmacie;

@RestController
public class PharmacieService {

	@Autowired
	private Ipharmacie pharmaciedao;
	@RequestMapping(value = "/liste/pharmacie",method = RequestMethod.GET)
	public List<Pharmacie>getAll(){
		return pharmaciedao.findAll();		
	}
	@RequestMapping(value = "/liste/pharmacie/{ville}",method = RequestMethod.GET)
	public List<Pharmacie>getAllPharmacieByVille(@PathVariable String ville){
		return pharmaciedao.getAllPharmacieByVille(ville);
	}
	@RequestMapping(value = "/liste/pharmacie/{quartier}",method = RequestMethod.GET)
	public List<Pharmacie>getAllPharmacieByQartier(@PathVariable String quartier){
		return pharmaciedao.getAllPharmacieByVille(quartier);
	}
	@RequestMapping(value = "/liste/pharmacie/delete/{id}",method = RequestMethod.DELETE)
	public List<Pharmacie> delete (@PathVariable int id){
		if(pharmaciedao.getById(id) !=null) {
		 pharmaciedao.delete(pharmaciedao.getById(id));
		}
		 return pharmaciedao.findAll();
}
	@RequestMapping(value = "/liste/pharmacie/save",method = RequestMethod.POST)
	public List<Pharmacie>save(Pharmacie pharmacie){
		pharmaciedao.save(pharmacie);
		return pharmaciedao.findAll();
	}
	@RequestMapping(value = "/liste/pharmacie/update/{id}",method = RequestMethod.PUT)
	public List<Pharmacie> update(@PathVariable int id, Pharmacie pharmacie){
		pharmacie.setId(id);
		pharmaciedao.save(pharmacie);
		return pharmaciedao.findAll();
	}
}
