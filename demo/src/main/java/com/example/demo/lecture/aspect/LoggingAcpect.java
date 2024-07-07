package com.example.demo.lecture.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAcpect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("within(com.example.demo.lecture.web.*.*)")
  public void StartLog(JoinPoint jp) {
    logger.info("メソッド開始 : " + jp.getSignature());
  }

  @After("within(com.example.demo.lecture.web.*)")
  public void EndLog(JoinPoint jp) {
    logger.info("メソッド終了 : " + jp.getSignature());
  }
}
