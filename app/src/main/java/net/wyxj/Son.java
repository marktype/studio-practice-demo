package net.wyxj;

public class Son extends Papa{

    public Son(String fname,int money){
        super(fname,money);
        System.out.println(fname+"先生的儿子出生了。");
        System.out.println(fname+"先生的儿子有"+money+"元财产！");
        setMoney(money+10);
        System.out.println(fname+"先生的儿子的财产增加了，现在有"+(money+10)+"元财产！");
    }
}