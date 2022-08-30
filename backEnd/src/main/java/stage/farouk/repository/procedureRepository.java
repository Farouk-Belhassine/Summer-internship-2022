package stage.farouk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.Proc;

import java.util.List;

@Repository
public interface procedureRepository extends CrudRepository<Proc, Long> {

    @Query("SELECT new Proc(p.id, p.name) FROM Proc p")
    List<Proc> getAllProceduresNoSeq();

    /*
	@Modifying
	@Query("update Client c set c.categorieClient = ?1 where c.profession =?2")
	int updateClientCategorieByProfession( CategorieClient categorieClient, Profession profession);

	@Modifying
	@Query("DELETE FROM Client c WHERE c.categorieClient= ?1 AND c.profession = ?2")
	int deleteClientByCategorieClientAndProfession(CategorieClient categorieClient, Profession profession);

	@Modifying
	@Query(value = "INSERT INTO Client (nom, prenom,dateNaissance,email,password,profession,categorieClient) VALUES (:nom,:prenom, :dateN, :email, :password, :profession, :categorieClient)",nativeQuery = true)
	void insertClient(@Param("nom") String nom, @Param("prenom") String prenom, @Param("dateN") Date dateNaissance, @Param("email") String email,@Param("password") String password, @Param("profession") Profession profession, @Param("categorieClient") CategorieClient categorieClient);
	*/
}