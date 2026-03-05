async function edit(){
    try {
        const title = document.querySelector("main input[name=title]").value;
        const content = document.querySelector("main textarea[name=content]").value;
        const no = document.querySelector("main input[name=no]").value;

        const resp = await fetch(`/board`,{
            method : "PUT",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify({title, content, no}),
        })
        if(!resp.ok){
            throw new Error("board edit fail ... resp err");
        }
        const data = await resp.json();
        
        if(data.result != 1){
            throw new Error("board edit fail...not result 1")
        }
        alert("게시글 수정 완료 !");
        location.href = "/board/list"
    } catch (error) {
        console.log(error);
        location.href=`/home`;
    }
}

async function del() {
    try {
        const no = document.querySelector("main input[name=no]").value;
        const resp = await fetch(`/board`,{
            method : "DELETE",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify({no}),
        });
        if(!resp.ok){
            throw new Error("fail to delete ... resp not ok");
        }
        const data = await resp.json();
        if(data.result!= 1){
            throw new Error("fail to delete... result not 1");
        }
        alert("게시글 삭제 완료 !")
        location.href = "/board/list"
        
    } catch (error) {
        console.log(error);
        location.href=`/home`;
        
    }
}