package org.liuep.droolsGlobal.services;

import java.util.ArrayList;

public class ServiceForSubsection {
    //用以记录符合条件的fact数量
    private int count;
    //用以储存折换过的数据
    private ArrayList<Double> listAfter = new ArrayList<Double>();
    //用以储存非折换过的数据
    private ArrayList<Double> listBefore = new ArrayList<Double>();

    //该构造方法用以输入Count初始值
    public ServiceForSubsection(int num){
        this.count = num;
    }

    //该方法用以向listAfter里填入数据
    public void addAfterElement(double num){
        this.listAfter.add(num);
    }

    //该方法用以向listBefore里填入数据
    public void addBeforeElement(Double num){
        this.listBefore.add(num);
    }

    //该方法用以获得listAfter
    public ArrayList<Double> getListAfter() {
        return listAfter;
    }

    //该方法用以获得listBefore
    public ArrayList<Double> getListBefore(){
        return listBefore;
    }

    //该方法用以获得Count值
    public int getCount() {
        return count;
    }

    //该方法用以自增count
    public void execute(){
        this.count += 1;
    }

}
