package com.godeltech.mastery.servlet.util;

import java.util.UUID;

public class GenerateUUID {
    public String generateRandomUUID(){
        return UUID.randomUUID().toString();
    }
}
