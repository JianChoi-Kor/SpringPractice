/**
 * 
 */

function goToDetail(boardPk) {
	location.href = `/board/detail?boardPk=${boardPk}`
}

var gPage = 1
var listContentElem = document.querySelector('#listContent')
var category = listContentElem.dataset.category
var selRowCntElem = document.querySelector('#selRowCnt')

var selSearchTypeElem = document.querySelector('#selSearchType') // 검색타입
var txtSearchTextElem = document.querySelector('#txtSearchText') // 검색어


selRowCntElem.addEventListener('change', function() {
	getBoardList(1)
	getMaxPageNum()
})


function getBoardList(page) {

	if (!page) {
		page = 1
	}
	gPage = page
	
	//sessionStorate 많이 사용하는 법 (중요)
	var rowCnt = selRowCntElem.value
	var searchType = selSearchTypeElem.value
	var searchText = txtSearchTextElem.value
	
	var info = {
		rowCnt,
		page,
		searchType,
		searchText
	}

	sessionStorage.setItem('pageInfo', JSON.stringify(info))





	console.log(`category : ${category}`)
	fetch(`/board/listData?category=${category}&page=${page}&rowCnt=${rowCnt}&searchType=${searchType}&searchText=${searchText}`)
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

		var searchType = selSearchTypeElem.value
		var searchText = txtSearchTextElem.value
		
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
		td_2.innerHTML = item.title
		td_3.innerText = item.hits
		td_4.innerText = item.regDt
		td_5.innerHTML = item.writerNm

		tr.append(td_1)
		tr.append(td_2)
		tr.append(td_3)
		tr.append(td_4)
		tr.append(td_5)

		return tr;
		/*
		
		let title = item.title
		let writerNm = item.writerNm
		// 하이라이트 처리
		if(searchText !== '') {
			switch(searchType) {
				case '1': // 제목
				case '3': // 제목 +내용
				title = setHighlight(title, searchText)
				break
				case '4': // 작성자
				writerNm = setHighlight(writerNm, searchText)
				break
			}
		}
		
		*/

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

	var searchType = selSearchTypeElem.value
	var searchText = txtSearchTextElem.value

	var rowCnt = selRowCntElem.value
	fetch(`/board/getMaxPageNum?category=${category}&rowCnt=${rowCnt}&searchType=${searchType}&searchText=${searchText}`)
		.then(res => res.json())
		.then(myJson => {
			pageProc(myJson)
			console.log(myJson)
		})
}

var pagingContentElem = document.querySelector('#pagingContent')
function pageProc(myJson) {

	pagingContentElem.innerHTML = ''

	for (let i = 1; i <= myJson; i++) {
		let span = document.createElement('span')

		span.innerText = i;
		span.classList.add('pointer')

		if (gPage === i) {
			span.classList.add('selected')
		}

		// span에 click 이벤트를 건다. 클릭하면 getBoardList 함수를 호출
		span.addEventListener('click', function() {
			
			
			getBoardList(i)
			// 모든 span에 selected 클래스를 빼준다.
			var spanList = pagingContentElem.children
			console.log(spanList)
			for (var z = 0; z < spanList.length; z++) {
				spanList[z].classList.remove('selected')
			}

			// 나의 span에 selected 클래스를 추가한다.
			span.classList.add('selected')
		})

		pagingContentElem.append(span)
	}
}


var pageInfoTxt = sessionStorage.getItem('pageInfo')
if (pageInfoTxt) {
	var pageInfo = JSON.parse(pageInfoTxt)
	selRowCntElem.value = pageInfo.rowCnt
	selSearchTypeElem.value = pageInfo.searchType
	txtSearchTextElem.value = pageInfo.searchText
	
	search(pageInfo.page)
} else {
	search()
}


//sessionStorage 불러오는 쪽 (중요)

/*

getBoardList(gPage)
getMaxPageNum()

*/

function search(page = 1) {
	gPage = page
	getBoardList(page)
	getMaxPageNum()
}













