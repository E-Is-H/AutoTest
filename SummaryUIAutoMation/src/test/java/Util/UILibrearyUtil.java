package Util;

import Cases.OpenBrowse;
import Entity.PageEntity;
import Entity.UIElement;
import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogReader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.*;
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
                List<Element> uiElements=pageElements.elements("UIElement");
               // 将每个元素封装成UI类型对象
                List<UIElement> uiElementList=new ArrayList<UIElement>();
                // 循环处理
                 for (Element uielement: uiElements){
                   String uiElementkeyword= uielement.attributeValue("keyword");
                    System.out.print(uiElementkeyword);
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
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public static By getElementByKeyword(String pageKeyword,String uiElementKeyword){
        By by=null;
// 取出page对象中的数据
        for(PageEntity page: pages){
// 根据页面关键字，获取Element对象数据
            if(pageKeyword.equals(page.getKeyword())){
                List<UIElement> elementlist =page.getUiElementList();
// 获取elementlist 的值
                for(UIElement element:elementlist){
// 根据uiElementKeyword关键字，获取By与value的值
                    if(uiElementKeyword.equals(element.getKeyword())){
                        String elementBy=element.getBy();
                        String elementvalue=element.getValue();

                        System.out.println(elementBy);
                        /* 封装方法用来判断 by的类型*/
                        by=getVisibleElement(elementBy,elementvalue);


                    }
                }
            }
        }
        return by;
    }

    private static By getVisibleElement(String elementBy, String elementvalue) {



        // 全局变量用来临时储存变量
        By locator=null;


// 判断by的类型 id,name,xpath等
        if("id".equals(elementBy)){
            locator= By.id(elementvalue);
        }else  if (elementBy.equals("name")){
            locator=By.name(elementvalue);
        }else  if (elementBy.equals("xpath")){
            locator=By.xpath(elementvalue);
        }else  if (elementBy.equals("className")){
            locator=By.className(elementvalue);
        }else  if (elementBy.equals("tagName")){
            locator=By.tagName(elementvalue);
        }else  if (elementBy.equals("linkText")){
            locator=By.linkText(elementvalue);
        }else  if (elementBy.equals("partialLinkText")){
            locator=By.partialLinkText(elementvalue);
        }else  if (elementBy.equals("cssSelector")){
            locator=By.cssSelector(elementvalue);
        }else{
            System.out.println("元素定位失败......");
        }

// 判断页面元素是否存在，存在返回WebElement对象，不存在返回null，这里我让他找20秒左右


        return locator;



    }

    public static void main(String[] args) {

        System.out.println(UILibrearyUtil.getElementByKeyword("登录页面","用户名"));

    }

}
