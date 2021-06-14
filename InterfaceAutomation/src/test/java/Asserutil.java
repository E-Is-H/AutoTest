import com.sun.org.apache.xpath.internal.objects.XString;
import org.testng.Assert;

public class Asserutil {
    /**
     *
     * @param AxtualResponseData     实际结果
     * @param ExpectedResponseData   预期结果
     */
    public  static String assertEquals(String ExpectedResponseData,String AxtualResponseData){
        String result="通过";
        try{
            // 判断预期解雇和实际结果是否一致，不一致回抛出异常，进入catch中
            Assert.assertEquals(ExpectedResponseData, AxtualResponseData);
        }catch (Throwable e){
            // 结果就返回 AxtualResponseData
            result=AxtualResponseData;

            /*
            result="失败";
             */
        }
           return result;
    }

}
