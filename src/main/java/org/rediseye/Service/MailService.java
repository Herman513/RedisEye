package org.rediseye.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Date: 2016/12/28 下午1:07
 * Usage:
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
}
