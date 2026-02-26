async function getUserHobby(){
    try{
        //유저 취미 가져오기
        const resp1 = await fetch(`/member/hobby/user`);
        if(!resp1.ok){
            throw new Error("현재 유저의 취미 조회 실패 ...");
        }
        const data = await resp1.json();
        const userHobbyArr = data.hobby.split(",");
        
        console.log(data);
        //화면에 체크박스 만들기
        
        const resp2 = await fetch(`/member/hobby`);
        if(!resp2.ok){
            throw new Error("취미 조회 실패...")
        }
        const allHobbyVoList = await resp2.json();
        console.log("allHobbyVoList : ",allHobbyVoList);

        const hobbyArea = document.querySelector("#hobby-area");
        let str = "";
        for(const vo of allHobbyVoList){
            if(userHobbyArr.includes(vo.no)){
                str += `
                    <label>
                        <input type="checkbox" name="hobby" value="${vo.no}" checked>
                        ${vo.name}
                    </label>
                `;
            }else{
                str += `
                    <label>
                        <input type="checkbox" name="hobby" value="${vo.no}">
                        ${vo.name}
                    </label>
                `;
            }
        }
        hobbyArea.innerHTML=str;
    }catch(err){
        console.log(err);
        alert("[문제 발생] 관리자에게 문의하세요.");
    }
    
}
getUserHobby();


async function quit(){
    const result = confirm("정말 탈퇴하시겠습니가?");
    if (!result) {return;}
   const resp = await fetch(`/member/quit`,{
        method : "delete" ,
    });
    if(!resp.ok){
        throw new Error("quit err...");
    }
    alert("회원 탈퇴 완료")
    location.href = "/";
}

async function edit(){
    //비밀번호, 닉네임 , 취미 , 프로필 수정
    const pw = document.querySelector("main input[name=pw]").value;
    const nick = document.querySelector("main input[name=nick]").value;
    const hobbyTagArr = document.querySelectorAll("main input[name=hobby]");
    const profile = document.querySelector("main input[name=profile]").files[0];
    let hobby = "";

    for(const tag of hobbyTagArr){
        if(tag.checked){
            hobby += tag.value + ",";
        }
    }
    hobby = hobby.slice(0,-1);
    const fd = new FormData();
    fd.append("pw",pw);
    fd.append("nick",nick);
    fd.append("hobby",hobby);
    if(profile){
        fd.append("profile",profile);
    }
    try{
        const resp = await fetch(`/member/edit`,{
        method : "PUT" , 
        body : fd
        });

        if(!resp.ok){
            throw new Error("front edit error ...");
        }

        alert("수정하기 성공 !");
        location.reload();

    }catch(error){
        console.log(error);
        alert("수정하기 실패...");
    }

}