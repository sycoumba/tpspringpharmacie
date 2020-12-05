package sn.pharmacie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.pharmacie.entities.Pharmacie;

@Repository
public interface Ipharmacie extends JpaRepository<Pharmacie, Integer>{

	@Query("SELECT P FROM Pharmacie P WHERE P.ville = :ville")
	public List<Pharmacie>getAllPharmacieByVille(@Param("ville")String ville);
	@Query("SELECT P FROM Pharmacie P WHERE P.quartier = :quartier")
	public List<Pharmacie>getAllPharmacieByQuartier(@Param("quartier") String quartier);
	@Query("SELECT P FROM Pharmacie P WHERE P.id = :id")
	public Pharmacie getById(@Param("id") int id);
}
