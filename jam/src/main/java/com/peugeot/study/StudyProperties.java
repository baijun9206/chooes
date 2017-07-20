package com.peugeot.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 学习spring boot 配置参数
 * Created by dx0001 on 2017/7/19.
 */
@Component
public class StudyProperties {

    @Value("${study.name}")
    private String name;

    @Value("${study.game}")
    private String game;

    @Value("${study.desc}")
    private String desc;

    @Value("${study.value}")
    private String value;

    @Value("${study.bigNumber}")
    private Long bigNumber;

    @Value("${study.number}")
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(Long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
