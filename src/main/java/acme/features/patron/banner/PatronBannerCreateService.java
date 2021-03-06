
package acme.features.patron.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.roles.Patron;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service

public class PatronBannerCreateService implements AbstractCreateService<Patron, Banner> {

	@Autowired
	PatronBannerRepository repository;


	@Override
	public boolean authorise(final Request<Banner> request) {

		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Banner> request, final Banner entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "patron");
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "picture", "slogan", "url", "holderName", "number", "brand", "monthExpiration", "yearExpiration", "cvv");
	}

	@Override
	public Banner instantiate(final Request<Banner> request) {
		
		Banner result;
		result = new Banner();
		
		Patron p;
		p = this.repository.findPatronById(request.getPrincipal().getActiveRoleId());
		result.setPatron(p);
		
		return result;
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Banner> request, final Banner entity) {

		this.repository.save(entity);
	}

}
