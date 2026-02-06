function f01(evt){
    evt.preventDefault();
    const id = document.querySelector("input[name=id]").value;
    const pw = document.querySelector("input[name=pw]").value;
    const nick = document.querySelector("input[name=nick]").value;


    const x = {
        id ,
        pw , 
        nick ,
    };
    fetch(`http://127.0.0.1:8080/member/join`, {
        method : "post" ,
        headers : {
            "Content-Type" : "application/json" ,
        }  ,
        body : JSON.stringify(x) ,
    })
    .then((resp)=>{return resp.json()})
    .then((data)=>{
        if(data===1){
            alert("회원가입 성공!")
            location.href = "http://127.0.0.1:8080/member/login";
        }else{
            alert("회원가입 실패...")
        }
    })
    
    ;
}