package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;

public class CreateAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {
	
	private AvengerDAO dao = new AvengerDAO();
	
	@Override
	public HandlerResponse handleRequest(final Avenger newAvenger, final Context context) {
		
		Avenger createdAvenger = null;
		
		context.getLogger().log("[#] - Starting Create Avenger ");
		
		createdAvenger = dao.save(newAvenger);
		
		context.getLogger().log("[#] - Avenger Created! ");
		
		
		final HandlerResponse reponse = HandlerResponse.builder().setObjectBody(createdAvenger).build();
		
		
		return reponse;

	}
}
