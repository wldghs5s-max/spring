function f01(evt){
    evt.preventDefault();
    const nick = document.querySelector("input[name=nick]").value;

    const x = {nick};

    fetch(`http://127.0.0.1:8080/member/mypage`,{
        method : "put",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(x) ,
    })
        .then(resp=>resp.json())
        .then((data)=>{
            if(data===1){
                alert("수정 성공!");
                location.href = "/home"
            }else{
                alert("수정 실패..")
                location.href = "/error"
            }
        })

}

function f02(){
    fetch(`http://127.0.0.1:8080/member/mypage`,{
        method : "delete",
        headers : {
            "Content-Type" : "application/json"
        },
    })
        .then(resp=>resp.json())
        .then((data)=>{
            if(data===1){
                alert("회원탈퇴 성공!")
                location.href = "/home"
            }else{
                alert("탈퇴 실패..")
                location.href = "/error"
            }
        })
}