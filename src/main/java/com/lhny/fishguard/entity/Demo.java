package com.lhny.fishguard.entity;

import java.io.Serializable;

/**
 * Created by panzhichao on 2017/12/5.
 */
public class Demo implements Serializable {
    private String wd1;

    private String wd2;

    private String wd3;

    private String wd4;

    private String wd5;

    private String wd6;

    private String wd7;

    public String getWd1() {
        return wd1;
    }

    public void setWd1(String wd1) {
        this.wd1 = wd1;
    }

    public String getWd2() {
        return wd2;
    }

    public void setWd2(String wd2) {
        this.wd2 = wd2;
    }

    public String getWd3() {
        return wd3;
    }

    public void setWd3(String wd3) {
        this.wd3 = wd3;
    }

    public String getWd4() {
        return wd4;
    }

    public void setWd4(String wd4) {
        this.wd4 = wd4;
    }

    public String getWd5() {
        return wd5;
    }

    public void setWd5(String wd5) {
        this.wd5 = wd5;
    }

    public String getWd6() {
        return wd6;
    }

    public void setWd6(String wd6) {
        this.wd6 = wd6;
    }

    public String getWd7() {
        return wd7;
    }

    public void setWd7(String wd7) {
        this.wd7 = wd7;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "wd1='" + wd1 + '\'' +
                ", wd2='" + wd2 + '\'' +
                ", wd3='" + wd3 + '\'' +
                ", wd4='" + wd4 + '\'' +
                ", wd5='" + wd5 + '\'' +
                ", wd6='" + wd6 + '\'' +
                ", wd7='" + wd7 + '\'' +
                '}';
    }
}
