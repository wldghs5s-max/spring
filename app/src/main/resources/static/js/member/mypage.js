// //유저 취미 가져오기
// function getUserHobby(){
// fetch(`/member/hobby/user`)
// .then(resp=>{
//     if(!resp.ok){
//         throw new Error("현재 유저의 취미 조회 실패 ...");
//     }
//     return resp.json();
// })
// .then(data=>{
//     console.log(data);
    
// })
// .catch(err=>{
//     console.log(err);
//     alert("[문제 발생] 관리자에게 문의하세요.");
// })
// ;}
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



// 취미 체크박스 만들기

// function generateHobbyArea(){
    
//     //DB
//     fetch(`/member/hobby`)
//     .then( resp => {
//         if(!resp.ok){
//             throw new Error("취미 조회 실패 ...");
//         }
//         return resp.json();
//     } )
//     .then( voList => {
//         const hobbyArea = document.querySelector("#hobby-area");

//         let str = "";
//         for(const vo of voList){
//             if(true){
//                 str += `
//                 <label>
//                     <input type="checkbox" name="hobby" value="${vo.no}" checked>
//                     ${vo.name}
//                 </label>
//             `;
//             }else(){
//                 str += `
//                 <label>
//                     <input type="checkbox" name="hobby" value="${vo.no}">
//                     ${vo.name}
//                 </label>
//             `;
//             }
//         }
//         hobbyArea.innerHTML = str;
//     } )
//     .catch( err => {
//         console.log("error ::: " , err);
//         alert("문제 발생 ... ! 관리자에게 문의하세요");
//     } )
//     ;

//     //view
// }

generateHobbyArea();

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