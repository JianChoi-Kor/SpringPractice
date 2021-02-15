/**
 * 
 */

var profileImgElem = document.querySelector('#profileImg')

function profileUpload() {
	
	if(profileImgElem.files.length === 0) {
		alert('이미지를 선택해 주세요')
		return
	}
	
	var formData = new FormData();
	formData.append('profileImg', profileImgElem.files[0])
	
	fetch('/user/profile', {
		method: 'post',
		body: formData
	}).then(res => res.json())
	.then(myJson => {
		if(myJson === 1) {
			location.reload() // 이상하게 되었다. 댓글에서 처럼 ajax로 데이터를 받으면 뿌리는 것도 ajax로 하는 게 맞다.
		} else {
			alert('이미지 업로드에 실패하였습니다.')
		}
	})
}