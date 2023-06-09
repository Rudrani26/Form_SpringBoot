//const form = document.getElementById('form');
//const username = document.getElementById('username');
//const fullName = document.getElementById('fullName');
//const email = document.getElementById('email');
//const password = document.getElementById('password');
//const conPassword = document.getElementById('conPassword');
//const birthday = document.getElementById('birthday');
//const gender = document.querySelector('select[name="gender"]');

    var nameValue = fullName.value.trim();
    var usernameValue = username.value.trim();
    var emailValue = email.value.trim();
    var passwordValue = password.value.trim();
    var conPasswordValue = conPassword.value.trim();
    var birthdayValue = birthday.value.trim();
    var genderValue = gender.value.trim();

form.addEventListener('submit', e => {
    e.preventDefault();
    validateInputs();
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
};

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

const validateInputs = () => {


    if (nameValue === '') {
        setError(fullName, 'Full Name is required');
    } else {
        setSuccess(fullName);
    }

    if (usernameValue === '') {
        setError(username, 'Username is required');
    } else {
        setSuccess(username);
    }

    if (emailValue === '') {
        setError(email, 'Email is required');
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Provide a valid email address');
    } else {
        setSuccess(email);
    }

    if (passwordValue === '') {
        setError(password, 'Password is required');
    } else if (passwordValue.length < 8) {
        setError(password, 'Password must be at least 8 characters.');
    } else if (passwordValue === usernameValue){
        setError(password,'Password must not match the username');
    }
    else {
        setSuccess(password);
    }

    if (conPasswordValue === '') {
        setError(conPassword, 'Please confirm your password');
    }
    else {
        setSuccess(conPassword);
    }

    if (birthdayValue === '') {
        setError(birthday, 'DOB is required');
    } else {
        setSuccess(birthday);
    }

    if (genderValue === '') {
        setError(gender, 'Gender is required');
    } else {
        setSuccess(gender);
    }


var datalist = {
    "fullName": nameValue,
    "username": usernameValue,
    "email": emailValue,
    "password": passwordValue,
    "conPassword": conPasswordValue,
    "birthday": birthdayValue,
    "gender": genderValue
}

console.log(JSON.stringify(datalist));

$.ajax({
    url: "/registerUser",
    type: "POST",
    contentType: 'application/json',
    data: JSON.stringify(datalist),
    headers: {
        "Content-Type": "application/json",
    },

    error: function (response) {
        console.log("error:>>> " + response.status);
    },
    success: function (response) {
        var finalval = JSON.parse(response);
        requestId = finalval.response.data[0].request_id;
        console.log("Success" + response);
    }
});

//submitForm();

};
//const submitForm = () => {
//    form.submit();
//};
