package com.doding.ditest.phone;

import com.doding.ditest.phone.config.PhoneFactory;

public class PhoneTest {
    public static void main(String[] args) {
        PhoneUser user = new PhoneUser(PhoneFactory.getPhone("s"));
        user.usePhone();
        user.setPhone(PhoneFactory.getPhone("l"));
        user.usePhone();
    }
}
