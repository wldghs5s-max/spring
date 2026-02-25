function login(){
    const id = document.querySelector("header input[name=id]").value;
    const pw = document.querySelector("header input[name=pw]").value;

    fetch(`/member/login`,{
        method : "POST",
        headers : {
            "Content-Type" : "application/json",
        },
        body : JSON.stringify({id,pw}),
    })
    .then(resp=>{
        if(!resp.ok){
            console.log(resp);
            throw new Error("login err~~")
        }
        alert("로그인 성공 !");
        location.href="/";
        return resp.json();
    })
    .catch(err=>{
        console.log(err);
        alert("로그인 실패...")
        
    })
}