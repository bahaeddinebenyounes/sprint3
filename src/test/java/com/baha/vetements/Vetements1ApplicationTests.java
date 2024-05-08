package com.baha.vetements;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.baha.vetements.entities.Type;
import com.baha.vetements.entities.Vetement;
import com.baha.vetements.repos.VetementRepository;
import com.baha.vetements.service.VetementService;

@SpringBootTest
class Vetements1ApplicationTests {

	@Autowired
	private VetementRepository vetementRepository;
	private VetementService vetementService;
	@Test
	public void testCreateVetement() {
	Vetement vet = new Vetement("chaussure Nike",200.123,new Date());
	vetementRepository.save(vet);
	}
	
	@Test
	public void testFindVetement()
	{ Vetement p =vetementRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateVetement()
	{ Vetement p = vetementRepository.findById(6L).get();
	p.setPrixVetement(1000.0); vetementRepository.save(p);
	}
	@Test
	public void testDeleteVetement()
	{ vetementRepository.deleteById(9L);
	}
	
	@Test
	public void testListerTousVetements()
	{
	List<Vetement> vets = vetementRepository.findAll();
	for (Vetement p : vets)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomVetementContains ()
	{
	List<Vetement> prods=vetementRepository.findByNomVetementContains("I");
	for (Vetement p : prods)
	{
	System.out.println(p);
	} }
	@Test
	public void testFindByNomVetement()
	{
	List<Vetement> vets = vetementRepository.findByNomVetement("Imprimante Epson");
	for (Vetement p : vets)
	{
	System.out.println(p);
	}
	}
	@Test 
	public void testfindByNomPrix()
	{
	List<Vetement> vets = vetementRepository.findByNomPrix("chaussure Nike", 200.123);
	for (Vetement p : vets)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByType()
	{
	Type cat = new Type();
	cat.setIdCat(1L);
	List<Vetement> prods = vetementRepository.findByType(cat);
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByTypeIdType()
	{
	List<Vetement> prods = vetementRepository.findByTypeIdType(1L);
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
}
	@Test
	public void testfindByOrderByNomVetementAsc()
	{
	List<Vetement> prods = vetementRepository.findByOrderByNomVetementAsc();
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
	}
	@Test public void testTrierProduitsNomsPrix()
	{
	List<Vetement> prods = vetementRepository.trierVetementsNomsPrix();
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
	}
}
