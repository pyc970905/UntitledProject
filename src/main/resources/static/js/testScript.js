window.onload = function init(){
    console.log("bindButtonEvent 실행");
    bindButtonEvent();
    console.log("bindButtonEvent 종료");
};

//버튼이벤트들
function bindButtonEvent() {
    $("#btnTest").on('click', function hello()
        {
             alert("안녕?");
        }
    );

    $("#btnAjaxTest").on('click', function getMemberList()
        {
            $.ajax({
               type: "POST",
               url: "/members/search",
               // data: form, // api 호출을 위한 요청 변수가 필요하다면 사용해주세요.
               dataType: "text"
            })
               .done(function (result) {
                   console.log(result);
                   $("#memberListContent").replaceWith(result);
               })
               .fail(function(jqXHR) {
                   console.log(jqXHR);
               })
               .always(function() {
                   console.log("요청, 응답 결과에 상관없이, 이건 항상 실행됩니다.");
               })
        }
    );
};