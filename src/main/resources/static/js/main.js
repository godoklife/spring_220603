$(function(){
    show();
})

function send(){
    $.ajax({    // ajax 비동기 통신 사용시 jquery cdn 필수!!
        url:'save',
        data:{"content":$("#content").val()},
        success:function (args){
            $("#content").val("");
            show();
        }
    })
}

let list = [];
// 모든 방문록을 호출하는 메서드
function show(){
    $.ajax({
        url:'getlist',
        success(args){
            list = args;
            let html = "<tr>" +
                "            <th>번호</th>" +
                "            <th>내용</th>" +
                "            <th>비고</th>" +
                "        </tr>";
            for(let i=0; i<list.length; i++){
                html +='<tr>' +
                    '            <td>'+list[i]['no']+'</td>'+
                    '            <td>'+list[i]['content']+'</td>'+
                    '            <td><button onclick="update('+list[i]["no"]+')">수정</button>'+
                    '                <button onclick="test('+list[i]["no"]+')">삭제</button></td>' +
                    '        </tr>';
            }
            $("#viewtable").html(html);
        }
    })
}

function update(no){
    $.ajax({
        url:"update",
        data:{"no":no, "content":$("#content").val()},
        success:function (args){
            if(args==1){
                alert("sucksex!!");
                show();
            }else{
                alert("fail");
            }
        }
    })
}

function test(no){
    $.ajax({
        url:"delete",
        data:{"no":no},
        success:function (args){
            if(args==1){
                alert("delete sucksex!!");
                show();
            }else{
                alert("delete fail");
            }
        }
    })
}