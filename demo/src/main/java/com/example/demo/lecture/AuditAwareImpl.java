package com.example.demo.lecture;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    // 暫定で固定値を返却
    // ログイン機能実装後は、ログインしているユーザーを返却する
    return Optional.of("ユーザー1");
  }
}
