# JAVA study

## 1. Java Virtual Machine
    자바 가상머신.
    자바 바이트 코드를 OS에 특화된 코드로 변환하여 실행.

    jre : java application 실행에 필요한 것들이 모여있는 것으로 jvm, 기본 library를 포함.
    
    jdk : java develop kit 자바 개발이 필요한 것들이 모여있는 것으로 JRE를 포함한 개발툴이 포함.



        1. JVM 구조
        클래스 로더 시스템
        
        로딩
        링크
        초기화
        메모리
        
        - 스택 : 스레드마다 런타임 스택을 만들고 그 안에 메소드 호출을 스택 프레임이라 부르는 믈럭으로 쌓는다. 스레드 종료시 런타임 스택도 사라진다.

        - PC : program counter register : 스레드 마다 스레드 내 현재 실행한 스택 프레임을 가르키는 포인터가 생성.

        - 네이티브 메소드 스택 : 스레드 마다 ~

        - 힙 : 객체 저장. 공유자원

        - 메소드 : 클래스 수준의 정보 (클래스 이름, 부모 클래스 이름, 메소드, 변수) 저장, 공유 자원 실행엔진
        
        - 인터프리터 : 바이트 코드를 한줄씩 실행

        - JIT compiler : 인터프리터 효율을 위해 반복되는 코드를 발견하면 네이티브 코드로 JIT compiler가 네이티브 코드로 변경.

        - JNI javaNativeInterface : 자바 애플리케이션에서 C, C++ 어셈블리로 작성된 함수를 사용할 수 있는 방법 제공
        Native 키워드를 사용한 메소드 호출(native 키워드가 붙은 메소드는 java로 작성되지 않은 것.. 인가? 확인해볼것!!)
        "native" 키워드가 메소드 선언에 사용되면, 해당 메소드의 구현이 Java 소스 코드가 아닌 네이티브 언어로 작성되었음을 의미합니다. 이는 Java Native Interface (JNI)를 통해 Java 언어와 네이티브 코드 간의 상호 작용을 허용하도록 합니다.
        네이티브 메소드 라이브러리는 무조건 JNI를 통해 실행된다~

        - gabigy collecter : 실행엔진의 일부이고 더이상 쓰이지 않는 객체를 찾아 정리하는 것. 추후에 옵션을 변경하거나 해야할 수도 있음.

https://cdn.inflearn.com/public/files/posts/aa9d10d9-dc3f-4664-9bc1-79b7148dbc60/image.png

            1. Class Loader System
                
                loading (bootstrap-> extension(플랫폼)->application 계층형으로 진행. 상위에서 못 읽으면 하위로 내려준다.)
                class locader 가 .class 파일을 읽고 그 내용에 따라 적잘한 바이너리 데이터를 만들고 method(공용)영역에 FQCN(Fully Qualified Class Name의 약어로, 자바에서 클래스를 고유하게 식별하기 위한 완전한 경로), class, interface, enum , method, 변수 등의 데이터를 저장.
                로딩이 끝나면, 해당 클래스 타입의 class 객체를 생성하여 힙(공용) 영역에 저장.
                
                링크
                verify, prepare, resolve(optional) 세 단계로 나뉨

                - verify : .class 파일 형식이 유효한지 체크한다.
                - preparation : 클래스 변수(static 변수) 와 기본값에 필요한 메모리 resolve : 심블록 메모리 레퍼런스를 메소드 영역에 있는 실제 레퍼런스로 교체.
                - resolve : 심볼릭 메모리 레퍼런스를 메소드 영역에 있는 실제 레퍼런스로 교체한다(이 부분은 코드에서 다시 자세히 볼 것.)
                - 초기화 : static 변수의 값을 할당.

                클래스 로더는 계층 구조. 기본적으로 세가지 클래스 로더가 제공.

