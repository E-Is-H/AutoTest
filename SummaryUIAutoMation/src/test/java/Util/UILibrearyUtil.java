package Util;

import Entity.PageEntity;
import Entity.UIElement;
import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogReader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UILibrearyUtil {

    public static List<PageEntity> pages =new ArrayList<PageEntity>();

    /**
     * 加载uil库
     */
    static {
        try {
            loadPages(ReadPropertiesUtil.getprop("Paths", "UILbraryPath"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析uli库,xml
     * @param uilpath  xml路径
     */
    private static void loadPages(String uilpath) {
        // 解析xml
        // 获取解析器
        SAXReader reader=new SAXReader();
        InputStream inputStream=null;
        // 拿到Document对象
        try {
            inputStream=new FileInputStream(new File(uilpath));
            Document document=  reader.read(inputStream);
            // 获取根节点
            Element element=document.getRootElement();
            // 获取page xml数据
            List<Element> pageElement=element.elements("page");
            //循环处理每一个page
            for (Element pageElements:pageElement){
                String pagekeyword=pageElements.attributeValue("keyword");
                // 获取page 元素的《UILElement》保存起来
                List<Element> uiElements=pageElements.elements("UIELement");
                // 将每个元素封装成UI类型对象
                List<UIElement> uiElementList=new ArrayList<UIElement>();
                // 循环处理
                for (Element uielement: uiElements){
                   String uiElementkeyword= uielement.attributeValue("keyword");
                    String uiElementby=uielement.attributeValue("by");
                    String uiElementvalue= uielement.attributeValue("value");
                    UIElement uiElement=new UIElement(uiElementkeyword,uiElementby,uiElementvalue);
                    uiElementList.add(uiElement);
                }
                PageEntity pageEntity=new PageEntity(pagekeyword,uiElementList);
                pages.add(pageEntity);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static WebElement getElementByKeyword(String pageKeyword,String uiElementKeyword){
        return null;
    }

}
