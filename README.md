# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## Features

### 1. Game Generation
- 세자리 숫자를 생성한다.
  - 이때, 세 숫자는 모두 1 ~ 9 범위의 숫자로 이루어져야 하며, 각 숫자는 중복을 허용하지 않는다.
- Player는 정답을 입력한다.

### 2. Player Input
- Player는 임의의 세자리 숫자를 입력할 수 있다.
- 잘못된 형식이나 잘못된 값을 입력했을 때, IllegalArgumentException을 발생시키고 Game은 종료된다.
  - 입력된 값이 숫자가 아닐 때.
  - 입력된 값이 범위를 초과할 때. (세 자리 숫자가 아닐 때 & 0이 입력되었을 때)
  - 입력된 값에 중복이 있을 때.

### 3. Judgement
- Player가 입력한 숫자와 생성된 Game의 숫자를 비교한다.
  - Strike 조건
    - 위치와 숫자가 모두 동일한 경우.
  - Ball 조건
    - 숫자가 있지만 위치가 틀린 경우.
- Strike와 Ball의 개수를 반환한다.
  - Strike와 Ball이 모두 0일 때 '낫싱'으로 처리한다.

### 4. Game Result
- Judgement의 결과를 처리한다.
- Strike의 개수가 3개일 때 정답으로 처리한다.
  - 그 외의 경우는 모두 오답이고 계속 Player의 입력을 처리할 수 있다.

### 5. Game Over or Replay
- Game Result가 정답이면 Game이 종료된다.
- Player에게 다시 시작 혹은 종료의 옵션을 제공한다.
  - Player가 1 입력시 Game은 다시 시작되어야 한다.
  - Player가 2 입력시 Game은 즉시 종료되어야 한다.

---

### Project Shortcuts
- [PR Destination Repository](https://github.com/next-step/java-baseball-precourse)
- [Commit Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- [Java Convention](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- [Pre-course Guide](https://github.com/next-step/nextstep-docs/tree/master/precourse)
- [Submission Form](https://docs.google.com/forms/d/e/1FAIpQLSdoJ_IgpluMAmzRt626e4zgm_SikX8u9KJluC2heOTuftRqOA/viewform)
