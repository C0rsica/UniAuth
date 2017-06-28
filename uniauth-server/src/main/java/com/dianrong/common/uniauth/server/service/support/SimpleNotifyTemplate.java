package com.dianrong.common.uniauth.server.service.support;

import com.dianrong.common.uniauth.common.util.Assert;

/**
 * 消息发送的模板.
 */
public class SimpleNotifyTemplate implements NotifyTemplate {
  
  private static final String NOTIFICATION_TITLE = "Uniauth系统通知";
  
  private final String emailTitle;
  
  private final String emailTemplate;
  
  private final String smsTemaplate;
  
  public SimpleNotifyTemplate(String emailTemplate, String smsTemaplate) {
    this(NOTIFICATION_TITLE, emailTemplate, smsTemaplate);
  }
  
  public SimpleNotifyTemplate(String emailTitle, String emailTemplate, String smsTemaplate) {
    Assert.notNull(emailTitle);
    Assert.notNull(emailTemplate);
    Assert.notNull(smsTemaplate);
    this.emailTitle = emailTitle;
    this.emailTemplate = emailTemplate;
    this.smsTemaplate = smsTemaplate;
  }
  
  @Override
  public String getEmailTitle(Object... args) {
    return String.format(this.emailTitle, args);
  }
  
  @Override
  public String getEmailNotifyMsg(Object... args) {
    return String.format(this.emailTemplate, args);
  }
  
  @Override
  public String getSmsNotifyMsg(Object... args) {
    return String.format(this.smsTemaplate, args);
  }

  @Override
  public String getSmsTitle(Object... args) {
    return "";
  }
}
