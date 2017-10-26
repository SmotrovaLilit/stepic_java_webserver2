package resourceServer;

import resources.TestResource;
import sax.SaxHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ResourceServer {
    private TestResource testResource;


    public TestResource getTestResource() {
        return testResource;
    }

    public void updateTestResource(String xmlFile) throws Exception {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFile, handler);

            testResource = (TestResource) handler.getObject();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
