# 이도원 학번 201840126

### 3월 29일 강의
스캐너와 연산자등 자바 기본프로그래밍
## 3월 22일 강의
자바의 특성

플랫폼 독립성
하드웨어, 운영체제에 종속되지 않는 바이트 코드로 플랫폼 독립성

객체지향
캡슐화, 상속, 다형성 지원

클래스로 캡슐화
자바의 모든 변수나 함수는 클래스 내에 선언
클래스 안에서 클래스(내부 클래스) 작성 가능

소스(.java)와 클래스(.class) 파일
하나의 소스 파일에 여러 클래스를 작성 가능

public 클래스는 하나만 가능
소스 파일의 이름과 public으로 선언된 클래스 이름은 같아야 함
클래스 파일에는 하나의 클래스만 존재 다수의 클래스를 가진 자바 소스를 컴파일하면 클래스마다 별도 클래스 파일 생성


자바의 특징
실행 코드 배포

구성
한 개의 class 파일 또는 다수의 class 파일로 구성
여러 폴더에 걸쳐 다수의 클래스 파일로 구성된 경우 : jar 압축 파일로 배포

자바 응용프로그램의 실행은 main() 메소드에서 시작
하나의 클래스 파일에 두 개 이상의 main() 메소드가 있을 수 없음
각 클래스 파일이 main() 메소드를 포함하는 것은 상관없음

패키지
서로 관련 있는 여러 클래스를 패키지로 묶어 관리
패키지는 폴더 개념
예) java.lang.System은 java\lang 디렉터리의 System.class 파일

멀티스레드
여러 스레드의 동시 수행 환경 지원
자바는 운영체제의 도움 없이 자체적으로 멀티스레드 지원
C/C++ 프로그램은 멀티스레드를 위해 운영체제 API를 호출

가비지 컬렉션
자바 언어는 메모리 할당 기능은 있어도 메모리 반환 기능 없음
사용하지 않는 메모리는 자바 가상 기계에 의해 자동 반환 – 가비지 컬렉션

실시간 응용프로그램에 부적합
실행 도중 예측할 수 없는 시점에 가비지 컬렉션 실행 때문
응용프로그램의 일시적 중단 발생

자바 프로그램은 안전
타입 체크 엄격
물리적 주소를 사용하는 포인터 개념 없음

프로그램 작성 쉬움
포인터 개념이 없음
동적 메모리 반환 하지 않음
다양한 라이브러리 지원

실행 속도 개선을 위한 JIT 컴파일러 사용
자바는 바이트 코드를 인터프리터 방식으로 실행
기계어가 실행되는 것보다 느림
JIT 컴파일 기법으로 실행 속도 개선
JIT 컴파일 - 실행 중에 바이트 코드를 기계어 코드로 컴파일하여 기계어를 실행하는 기법
## 3월 15일 강의
내용 정리