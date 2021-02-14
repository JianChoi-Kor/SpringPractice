
var data = document.querySelector('#data')

var btnDelElem = document.querySelector('#btnDel')

if(btnDelElem) {
	btnDelElem.addEventListener('click', function() {
		if(confirm('삭제하시겠습니까?')) {
			ajax()
		}
	})
	
	function ajax() {
		var pk = data.dataset.pk
		var category = data.dataset.category
		
		fetch(`/board/del/${pk}`, {
			method: 'delete'
		})
		location.href = `/board/list?category=${category}`
	}
}



// --------------------- 댓글 start ------------------------- //

var cmtListElem = document.querySelector('#cmtList')
var modalElem = document.querySelector('#modal')
var modCtntElem = document.querySelector('#modCtnt')
var modBtnElem = document.querySelector('#modBtn')

if(modalElem) {
	var modalCloseElem = document.querySelector('#modClose')
	modalCloseElem.addEventListener('click', function() {
		modalElem.classList.add('hide')
	})
}

function selCmtList() {
	
	fetch(`/cmt?boardPk=${data.dataset.pk}`)
	.then(res => res.json())
	.then(myJson => {
		clearView()
		createView(myJson)
	})
	
	function clearView() {
		cmtListElem.innerHTML = ''
	}
	
	function createView(myJson) {
		if(myJson.length === 0) {
			return
		}
		var tableElem = createTable()
		myJson.forEach(function(item) {
			tableElem.append(createRecord(item))
		})
		
		cmtListElem.append(tableElem)
	}
	
	function createRecord(item) {
		var tr = document.createElement('tr')
		var td_1 = document.createElement('td')
		var td_2 = document.createElement('td')
		var td_3 = document.createElement('td')
		
		td_1.innerText = item.ctnt
		td_2.innerText = item.writerNm
		
		var loginUserPk = parseInt(data.dataset.loginuserpk)
		if(loginUserPk === item.writerPk) {
			
			function delAjax() {
				console.log('boardPk : ' + item.boardPk)
				console.log('seq : ' + item.seq)
				
				fetch(`/cmt?boardPk=${item.boardPk}&seq=${item.seq}`, {
					method: 'delete'
				}).then(res => res.json())
				.then(myJson => {
					
					if(myJson === 1) {
						selCmtList() 
					} else {
						alert('삭제에 실패하였습니다.')
					}
				})
			}
			
			function modAjax(param) {
				fetch('/cmt', {
					method: 'put',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(param)
				}).then(res => res.json())
				.then(myJson => {
					if(myJson === 1) {
						modalElem.classList.add('hide')
						selCmtList()
					} else {
						alert('수정에 실패하였습니다.')
					}
				})	
			}
			
			var delBtn = document.createElement('input')
			delBtn.type = 'button'
			delBtn.value = '삭제'
			delBtn.addEventListener('click', function() {
				if(confirm('삭제하시겠습니까?')) {
					delAjax()
				}
			})
			
			var editBtn = document.createElement('input')
			editBtn.type = 'button'
			editBtn.value = '수정'
			editBtn.addEventListener('click', function() {
				
				modCtntElem.value = item.ctnt
				modalElem.classList.remove('hide')
				
				modBtnElem.onclick = function() {
					console.log('check')
					var param = {
						boardPk: item.boardPk,
						seq: item.seq,
						ctnt: modCtntElem.value
					}
					modAjax(param)
				}
			})
			
			td_3.append(delBtn)
			td_3.append(editBtn)
		}
		
		tr.append(td_1)
		tr.append(td_2)
		tr.append(td_3)
		
		return tr;
	}
	
	function createTable() {
		var tableElem = document.createElement('table')
		
		tableElem.innerHTML = `
		<tr>
			<th>내용</th>
			<th>작성자</th>
			<th>비고</th>
		</tr>`
		
		return tableElem
	}
}

selCmtList()


var cmtFrmElem = document.querySelector('#cmtFrm')
if(cmtFrmElem) {
	
	var ctntElem = cmtFrmElem.ctnt
	var cmtBtn = document.querySelector('#cmtBtn');
	
	function ajax() {
		
		var ctntVal = ctntElem.value
		if(ctntVal === '') {
			alert('댓글 내용이 없습니다.')
			return
		}
		
		var param = {
			boardPk: data.dataset.pk,
			ctnt: ctntElem.value
		}
		
		fetch('/cmt', {
			method: 'post',
			headers: {
				'Content-Type':'application/json'
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			
			if(myJson === 1) {
				alert('성공')
				selCmtList()
			}
			else {
				alert('실패')
			}
		})
	}
	
	cmtBtn.addEventListener('click', ajax)
	
}








