async function loadBoardVoList(){
    const resp = await fetch(`/board`);
    if(!resp.ok){throw new Error("select board list fail..");}
    const data = await resp.json();
    const voList = data.voList
    const tbodyTag = document.querySelector("main table tbody");

    let str = "";
    for(const vo of voList){
        str += `
            <tr>
                <td><a href="/board/detail/${vo.no}">${vo.no}</a></td>
                <td><a href="/board/detail/${vo.no}">${vo.title}</a></td>
                <td>${vo.writerNick}</td>
                <td>${vo.hit}</td>
            </tr>
        `;
    }
    tbodyTag.innerHTML = str;
}
try {
    loadBoardVoList();
} catch (error) {
    console.log(error);
    alert("게시글 불러오기 실패...")
}