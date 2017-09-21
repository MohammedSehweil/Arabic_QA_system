package com.AQAS.document_retrieval;

public class Website {

    public String searchLink;
    public String pageVariableName;
    public String selector;
    public int searchPageOffset;
    public String contentSelector;



    /**
     *
     * @param searchLink:the link that is used to make the search inside the website
     * @param selector: used to get the div that contains the links of the search result
     * @param pageVariableName: The variable name that is used within the search to specify which page from the search result to use
     * @param searchPageOffset:  is used to determine the start page of a website search results
     *
     */
    public Website(String searchLink, String pageVariableName, String selector, int searchPageOffset,String contentSelector ) {
        this.searchLink = searchLink;
        this.pageVariableName = pageVariableName;
        this.selector = selector;
        this.searchPageOffset = searchPageOffset;
        this.contentSelector = contentSelector;
    }

    @Override
    public String toString() {
        return "Website{" +
                "searchLink='" + searchLink + '\'' +
                ", pageVariableName='" + pageVariableName + '\'' +
                ", selector='" + selector + '\'' +
                ", searchPageOffset=" + searchPageOffset +
                ", contentSelector='" + contentSelector + '\'' +
                '}';
    }
}
