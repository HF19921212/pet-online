package com.frend.online.core.enums;

public enum DemandType {

    PUBLISH_ADOPTION("发布领养", 1),
    PUBLISH_CLUE("发布线索", 2);

    // 成员变量
    private String name;
    private int value;

    private DemandType(String name,int value){
        this.name = name;
        this.value = value;
    }

    public static String getName(int value){
        for(DemandType d : DemandType.values()){
            if(d.value == value){
                return d.name;
            }
        }
        return  null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
