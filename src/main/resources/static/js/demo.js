window.onload = function init(){
    console.log("START");
    bindButtonEvent();
    console.log("FAIL");
};

//버튼이벤트들
function bindButtonEvent() {
    $("#btnDemoForm").on('click', function getMemberList()
        {
            $.ajax({
               type: "GET",
               url: "/demo/post",
               dataType : "html",
               cache : false
               // data: form, // api 호출을 위한 요청 변수가 필요하다면 사용해주세요.
            })
               .done(function (result) {
                   $("#demoContent").children().remove();
                   $('#postingDemoForm').children().remove();
                   $('#postingDemoForm').html(result);
                   $("#btnDemoForm").hide();


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



  // 재생/일시정지 버튼 클릭 시 동작
  function togglePlayPause(demoNo) {
    var audioPlayer = document.getElementById('audioPlayer'+demoNo);
    if (audioPlayer.paused) {
      // 일시정지 상태일 때 재생
      audioPlayer.play();
    } else {
      // 재생 중일 때 일시정지
      audioPlayer.pause();
    }
  };