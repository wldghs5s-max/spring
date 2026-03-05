async function loadBoardVo(){
    const boardNo = location.pathname.split("/").pop();
    const resp = await fetch(`/board/${boardNo}`);
    if(!resp.ok){
        throw new Error("loadBoardVo fail...");
    }
    const data = await resp.json();
    const vo = data.vo;

    document.querySelector("#writerNick").innerHTML = vo.writerNick;
    document.querySelector("#hit").innerHTML = vo.hit;
    document.querySelector("#createdAt").innerHTML = vo.createdAt;
    document.querySelector("main input[name=title]").value = vo.title;
    document.querySelector("main textarea[name=content]").value = vo.content;

}
try {
    loadBoardVo();
} catch (error) {
    console.log(error);
    alert("게시글 상세조회 실패 ...")
}

function moveToEditPage(){
    const no = location.pathname.split("/").pop();
    location.href = `/board/edit/${no}`;
}

async function insertReply(){
    try {
        const content = document.querySelector("main textarea[name=reply-content]").value;
        const boardNo = location.pathname.split("/").pop();
        const resp = await fetch(`/api/board/reply`,{
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify({content, boardNo})
        })
        if (!resp.ok) {
            throw new Error("resp not ok");        
        }
        const data = await resp.json();
        if(data.result != 1){
            alert("댓글달기 실패...")
            throw new Error("result not 1");
        }
        alert("댓글 등록 성공!");
        loadReply();
    } catch (error) {
        console.log(error);
    }

}

async function loadReply(){
    try {
        const boardNo = location.pathname.split("/").pop();
        const resp = await fetch(`/api/board/reply?boardNo=${boardNo}`);
        if(!resp.ok){
            throw new Error("load reply fail.. resp not ok");
        }
        const voList = await resp.json();
        let str = "";
        for(const vo of voList){
            str += `
                <div>
                    <span>${vo.no}</span>
                    <span>${vo.content}</span>
                    <span>${vo.writerNick}</span>
                    <span>${vo.createdAt}</span>
                    <button onclick="del(${vo.no});">삭제하기</button>
                </div>
            `;
        }
        const replyListArea = document.querySelector("#reply-list-area");
        replyListArea.innerHTML = str;
    } catch (error) {
        console.log(error);
    }
}

loadReply();

async function del(no){
    try {
        const resp = await fetch(`/api/board/reply`,{
            method : "DELETE",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify({no})
        })
        if(!resp.ok){
            throw new Error("reply delete fail.. resp not ok");
        }
        const data = await resp.json();
        if(data!=1){
            alert("본인 댓글만 삭제 가능");
            throw new Error("reply delete fail.. data not 1")
        }
        alert("댓삭튀 성공!");
        loadReply();
    } catch (error) {
        console.log(error);
        
    }
}