package com.doding.ditest.phone.config;

import com.doding.ditest.phone.LPhone;
import com.doding.ditest.phone.SPhone;
import com.doding.ditest.phone.SmartPhone;

public class PhoneFactory {
    public static SmartPhone getPhone(String maker) {
        if (maker.equalsIgnoreCase("s")) {
            return new SPhone();
        } else {
            return new LPhone();
        }
    }
}
