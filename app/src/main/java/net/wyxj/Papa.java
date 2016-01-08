package net.wyxj;

public class Papa {
    private String first_name;
    private int money;

    public Papa(String fname,int money){
        this.first_name=fname;
        this.money=money;
        System.out.println(fname+"先生出生了。");
        System.out.println(fname+"先生有"+money+"元财产！");
    }
    public String getFirst_name() {    return first_name;}
    public void setFirst_name(String first_name) {    this.first_name = first_name;}
    public int getMoney() {    return money;}
    public void setMoney(int money) {this.money = money;}

}
