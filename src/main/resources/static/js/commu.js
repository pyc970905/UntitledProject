window.onload = function init(){
    console.log("START");
    bindButtonEvent();
    console.log("FAIL");
};

//버튼이벤트들
function bindButtonEvent() {
    $("#btnCommuForm").on('click', function getMemberList()
        {
            $.ajax({
               type: "GET",
               url: "/commu/post",
               // data: form, // api 호출을 위한 요청 변수가 필요하다면 사용해주세요.
               dataType: "text"
            })
               .done(function (result) {
                   $("#postingCommuForm").replaceWith(result);
                   $("#btnCommuForm").hide();
               })
               .fail(function(jqXHR) {
                   console.log(jqXHR);
               })
               .always(function() {
               })
        }
    );

    $("#btnPostCommuContent").on('click', function getMemberList()
            {
               console.log("hello")
              var commuReq = {};

              commuReq.title    = $("#commuTitle").val();
              commuReq.content  = $("#commuContent").val();
              commuReq.writer   = $("#commuWriter").val();

                $.ajax({
                   type: "POST",
                   url: "/commu/post",
                   contentType: "application/json", // 추가
                   data: JSON.stringify(commuReq) // 객체를 JSON 문자열로 변환하여 전송
                })
                   .done(function (result) {
                       alert("저장완료되었습니다.");
                       //window.location.href = "";
                   })
                   .fail(function(jqXHR) {
                       console.log(jqXHR);
                   })
                   .always(function() {
                   })
            }
        );

};