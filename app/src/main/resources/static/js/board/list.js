async function loadBoardVoList(){
    const pno = location.pathname.split("/").pop();
    const resp = await fetch(`/board?currentPage=${pno}`);

    if(!resp.ok){
        throw new Error("select board list fail..");
    }

    const data = await resp.json();
    const pvo = data.pvo;
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
    setPageArea(pvo);
}
try {
    loadBoardVoList();
} catch (error) {
    console.log(error);
    alert("게시글 불러오기 실패...")
}

function setPageArea(pvo){
    const pageArea = document.querySelector("#page-area");
    let str = "";
    if(pvo.startPage != 1){
        str += `<button onclick="location.href='/board/list/${pvo.startPage-1}'">이전</button>`;
    }
    for(let i = pvo.startPage; i<=pvo.endPage; ++i){
        str += `<button onclick="location.href='/board/list/${i}'">${i}</button>`;
    }
    if(pvo.endPage < pvo.maxPage){
        str += `<button onclick="location.href='/board/list/${pvo.endPage+1}'">다음</button>`;
    }

    pageArea.innerHTML = str;
}