$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    userInfoHide();
});

async function editStatusTask(status,id){
    var check1 = document.getElementById("check_1_" + id);
    var check2 = document.getElementById("check_2_" + id);

    var btn1 = document.getElementById("btn_1_" + id);
    var btn2 = document.getElementById("btn_2_" + id);

    const dateNow = new Date(); 
    var d = dateNow.getDate() + "." + String(dateNow.getMonth()+1) + "." + dateNow.getFullYear();
    console.log(d);
    document.getElementById("date_last_update_" + id).textContent = d;

    var data = new FormData();
    await data.append('id', id);

    if(status === 1){
        check1.className +='active';
        btn1.style.display = "none";
        btn2.style.display = "block";
        await data.append('num_status', 2);
    }else{
        check2.className +='active';
        btn2.style.display = "none";
        await data.append('num_status', 3);
    }
    updateStatus(data);
}

async function updateStatus(data){
    let response = await fetch('/update_status_task', {
        method: 'POST',
        body: data
    });
}

async function deleteTask(id){

    var data = new FormData();
    await data.append('id', id);
    

    let response = await fetch('/delete_task', {
        method: 'POST',
        body: data
    });
  
    //   let result = await response.json();
    //   console.log(result);
      location.reload();
}


function userInfoShow(fio,phone,info){

    document.getElementById("see_user_fio").textContent ="ФИО: " + fio;
    document.getElementById("see_user_phone").textContent ="Телефон: " + phone;
    document.getElementById("see_user_more_info").textContent ="Доп. информация: " + info;


    $("#coopPopUpUserInfo").show();
}

function userInfoHide(){
    $("#coopPopUpUserInfo").hide();
}

