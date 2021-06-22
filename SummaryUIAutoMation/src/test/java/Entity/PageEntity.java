package Entity;

import java.util.List;

public class PageEntity {

    private String keyword;
    private List<UIElement> uiElementList;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<UIElement> getUiElementList() {
        return uiElementList;
    }

    public void setUiElementList(List<UIElement> uiElementList) {
        this.uiElementList = uiElementList;
    }

    public PageEntity(String keyword, List<UIElement> uiElementList) {
        this.keyword = keyword;
        this.uiElementList = uiElementList;
    }

    public PageEntity() {
    }
}
