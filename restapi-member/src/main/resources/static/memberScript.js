
window.onload = function () {
	const xhttp = new XMLHttpRequest();
	const mno = document.getElementById('mno').value;
	console.log(mno);
	
	xhttp.onload = function(){
		const object = JSON.parse(this.responseText);
		console.log(object);
		document.getElementById('username').value = object.username;
		document.getElementById('password').value = object.password;
		document.getElementById('name').value = object.name;
		document.getElementById('email').value = object.email;
		document.getElementById('addr').value = object.addr;
		
	}
	console.log(mno);
	xhttp.open("GET", `/api/members/${mno}`);
	xhttp.send();
}