/**
 * 
 */

function goToDetail(boardPk) {
	location.href = `/board/detail?boardPk=${boardPk}`
}


var listContentElem = document.querySelector('#listContent')
var category = listContentElem.dataset.category
var selRowCntElem = document.querySelector('#selRowCnt')
selRowCntElem.addEventListener('change', function() {
	getBoardList(1)
	getMaxPageNum()
})

function getBoardList(page) {
	
	if(!page) {
		page = 1
	}

	var rowCnt = selRowCntElem.value
	var info = {
		rowCnt,
		page,
		category
	}
	sessionStorage.setItem('pageInfo', JSON.stringify(info))
	
	
	
	console.log(`category : ${category}`)
	fetch(`/board/listData?category=${category}&page=${page}&rowCnt=${rowCnt}`)
		.then(res => res.json())
		.then(myJson => {
			console.log(myJson)
			boardProc(myJson)
		})

	function boardProc(myJson) {
		if (myJson.length === 0) {
			listContentElem.innerHTML = '<div>글이 없습니다.</div>'
			return
		}

		var tableElem = createTable()
		myJson.forEach(function(item) {
			tableElem.append(createRecord(item))
		})

		listContentElem.innerHTML = ''
		listContentElem.append(tableElem)

	}

	function createRecord(item) {
		var tr = document.createElement('tr')
		tr.classList.add('record')
		tr.addEventListener('click', function() {
			goToDetail(item.boardPk)
		})
		// 이부분 반복문으로도 가능
		var td_1 = document.createElement('td')
		var td_2 = document.createElement('td')
		var td_3 = document.createElement('td')
		var td_4 = document.createElement('td')
		var td_5 = document.createElement('td')

		td_1.innerText = item.seq
		td_2.innerText = item.title
		td_3.innerText = item.hits
		td_4.innerText = item.regDt
		td_5.innerText = item.writerNm

		tr.append(td_1)
		tr.append(td_2)
		tr.append(td_3)
		tr.append(td_4)
		tr.append(td_5)

		return tr;
	}

	function createTable() {
		var tableElem = document.createElement('table')
		tableElem.classList.add('basic-table')

		tableElem.innerHTML = `
	<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>조회수</td>
		<td>작성일자</td>
		<td>작성자</td>
	</tr>`

		return tableElem
	}
}






function getMaxPageNum() {
	
	var rowCnt = selRowCntElem.value
	fetch(`/board/getMaxPageNum?category=${category}&rowCnt=${rowCnt}`)
	.then(res => res.json())
	.then(myJson => {
		pageProc(myJson)
		console.log(myJson)
	})
}

var pagingContentElem = document.querySelector('#pagingContent')
function pageProc(myJson) {
	
	pagingContentElem.innerHTML = ''
	
	for(let i=1; i<=myJson; i++) {
		let span = document.createElement('span')
		
		span.innerText = i;
		span.classList.add('pointer')
		
		if(i === 1) {
			span.classList.add('selected')
		}

		// span에 click 이벤트를 건다. 클릭하면 getBoardList 함수를 호출
		span.addEventListener('click', function() {
			getBoardList(i)
			// 모든 span에 selected 클래스를 빼준다.
			var spanList = pagingContentElem.children
			console.log(spanList)
			for(var z = 0; z<spanList.length; z++) {
				spanList[z].classList.remove('selected')
			}
		
			// 나의 span에 selected 클래스를 추가한다.
			span.classList.add('selected')
		})
		
		pagingContentElem.append(span)
	}
}

var page = 1
var pageInfoTxt = sessionStorage.getItem('pageInfo')
if(pageInfoTxt) {
	var pageInfo = JSON.parse(pageInfoTxt)
	page = pageInfo.page
	selRowCntElem.value = pageInfo.rowCnt
	
	
}


getBoardList(page)
getMaxPageNum()















