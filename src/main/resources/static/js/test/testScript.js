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
               })
        }
    );

    $("#btnTest2").on('click', function postTestData()
            {
                var testRequest = {};
                testRequest.title = $("#testTitle").val();
                testRequest.desc =  $("#testDesc").val();
                console.log(JSON.stringify(testRequest)+"<= testRequest");
                $.ajax({
                   type: "POST",
                   url: "/test/insert2",
                   //dataType: "JSON", //데이터 타입 불일치로  해당 옵션 추가하면 성공해도 에러코드로 반환하고있음
                   contentType: "application/json", // 추가
                   data: JSON.stringify(testRequest) // 객체를 JSON 문자열로 변환하여 전송
                })
                   .done(function (result) {
                        alert("저장에 성공했습니다.")
                         window.location.href = "/test2";
//                       $.ajax({
//                           type: "GET",
//                           url: "/test2",
//                           dataType: "text"
//                         })
//                         .done(function(secondResult) {
//                           console.log("두 번째 AJAX 호출 성공:", secondResult);
//                         })
//                         .fail(function(jqXHR, textStatus, errorThrown) {
//                           console.log("두 번째 AJAX 호출 실패:", textStatus, errorThrown);
//                         });
                   })
                   .fail(function(jqXHR) {
                       console.log("fail 함수 호출된거임");
                       console.log(jqXHR);
                   })
                   .always(function() {
                   })
            }
        );
};