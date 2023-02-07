

        const form = [...document.querySelector('.form').children];
 form.forEach((item,i) =>{
    setTimeout(() => {
        item.style.opacity = 1;
    }, i*100);
})


const name = document.querySelector('.name') || null;
const email = document.querySelector('.email');
const password = document.querySelector('.password');
const submitBtn= document.querySelector('.submit-btn');

if(Name == null){
    submitBtn.addEventListener('click',() => {
        fetch('C:\Users\91944\Desktop\cards\web\login.html',{
            method:'post',
            headers:new Headers({'Content-Type':' applications/json'}),
            body:JSON.stringify({
                email:email.value,
                password:password.value
            })
        })
        .then(res => res.json())
        .then(data => {
 validateDate(data);
        })
    })

}else{
    submitBtn.addEventListener('click',() => {
fetch('C:\Users\91944\Desktop\cards\web\register.html',{
    method:'post',
    headers:new Headers({'content-Type':'application/json'}),
    body:JSON.stringify({
        name:name.value,
        email:email.value,
        password:password.value
    })
})
.then(res => res.json())
.then(data => {
validateDate(data);
})
    })
}
const validateDate = (data) => {
    if(!data.name){
        alertBox(data);

    }else{
        sessionStorage.name = data.name;
        sessionStorage.email = data.email;
        location.href = '/'
    }

}

const alertBox = (data) => {
    const alertContainer = document.querySelector('.alert-box');
    const alertMsg = document.querySelector('.alert');
    alertMsg.innerHTML = data;

    alertContainer.style.top = '5%';
    setTimeout(() => {
        alertContainer.style.top = null;
        
    }, 5000);
}

