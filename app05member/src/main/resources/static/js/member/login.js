function f01(evt){

    evt.preventDefault();

    const id = document.querySelector("input[name=id]").value;
    const pw = document.querySelector("input[name=pw]").value;
    const x ={id,pw};
    fetch(`http://127.0.0.1:8080/member/login`,{
        method : "post",
        headers : {
            "Content-Type" : "application/json",
        } ,
        body : JSON.stringify(x)
    })
    .then((resp)=>{return resp.json();})
    .then((data)=>{
        if(data===1){
            alert("로그인 완료!");
            location.href = "/home";
        }else{
            alert("로그인 실패...");
            location.href = "/error";
        }
        
    }) 
    ;
}