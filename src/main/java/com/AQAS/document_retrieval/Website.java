package com.AQAS.document_retrieval;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Website {

    public String websiteName;
    public String searchLink;
    public String pageVariableName;
    public String selector;
    public int searchPageOffset;
    public String contentSelector;



    /**
     *
     * @param websiteName:the website's name
     * @param searchLink:the link that is used to make the search inside the website
     * @param selector: used to get the div that contains the links of the search result
     * @param pageVariableName: The variable name that is used within the search to specify which page from the search result to use
     * @param searchPageOffset:  is used to determine the start page of a website search results
     *
     */
    public Website(String websiteName,String searchLink, String pageVariableName, String selector, int searchPageOffset,String contentSelector ) {
        this.websiteName = websiteName;
        this.searchLink = searchLink;
        this.pageVariableName = pageVariableName;
        this.selector = selector;
        this.searchPageOffset = searchPageOffset;
        this.contentSelector = contentSelector;
    }

    @Override
    public String toString() {
        return "Website{" +
                "websiteName='" + websiteName + '\'' +
                ", searchLink='" + searchLink + '\'' +
                ", pageVariableName='" + pageVariableName + '\'' +
                ", selector='" + selector + '\'' +
                ", searchPageOffset=" + searchPageOffset +
                ", contentSelector='" + contentSelector + '\'' +
                '}';
    }

    public String generateSearchLink(String searchQuery,int pageNumber) throws UnsupportedEncodingException {
        return String.format(this.searchLink,URLEncoder.encode(searchQuery, "UTF-8"),pageNumber);
    }
}

class DailyMedicalInfoWebsite extends Website{

    /**
     * @param websiteName      :the website's name
     * @param searchLink       :the link that is used to make the search inside the website
     * @param pageVariableName : The variable name that is used within the search to specify which page from the search result to use
     * @param selector         : used to get the div that contains the links of the search result
     * @param searchPageOffset :  is used to determine the start page of a website search results
     * @param contentSelector
     */
    public DailyMedicalInfoWebsite(String websiteName, String searchLink, String pageVariableName, String selector, int searchPageOffset, String contentSelector) {
        super(websiteName, searchLink, pageVariableName, selector, searchPageOffset, contentSelector);

    }
    public String generateSearchLink(String searchQuery,int pageNumber) throws UnsupportedEncodingException {
        return String.format(this.searchLink,pageNumber,URLEncoder.encode(searchQuery, "UTF-8"));
    }
}
