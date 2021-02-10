
// 아이디 체크
var chkIdBtnElem = document.querySelector('#chkIdBtn')

if(chkIdBtnElem) {
	function ajax() { 
		var frmElem = document.querySelector('#frm')
		var userIdElem = frmElem.userId;
		var userIdValue = userIdElem.value;
		var idChkMsgElem = frmElem.querySelector('#idChkMsg')
		
		fetch(`/user/chkId/${userIdValue}`)
			.then(function(res) {
				return res.json()
			})
			.then(function(myJson) {
				if(myJson.result === 1) {
					idChkMsgElem.innerText = '중복된 아이디가 있습니다.'
				} else {
					idChkMsgElem.innerText = '사용할 수 있는 아이디입니다.'
				}
			})
	}
	chkIdBtn.addEventListener('click', ajax)
}


// 회원가입
var joinBtnElem = document.querySelector('#joinBtn')

if(joinBtnElem) {
	var frmElem = document.querySelector('#frm')
	var userIdElem = frmElem.userId
	var userPwElem = frmElem.userPw
	var userPwReElem = frmElem.userPwRe
	var nmElem = frmElem.nm
	
	function ajax() {
		if(userIdElem.value === '') {
			alert('아이디를 입력해 주세요.')
			return
		} else if(userPwElem.value === '') {
			alert('비밀번호를 입력해 주세요.')
			return
		} else if(nmElem.value === '') {
			alert('이름을 입력해 주세요.')
			return
		}
		
		if(userPwElem.value !== userPwReElem.value) {
			alert('비밀번호가 일치하지 않습니다. ')
			return
		}
		
		var param = {
			userId: userIdElem.value,
			userPw: userPwElem.value,
			nm: nmElem.value
		}

		fetch('/user/join', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			console.log(myJson)
		})
		
	}
	joinBtn.addEventListener('click', ajax)
}


// 로그인
var loginBtnElem = document.querySelector('#loginBtn')

if(loginBtnElem) {
	var frmElem = document.querySelector('#frm')
	var userIdElem = frmElem.userId
	var userPwElem = frmElem.userPw
	var errMsgElem = document.querySelector('#errMsg')
	
	function ajax() {
		if(userIdElem.value === '') {
			alert('아이디를 입력해 주세요.')
			return
		} else if(userPwElem.value === '') {
			alert('비밀번호를 입력해 주세요.')
			return
		}
		
		var param = {
			userId: userIdElem.value,
			userPw: userPwElem.value
		}
		
		fetch('/user/login', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			console.log(myJson)
			
			if(myJson.result === 1) {
				location.href = '/board/home'
			} else if (myJson.result === 2) {
				errMsgElem.innerText = '존재하지 않는 아이디입니다.'
			} else if (myJson.result === 3) {
				errMsgElem.innerText = '비밀번호가 틀립니다.'
			}
		})
	}
	loginBtnElem.addEventListener('click', ajax)
}


