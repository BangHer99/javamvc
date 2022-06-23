package santri.dto;

public class SearchFromData {

    private String keyword;

    public SearchFromData() {

    }

    public SearchFromData(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
