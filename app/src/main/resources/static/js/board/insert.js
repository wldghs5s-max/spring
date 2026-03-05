async function insert(){
    const title = document.querySelector("main input[name=title]").value;
    const content = document.querySelector("main textarea[name=content]").value;
    try {
        const resp = await fetch(`/board/insert`,{
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify({title,content}),
        });
        if(!resp.ok){
            throw new Error("insert fail...");
        }
        alert("게시글 작성 성공 !");
        location.href = `/board/list`;
    } catch (error) {
        console.log(error);
    }
}