
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {
	
	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);
	
	//@Query("select a from Application a")
	//Collection<Application> findManyApplication();
	
	@Query("select a from Entrepreneur a where a.id = ?1")
	Entrepreneur findEntrepreneurById(int id);
	
	//@Query("select a from Application a where a.investmentRound.id = ?1 and a.entrepreneur.id = ?2")
	//Collection<Application> findManyByEntrepreneurIdAndInvestmentRoundId(int investmentRoundId, int entrepreneurId);

	@Query("select a from Application a where a.entrepreneur.id = ?1")
	Collection<Application> findManyByEntrepreneurIdAndInvestmentRoundId(int entrepreneurId);
	
	
	
}
