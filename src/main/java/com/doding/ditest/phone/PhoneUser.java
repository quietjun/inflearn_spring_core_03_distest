package com.doding.ditest.phone;

public class PhoneUser {
    SmartPhone phone; // has a 관계 - 의존성

    public PhoneUser(SmartPhone phone) { // 생성자를 통한 주입
        // this.phone = new SPhone();
        this.phone = phone;
    }

    public void setPhone(SmartPhone phone) { // setter를 통한 주입
        this.phone = phone;
    }

    public void usePhone() {
        System.out.println(phone + "으로 통화한다.");
    }
}
