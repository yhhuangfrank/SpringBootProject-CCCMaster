package com.ispan.CCCMaster.service;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
