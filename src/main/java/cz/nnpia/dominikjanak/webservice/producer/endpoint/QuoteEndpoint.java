package cz.nnpia.dominikjanak.webservice.producer.endpoint;

import cz.nnpia.dominikjanak.webservice.producer.repository.QuoteRepository;
import https.soap_webservice_herokuapp_com.ws.quotes.GetQuoteRequest;
import https.soap_webservice_herokuapp_com.ws.quotes.GetQuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class QuoteEndpoint {
	private static final String NAMESPACE_URI = "https://soap-webservice.herokuapp.com/ws/quotes";

	private QuoteRepository quoteRepository;

	@Autowired
	public QuoteEndpoint(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getQuoteRequest")
	@ResponsePayload
	public GetQuoteResponse getQuote(@RequestPayload GetQuoteRequest request) {
		GetQuoteResponse response = new GetQuoteResponse();
		response.setQuote(quoteRepository.findQuote(request.getKey()));
		return response;
	}
}
