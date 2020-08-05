package acme.features.entrepreneur.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.challenges.Challenge;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurApplicationShowService implements AbstractShowService<Entrepreneur, Application> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	EntrepreneurApplicationRepository repository;

	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return request.getPrincipal().hasRole(Entrepreneur.class);
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,  "ticker", "moment", "statement", "moneyOffer");
	}
	
}
