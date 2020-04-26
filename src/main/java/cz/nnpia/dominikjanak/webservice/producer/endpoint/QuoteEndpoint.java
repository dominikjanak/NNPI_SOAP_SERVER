package cz.nnpia.dominikjanak.webservice.producer.endpoint;

import cz.dominikjanak.webservices.quotes.GetQuoteRequest;
import cz.dominikjanak.webservices.quotes.GetQuoteResponse;
import cz.nnpia.dominikjanak.webservice.producer.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class QuoteEndpoint {
	private static final String NAMESPACE_URI = "http://dominikjanak.cz/webservices/quotes";

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
