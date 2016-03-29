package ua.dborisenko.kickstarter.view;

public abstract class View {
    private static final String APP_TITLE = "Kickstarter";
    protected String pageTitle;
    protected StringBuilder content = new StringBuilder();

    protected String getHeaderBlock() {
        StringBuilder block = new StringBuilder();
        block.append("<!DOCTYPE html>\n");
        block.append("<head>\n");
        block.append("<title>" + APP_TITLE + ": " + pageTitle + "</title>\n");
        block.append("</head>\n");
        block.append("<body>\n");
        block.append("<h1>" + APP_TITLE + "</h1>\n");
        block.append("<h2>" + pageTitle + "</h2>\n<hr>\n");
        return block.toString();
    };

    protected String getFooterBlock() {
        StringBuilder block = new StringBuilder();
        block.append("<hr>\n");
        block.append("</body>\n");
        block.append("</html>\n");
        return block.toString();
    };

    protected void addContentString(String inputString) {
        this.content.append(inputString + "\n");
    }

}