"use strict"

window.onload = initPage;

function initPage() {
	let form;
	
	form = document.getElementById('form1');
	form.noValidate = true;
	
	form.addEventListener('submit', function(e){
		console.log("sim");
		let valid = processValidity(this);
		
		if(!valid){
			e.preventDefault();
		}
	})
}

function processValidity(form){
	validatePassword(form);
	return applyValidity(form);
}

function applyValidity(form){
	let errors = 0;
	let parameters = form.elements;
	
	for(let i = 0; i < parameters.length - 1; i++){
		let element = parameters[i];
		
		let span = document.getElementById(i);
		
		if(!element.validity.valid){
			span.innerHTML = element.validationMessage;
			errors++;
		} else {
			span.innerHTML = " ";
		}
	}
	return errors == 0;
}

function validatePassword(form){
	let password, confirm;
	
	password = form.elements['password'];
	confirm = form.elements['confirmPassword'];
	
	password.value != confirm.value ? password.setCustomValidity('The value of password labels are different') : password.setCustomValidity('');
}