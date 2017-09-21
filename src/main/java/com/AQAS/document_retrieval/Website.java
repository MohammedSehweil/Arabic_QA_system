package com.AQAS.document_retrieval;

public class Website {

    public String searchLink;
    public String pageVariableName;
    public String selector;
    public String regex;
    public boolean isRelativeLinks;



    /**
     *
     * @param searchLink:the link that is used to make the search inside the website
     * @param selector: used to get the div that contains the links of the search result
     * @param regex: Used to extract the final links from the div
     * @param pageVariableName: The variable name that is used within the search to specify which page from the search result to use
     * @param isRelativeLinks:Specify tif the retrieved links from the search results either full links[ex: webteb] or links relative to the website[ex: doctoore]
     *
     */
    public Website(String searchLink, String pageVariableName, String selector, String regex, boolean isRelativeLinks) {
        this.searchLink = searchLink;
        this.pageVariableName = pageVariableName;
        this.selector = selector;
        this.regex = regex;
        this.isRelativeLinks = isRelativeLinks;
    }

    @Override
    public String toString() {
        return "Website{" +
                "searchLink='" + searchLink + '\'' +
                ", pageVariableName='" + pageVariableName + '\'' +
                ", selector='" + selector + '\'' +
                ", regex='" + regex + '\'' +
                ", isRelativeLinks=" + isRelativeLinks +
                '}';
    }
}
