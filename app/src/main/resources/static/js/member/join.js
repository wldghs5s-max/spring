function join(){

    const id = document.querySelector("main input[name=id]").value;
    const pw = document.querySelector("main input[name=pw]").value;
    const nick = document.querySelector("main input[name=nick]").value;
    const hobbyArr = document.querySelectorAll("main input[name=hobby]");
    const profile = document.querySelector("main input[name=profile]").files[0];

    const fd = new FormData();
    fd.append("id" , id);
    fd.append("pw" , pw);
    fd.append("nick" , nick);
    for(let i = 0 ; i < hobbyArr.length; ++i){
        if(hobbyArr[i].checked === true){
            const v = hobbyArr[i].value;
            fd.append("hobbys" , v);
        }
    }
    if (profile) {
        fd.append("profile" , profile);
    }
    
    fetch(`/member/join` , {
        method : "POST" ,
        body : fd ,
    })
    .then( resp => {
        if(!resp.ok){
            alert("서버에러");
            throw new Error("회원가입 에러 발생...");
        }
        return resp.json();
    } )
    .then( data => { 
        console.log("data : " , data);
        
        if(data.x === "1"){
            alert("회원가입 성공 !");
            location.href="/";
        }else{
            alert("result가 1이 아님");
            throw new Error("회원가입 에러 발생...");
        }
     } )
    .catch( (err) =>{ 
        console.log("에러발생 : " , err);
        alert("회원가입 실패...");
     })
    ;

}

// 비밀번호 일치여부 체크
const pw = document.querySelector("input[name=pw]");
const pw2 = document.querySelector("input[name=pw2]");
const pwMatchResult = document.querySelector("#pwMatchResult");

pw2.addEventListener("blur" , function(){
    if(pw.value === pw2.value){
        pwMatchResult.classList.remove("text-red");
        pwMatchResult.innerHTML = "비밀번호 일치";
    }else{
        pwMatchResult.classList.add("text-red");
        pwMatchResult.innerHTML = "비밀번호 불일치";
    }
});


// 취미 체크박스 만들기
function generateHobbyArea(){
    //DB
    fetch(`/member/hobby`)
    .then( resp => {
        if(!resp.ok){
            throw new Error("취미 조회 실패 ...");
        }
        return resp.json();
    } )
    .then( voList => {
        const hobbyArea = document.querySelector("#hobby-area");

        let str = "";
        for(const vo of voList){
            str += `
            <label>
                <input type="checkbox" name="hobby" value="${vo.no}">
                ${vo.name}
            </label>
        `;
        }
        hobbyArea.innerHTML = str;
    } )
    .catch( err => {
        console.log("error ::: " , err);
        alert("문제 발생 ... ! 관리자에게 문의하세요");
    } )
    ;

    //view
}

generateHobbyArea();