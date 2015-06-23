import es.upm.oeg.epnoi.hoarder.AbstractRouteBuilder

class routes extends AbstractRouteBuilder{

    @Override
    public void configure() throws Exception {
        super.configure()

        /*********************************************************************************************************************************
         * ROUTE 1: Slashdot
         *********************************************************************************************************************************/
        from("rss:http://rss.slashdot.org/Slashdot/slashdot?" +
                "splitEntries=true&consumer.initialDelay=1000&consumer.delay=2000" +
                "&feedHeader=false&filter=true").marshal().rss().
                setProperty(SOURCE_NAME,        constant("slashdot")).
                setProperty(SOURCE_URL,         constant("http://rss.slashdot.org/Slashdot/slashdot")).
                to("direct:setCommonRssXpathExpressions").
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 2: UPM
         *********************************************************************************************************************************/
        from("oaipmh://oa.upm.es/perl/oai2?initialDelay=1000&delay=60000").
                setProperty(SOURCE_NAME,        constant("upm")).
                setProperty(SOURCE_URL,         constant("http://oa.upm.es/perl/oai2")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 3: UCM
         *********************************************************************************************************************************/
        from("oaipmh://eprints.ucm.es/cgi/oai2?initialDelay=1000&delay=60000").
                setProperty(SOURCE_NAME,        constant("ucm")).
                setProperty(SOURCE_URL,         constant("http://eprints.ucm.es/cgi/oai2")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:identifier/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 4: SciencePubCo
         *********************************************************************************************************************************/
        from("oaipmh://www.sciencepubco.com/index.php/IJAA/oai?initialDelay=1000&delay=60000").
                setProperty(SOURCE_NAME,        constant("sciencepubco")).
                setProperty(SOURCE_URL,         constant("http://www.sciencepubco.com/index.php/IJAA/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("replace(substring-before(concat(string-join(//oai:metadata/oai:dc/dc:relation/text(),\";\"),\";\"),\";\"),\"view\",\"download\")",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")


        /*********************************************************************************************************************************
         * ROUTE 5: Advances in Applied Economics and Finance
         * http://www.worldsciencepublisher.org/journals/index.php/AAEF/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AAEF/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AAEF")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AAEF/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 6: Advances in Asian Social Science
         * http://www.worldsciencepublisher.org/journals/index.php/AASS/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AASS/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AASS")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AASS/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 7: Advances in Computational Mathematics and its Applications
         * http://www.worldsciencepublisher.org/journals/index.php/ACMA/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/ACMA/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("ACMA")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/ACMA/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")


        /*********************************************************************************************************************************
         * ROUTE 8: Advances in Computer Science and its Applications
         * http://www.worldsciencepublisher.org/journals/index.php/ACSA/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/ACSA/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("ACSA")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/ACSA/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")


        /*********************************************************************************************************************************
         * ROUTE 9: Advances in Digital Multimedia
         * http://www.worldsciencepublisher.org/journals/index.php/ADMM/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/ADMM/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("ADMM")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/ADMM/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 10: Advances in Electrical Engineering Systems
         * http://www.worldsciencepublisher.org/journals/index.php/AEES/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AEES/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AEES")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AEES/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 11: Advances in English Linguistics
         * http://www.worldsciencepublisher.org/journals/index.php/AEL/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AEL/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AEL")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AEL/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")


        /*********************************************************************************************************************************
         * ROUTE 12: Advances in Information Technology and Management
         * http://www.worldsciencepublisher.org/journals/index.php/AITM/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AITM/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AITM")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AITM/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")

        /*********************************************************************************************************************************
         * ROUTE 13: Advances in Intelligent Transportation Systems
         * http://www.worldsciencepublisher.org/journals/index.php/AITS/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/AITS/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("AITS")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/AITS/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")


        /*********************************************************************************************************************************
         * ROUTE 14: Advances in Life Science and its Applications
         * http://www.worldsciencepublisher.org/journals/index.php/ALSA/oai?verb=ListRecords&metadataPrefix=oai_dc
         *********************************************************************************************************************************/
        from("oaipmh://www.worldsciencepublisher.org/journals/index.php/ALSA/oai?initialDelay=1000&delay=60000&from=2012-01-01T00:00:00Z&until=2013-01-01T00:00:00Z").
                setProperty(SOURCE_NAME,        constant("ALSA")).
                setProperty(SOURCE_URL,         constant("http://www.worldsciencepublisher.org/journals/index.php/ALSA/oai")).
                to("direct:setCommonOaipmhXpathExpressions").
                setProperty(PUBLICATION_URL,    xpath("//oai:metadata/oai:dc/dc:relation/text()",String.class).namespaces(ns)).
                to("direct:retrieveByHttpAndSave")



    }

}
