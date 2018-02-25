package com.rishab.owner.mt;

/**
 * Created by OWNER on 03-03-2016.
 */
public class RContacts {

    private String name,number,actarr,actdep;

    public RContacts(String name,String number,String actarr,String actdep)
    {
        this.setName(name);
        this.setNumber(number);
        this.setActarr(actarr);
        this.setActdep(actdep);


    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
