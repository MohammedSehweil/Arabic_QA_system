package com.AQAS.document_retrieval;

public class Website {

    public String searchLink;
    public String pageVariableName;
    public String selector;
    public int searchPageOffset;
    public boolean isRelativeLinks;



    /**
     *
     * @param searchLink:the link that is used to make the search inside the website
     * @param selector: used to get the div that contains the links of the search result
     * @param pageVariableName: The variable name that is used within the search to specify which page from the search result to use
     * @param searchPageOffset:  is used to determine the start page of a website search results
     * @param isRelativeLinks:Specify tif the retrieved links from the search results either full links[ex: webteb] or links relative to the website[ex: doctoore]
     *
     */
    public Website(String searchLink, String pageVariableName, String selector, int searchPageOffset ,boolean isRelativeLinks) {
        this.searchLink = searchLink;
        this.pageVariableName = pageVariableName;
        this.selector = selector;
        this.searchPageOffset = searchPageOffset;
        this.isRelativeLinks = isRelativeLinks;
    }

    @Override
    public String toString() {
        return "Website{" +
                "searchLink='" + searchLink + '\'' +
                ", pageVariableName='" + pageVariableName + '\'' +
                ", selector='" + selector + '\'' +
                ", isRelativeLinks=" + isRelativeLinks +
                '}';
    }
}
