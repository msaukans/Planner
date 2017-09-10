package tk.codester.maris.planner;


import android.content.Context;

import java.io.Serializable;

public class Expense implements Serializable{

    String name, cost;


    public Expense(Context context){
        this.name = this.name;
        this.cost = this.cost;
    }

    public Expense(String name, String cost){
        this.name = this.name;
        this.cost = this.cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setCost(String cost) {
        this.cost = cost;
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }
}
