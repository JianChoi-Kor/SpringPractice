/**
 * 
 */

function goToDetail(boardPk) {
	location.href = `/board/detail?boardPk=${boardPk}`
}


var listContentElem = document.querySelector('#listContent')

function getBoardList() {
	
	var category = listContentElem.dataset.category
	console.log(`category : ${category}`)
	fetch(`/board/listData?category=${category}`)
	.then(res => res.json())
	.then(myJson => {
		console.log(myJson)
		proc(myJson)
	})
}

function proc(myJson) {
	if(myJson.length === 0) {
		listContentElem.innerHTML = '<div>글이 없습니다.</div>'
		return
	}
	
	listContentElem.innerHTML = '<div>글이 있습니다.</div>'
}

getBoardList()