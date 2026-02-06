function join(){
    const id = document.querySelector("form#joinForm>input[name=id]").value;
    const pw = document.querySelector("form#joinForm>input[name=pw]").value;
    const nick = document.querySelector("form#joinForm>input[name=nick]").value;
    

    fetch(`http://127.0.0.1:8080/member/join`,{
        method : "post",
        headers : {
            "Content-Type" : "application/json"
        } ,
        body : JSON.stringify({id,pw,nick}),
    })
    .then(resp=>resp.json())
    .then((data)=>{
       if(data===1){
        alert("회원가입 성공!")
        location.href = "/home";
       } else{
        alert("회원가입 실패...")
        location.href = "/error";
       }
        
    });
}
function login(){
    const id = document.querySelector("form#loginForm>input[name=id]").value;
    const pw = document.querySelector("form#loginForm>input[name=pw]").value;

    fetch(`http://127.0.0.1:8080/member/login`,{
        method : "post",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify({id,pw})
    })
    .then(resp=>resp.json())
    .then((data)=>{
        if(data.msg==="GOOD"){
            alert("로그인성공!")
            location.href = "/home";
        }else{
            alert("로그인 실패...")
            location.href = "/error";
        }   
        ;
        
    })
}
function editNick(){
    const nick = document.querySelector("form#editForm>input[name=nick]").value;

    fetch(`http://127.0.0.1:8080/member`,{
        method : "put",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify({nick})
    })
    .then(resp=>resp.json())
    .then((data)=>{
        if(data===1){
            alert("수정 성공! 다시 로그인 하세요.")
        }else{
            alert("수정 실패...")
        }
    })
}
function quit(){
    fetch(`http://127.0.0.1:8080/member`,{
        method : "delete"
    })
    .then(resp=>resp.json())
    .then((data)=>{
        if(data===1){
            alert("삭제완료...")
            location.href = "/home";
        }else{
            alert("히히 못가!!! 삭제실패!!")
        }
    })
}