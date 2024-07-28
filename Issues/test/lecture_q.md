
## 試験の種類

* 複数画面にまたがった機能について試験する場合、一般的に何試験に分類されるか

* 単体試験、結合試験、総合試験以外にその他の試験について他にどのような種類がありますか？

## 単体試験

* コードを確認せずにテストを設計することを何というか

* ブラックボックステストにおいて、同値分割を行う際
  どういった点を考慮して分割を行うか？

## テストカバレッジ

* 分岐について最低1回は通る様に考慮することを何というか

## 自動化テスト

`src/main/java/com/example/demo/lecture/web/user/UserController.java`
```java
  @RequestMapping(path = "/users", method = RequestMethod.GET)
  public String list(
    @PageableDefault(size = 10) Pageable pageable,
    Model model
  ) {
    var users = userService.findAll(pageable);
    model.addAttribute("users", users);
    return "pages/user/list";
  }
```
上記の`UserController`のlistメソッドについて
下記3種類のテストケースを記載してください。
  * 正しく文字列が返却されている
    (assertEqualsを使用してください)
  * userServiceが呼び出しされている。
    (Mockito.verifyを使用してください)
  * userServiceの引数にpageableが設定されている
    (assertEqualsを使用してください)
解答はsrc配下のtestディレクトリの中にある`UserControllerTests.java`ファイルに記載してください
