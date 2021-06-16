
import Util.CaseUtil;
import org.testng.annotations.DataProvider;

import java.lang.reflect.InvocationTargetException;

public class RechargeCase {
    @DataProvider
    public  Object[][] datas(){

        String cellName[]={"CaseId","ApiId","TestData"};
        try {
            Object[][]  datas= CaseUtil.getCaseDatasByapId("2", cellName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }


}
