package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;

public class SearchAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {

	private AvengerDAO dao = new AvengerDAO();
	
	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {
		
		context.getLogger().log("[#] - Starting avanger by id: "+ avenger.getId());
		
		final Avenger avengerFound = dao.search(avenger.getId());
		
		final HandlerResponse reponse = HandlerResponse.builder().setObjectBody(avengerFound).build();
		
		context.getLogger().log("[#] - Avenger Found!");
		
		return reponse;
	}
}
