# JAVA-Web

## html

* 기본적인 [텍스트](./html/WebContent/text.html) 태그 연습
* [멀티미디어](./html/WebContent/multimedia.html) 태그 연습 ex) 이미지, 영상
* [입력](./html/WebContent/formtest.html) 양식 태그 연습

## css

* css style을 이용하여 태그를 [선택](./css/WebContent/selectortest.html),  속성을 설정하는 방법 및 연습

## java script

* 자바 스크립트의 [기본](./js/WebContent/first.html)
* [배열](./js/WebContent/array.html) 연습
* [조건문](./js/WebContent/ifelsetest.html) 연습
* [함수](./js/WebContent/functiontest.html) 연습
* [timer](./js/WebContent/timer.html) 연습

* [오브젝트](./js/WebContent/objecttest.html) 연습

* [입력](./js/WebContent/input.html) 연습
* 전체적인 통합 실습 [student](./js/WebContent/student.html)

* dom 실습
  * DOM(Document Object Model)은 HTML문서에 대한 인터페이스입니다. 
    * 뷰포트에 무엇을 렌더링 할지 결정하기 위해 사용
    * 페이지의 콘텐츠 및 구조, 그리고 스타일이 자바스크립트 프로그램에 의해 수정되기 위해 사용
    * 항상 유효한 HTML형식입니다.
    * 자바스크립트에 수정될 수있는 동적 모델이어야합니다.
    * 가상 요소를 포함하지 않습니다.
    * 보이지 않는 요소를 포함합니다.
  * [dom1](./js/WebContent/dom1.html), [dom2](./js/WebContent/dom2.html)
  * [event](./js/WebContent/event.html), [event2](./js/WebContent/event2.html) 이벤트 설정
  * [arrowfunction](./js/WebContent/arrowfunc.html)  익명, 화살표 함수
* [게시판 검색](./js/WebContent/boardlist.html) - 검색하면 테이블에 검색한 데이터가 보여지도록 java script 코딩

## jquery

* jquery에 대해 알아보자

* [class](./jquery/WebContent/class.html) - jquery를 이용해 class 추가
* [event](./jquery/WebContent/event.html) - jquery로 할수 있는 event
* [select event](./jquery/WebContent/selectevent.html) - select event 실습
* [text](./jquery/WebContent/text_html.html) - 텍스트 관련 jquery
* [textarea](./jquery/WebContent/textarea.html) - keyup이벤트 및 시각효과
* [bubbling](./jquery/WebContent/bubbling.html) - 중복이벤트 처리가 되는경우 자식태그의 이벤트가 먼저 실행되고 부모가 실행이 된다

# Web Application

## Servlet

* 자바 서블렛을 이용하여 서버를 만들고 브라우저와 통신한다.
* [Servlet](./servlettest/src/servlettest/TestServlet.java) 의 기초
* [lifecycleServlet](./servlettest/src/servlettest/LifeCycleServlet.java) Servlet의 실행주기를 알아볼 수 있는 파일
* [gugudan](./servlettest/src/servlettest/GugudanServlet.java) servlet을 이용해 html에서 입력을 받아 구구단을 보여주는 실습
* RequestDipatcher를 이용한 forward
  * [forward1](./servlettest/src/forward/Forward1Servlet.java) 데이터를 forward하는 서블릿
  * [forward2](./servlettest/src/forward/Forward2Servlet.java) 데이터를 전달 받는 서블릿
* context를 [생성](./servlettest/src/context/ContextServlet1.java) 하고 [전달](./servlettest/src/context/ContextServlet2.java) 받는 방법
* cookie를 [생성](./servlettest/src/cookie/CookieServlet1.java) 하고 [전달](./servlettest/src/cookie/CookieServlet2.java) 받는 방법
* Initparameter를 [설정](./servlettest/src/config/InitParameterServlet.java) 하는방법
* Session
  * 기본적인 Session을 [생성](./servlettest/src/session/SessionServlet1.java) 하고 [전달](./servlettest/src/session/SessionServlet2.java) 받는 방법
  * MemerDTO를 Session으로 [생성](./servlettest/src/session/SessionServlet3.java) 하고 [전달](./servlettest/src/session/SessionServlet4.java) 받는 방법
  * Session 값을 [삭제](./servlettest/src/session/SessionServlet5.java) 하는 방법

## JSP

* JSP의 [기초](./jsp/WebContent/first.jsp) 와 [변수](./jsp/WebContent/membervar.jsp)
* Include를 이용한 JSP
  * [share](./jsp/WebContent/include/share.jsp)
  * [member](./jsp/WebContent/include/member.jsp)
  * [board](./jsp/WebContent/include/board.jsp)
  * [shop](./jsp/WebContent/include/shop.jsp)

* JSP태그를 이용한 include
  * [share](./jsp/WebContent/actioninclude/share.jsp)
  * [member](./jsp/WebContent/actioninclude/member.jsp)
  * [board](./jsp/WebContent/actioninclude/board.jsp)
  * [shop](./jsp/WebContent/actioninclude/shop.jsp)
* Jsp에서 [에러](./jsp/WebContent/error/a.jsp)를 띄우기 위해선 [errorpage](./jsp/WebContent/error/b.jsp)를 사용해야한다.
* JSP로 session을 이용하는 방법
  * [sessiontest](./jsp/WebContent/session/sessiontest.jsp) - main
  * [후기](./jsp/WebContent/session/sessiontest2.jsp)
  * [정보](./jsp/WebContent/session/sessiontest3.jsp)
  * [로그아웃](./jsp/WebContent/session/sessiontest.jsp)
* bean을 이용한 JSP
  * [boardwrite](./jsp/WebContent/bean/boardwrite.html)
  * [beantest1](./jsp/WebContent/bean/beantest1.jsp) , [beantest2](./jsp/WebContent/bean/beantest2.jsp)
    * scope=request일때는 jsp:forward를 이용하여 beantest2로 넘겨줄 수 있다.
    * scope=session일때는 beantest2도 데이터를 공유한다.
* [Servlet](./jsp/src/board/BoardServlet.java)과 [JSP](./jsp/WebContent/board/boardstart.jsp)를 이용하여 Board보여주기