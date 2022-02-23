import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.liuep.droolsGlobal.entities.EntityForSubsection;
import org.liuep.droolsGlobal.services.ServiceForSubsection;

import java.util.ArrayList;
import java.util.Random;

public class LiuepTest {

    @Test
    public void test1(){
        //获得kie服务和容器
        KieServices kieService = KieServices.Factory.get();
        KieContainer kieContainer = kieService.newKieClasspathContainer();

        //获得无状态会话
        StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("statelessSession");

        //获得fact输入工具实例
        EntityForSubsection entityForSubsection = new EntityForSubsection();

        //获得中间数据存储的服务
        ServiceForSubsection serviceForSubsection = new ServiceForSubsection(1);

        //设置规则RuleForSubsection里声明的全局变量
        statelessKieSession.setGlobal("serviceForSubsection",serviceForSubsection);

        //获得随机数生成器
        Random random = new Random();

        int intRandom = 0;

        for(int i = 0 ; i < 10000 ; i++){

            //获得一个模5000的正整数
            intRandom = random.nextInt() % 5000;
            if(intRandom < 0) intRandom += 5000;

            //给fact添加数据
            entityForSubsection.setNum(intRandom + 0d);

            //执行规则引擎
            statelessKieSession.execute(entityForSubsection);
        }

        //从服务serviceForSubsection里取得中间过程数据
        ArrayList<Double> listBefore = serviceForSubsection.getListBefore();
        ArrayList<Double> listAfter = serviceForSubsection.getListAfter();

        //输出执行前后的数据
        for(int i = 0 ; i < 10000 && i < listAfter.size() ; i++){
            System.out.println("rownum: " + (i + 1)
                               + "\t |beforeExecute: " + listBefore.get(i)
                               + "\t |afterExecute: "  + listAfter.get(i)  );
        }
    }
}
