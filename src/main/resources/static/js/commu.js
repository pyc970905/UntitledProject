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
               dataType : "html",
               cache : false
               // data: form, // api 호출을 위한 요청 변수가 필요하다면 사용해주세요.
            })
               .done(function (result) {
                   $("#commuContent").children().remove();
                   $('#postingCommuForm').children().remove();
                   $('#postingCommuForm').html(result);
                   $("#btnCommuForm").hide();


                   //bindButtonEvent2();
               })
               .fail(function(jqXHR) {
                   console.log(jqXHR);
               })
               .always(function() {
               })
        }
    );




};

function bindButtonEvent2() {

$("#btnPostCommuContent").on('click', function getMemberList()
            {
              console.log("hello");

              var commuReq = {};

              commuReq.title    = $("#commuTitle").val();
              commuReq.content  = $("#commuContent").val();
              commuReq.writer   = $("#commuWriter").val();
              console.log(commuReq);
                $.ajax({
                   type: "POST",
                   url: "/commu/post",
                   contentType: "application/json", // 추가
                   data: JSON.stringify(commuReq) // 객체를 JSON 문자열로 변환하여 전송
                })
                   .done(function (result) {
                       alert("저장완료되었습니다.");
                       window.location.href = "";
                   })
                   .fail(function(jqXHR) {
                       console.log(jqXHR);
                   })
                   .always(function() {
                   })
            }
);

}

function fn_showCommuDtl(no) {

     $.ajax({
                    type: "GET",
                    url: "/commu/content/"+ no,
                    dataType : "html",
                    cache : false
                       // data: form, // api 호출을 위한 요청 변수가 필요하다면 사용해주세요.
                    })
                       .done(function (result) {
                           $("#postingCommuForm").children().remove();
                           $('#commuContent').children().remove();
                           $('#commuContent').html(result);

                       })
                       .fail(function(jqXHR) {
                           console.log(jqXHR);
                       })
                       .always(function() {
                       })
}