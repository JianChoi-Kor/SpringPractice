



var joinBtnElem = document.querySelector('#joinBtn')

if(joinBtnElem) {
	var frmElem = document.querySelector('#frm')
	var uidElem = frmElem.userId
	var upwElem = frmElem.userPw
	var nmElem = frmElem.nm
	
	function ajax() {
		if(uidElem.value === '') {
			alert('아이디를 입력해 주세요.')
			return
		} else if(upwElem.value === '') {
			alert('비밀번호를 입력해 주세요.')
			return
		} else if(nmElem.value === '') {
			alert('이름을 입력해 주세요.')
			return
		}
		
		
		var param = {
			uid: uidElem.value,
			upw: upwElem.value,
			nm: nmElem.value
		}
		
		fetch('/user/join', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			console.log("회원가입 성공")
		})
		
	}
	
	joinBtnElem.addEventListener('click', ajax)
	
	function proc(myJson) {
		switch(myJson.result) {
			case 0:
			alert('아이디 입력값이 없거나 길이가 너무 짧습니다.')
			return
			
			case 1:
			alert('회원가입에 성공했습니다.')
			location.href = '/user/login'
			
			case 2:
			alert('중복된 아이디입니다.')
			return
		}
	}
}




var loginBtnElem = document.querySelector('#loginBtn')

if(loginBtnElem) {
	var frmElem = document.querySelector('#frm')
	var uidElem = frmElem.userId
	var upwElem = frmElem.userPw
	
	function ajax() {
		if(uidElem.value === '') {
			alert('아이디를 입력해 주세요.')
			return
		} else if(upwElem.value === '') {
			alert('비밀번호를 입력해 주세요.')
			return
		}
		
		var param = {
			uid: uidElem.value,
			upw: upwElem.value
		}
		
		fetch('/user/login', {
			method: 'post',
			headers: {
				'Content-Type':'application/json',
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			proc(myJson)
		})
		
	}
	loginBtnElem.addEventListener('click', ajax)
	
	function proc(myJson) {
		switch(myJson.result) {
			case 1:
			alert('로그인 성공!!!')
			return
			
			case 2:
			alert('아이디를 확인해 주세요!!!')
			return
			
			case 3:
			alert('비밀번호를 확인해 주세요!!!')
			return
		}
	}
}





// 아이디 체크
var chkIdBtnElem = document.querySelector('#chkIdBtn')

if(chkIdBtnElem) {

	function ajax () {
		var frmElem = document.querySelector('#frm')
		var userIdElem = frmElem.userId;
		var userIdValue = userIdElem.value;
		var idChkMsgElem = frmElem.querySelector('#idChkMsg')
		
		fetch(`/user/chkId/${userIdValue}`)
			.then(function(res) {
				return res.json()
			})
			.then(function(myJson) {
				console.log(myJson)
				
				if(myJson.result === 1) {
					idChkMsgElem.innerText = '중복된 아이디가 있습니다.'
				} else {
					idChkMsgElem.innerText = '사용할 수 있는 아이디 입니다.'
				}
			})
	}
	
	chkIdBtn.addEventListener('click', ajax)
}


