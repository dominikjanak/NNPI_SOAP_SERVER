# Web service - producer
Vypracování semestrální práce na téma Web services - procducer
## Informace
Server nasluchá na adrese https://soap-webservice.herokuapp.com/ws/, kde odbavuje požadavky definované podle WSDL na adrese: https://soap-webservice.herokuapp.com/ws/quotes.wsdl.
### Data:
Klíč (key) pro data je validní v rozmezí 0 - 23
### Vzor Requestu:
**CMD:** 
``
curl --header "content-type: text/xml" -d @request.xml https://soap-webservice.herokuapp.com/ws
``

**URL:** https://soap-webservice.herokuapp.com/ws
#### Text dotazu
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="https://soap-webservice.herokuapp.com/ws/quotes">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getQuoteRequest>
         <gs:key>1</gs:key>
      </gs:getQuoteRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
#### Text odpovědi
```xml
<SOAP-ENV:Envelope
    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getQuoteResponse
            xmlns:ns2="https://soap-webservice.herokuapp.com/ws/quotes">
            <ns2:quote>
                <ns2:id>1</ns2:id>
                <ns2:quote>Většina lidí neopouští společnosti, ale manažery.</ns2:quote>
                <ns2:author>Jonas Ridderstrale</ns2:author>
                <ns2:isPublished>true</ns2:isPublished>
            </ns2:quote>
        </ns2:getQuoteResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## Autor
Dominik Janák