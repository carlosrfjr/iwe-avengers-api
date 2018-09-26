package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;
import com.iwe.avengers.exception.AvengerNotFoundException;

public class UpdateAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {

	private AvengerDAO dao = new AvengerDAO();

	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {
		
		Avenger updatedAvenger = null;
		
		context.getLogger().log("[#] - Starting avanger by id: "+ avenger.getId());
				
		if (dao.search(avenger.getId())!=null) {
			context.getLogger().log("[#] - Avenger Found, updating...");
			updatedAvenger = dao.save(avenger);
			context.getLogger().log("[#] - Avenger updated!");
		} else {
			 throw new AvengerNotFoundException("[NotFound] - Avenger id: "+avenger.getId());
		}
		
		final HandlerResponse reponse = HandlerResponse.builder().setObjectBody(updatedAvenger).build();

		context.getLogger().log("[#] - Avenger updated!");

		return reponse;
	}
}
